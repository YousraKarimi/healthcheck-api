package org.api.services;

import org.api.DTO.IncidentInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AlertService {

    @Value("${monitoring.api.url}")
    private String baseUrl;

    @Value("${monitoring.api.token}")
    private String token;

    @Value("${monitoring.api.application-id}")
    private String applicationId;

    private final RestTemplate restTemplate = new RestTemplate();

    public IncidentInfo sendAlert(String type, double value, String hostname) {

        String severity = getSeverity(value);

        if (severity == null) return null;

        Map<String, String> body = new HashMap<>();

        body.put("title", "ALERTE " + type + " — Utilisation à " + value + "%");
        body.put("description", "Serveur " + hostname + " utilisation " + type + " = " + value + "%");
        body.put("application_id", String.valueOf(applicationId));
        body.put("status", "OPEN");
        body.put("severity", severity);
        body.put("start_date", LocalDateTime.now().toString());
        System.out.println("BODY SENT: " + body);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    baseUrl + "/incidents",
                    request,
                    Map.class
            );

            Map responseBody = response.getBody();

            if (responseBody == null || responseBody.get("data") == null) {
                return null;
            }

            Map data = (Map) responseBody.get("data");

            return new IncidentInfo(
                    data.get("id").toString(),
                    data.get("severity").toString(),
                    "Incident created"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getSeverity(double value) {
        if (value > 90) return "CRITICAL";
        if (value > 60) return "HIGH";
        if (value > 30) return "LOW";
        return null;
    }
}