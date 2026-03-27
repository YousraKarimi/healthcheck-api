package org.api.DTOMetier;

public class IncidentInfo {

    private String id;
    private String severity;
    private String message;

    public IncidentInfo(String id, String severity, String message) {
        this.id = id;
        this.severity = severity;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }
}