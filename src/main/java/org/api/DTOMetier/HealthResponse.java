package org.api.DTOMetier;

public class HealthResponse {
    private String status;
    private String hostname;
    private String os;
    private String platform;
    private String checked_at;

    public HealthResponse() {}

    public HealthResponse(String status, String hostname, String os, String platform, String checked_at) {
        this.status = status;
        this.hostname = hostname;
        this.os = os;
        this.platform = platform;
        this.checked_at = checked_at;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getHostname() { return hostname; }
    public void setHostname(String hostname) { this.hostname = hostname; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getChecked_at() { return checked_at; }
    public void setChecked_at(String checked_at) { this.checked_at = checked_at; }
}
