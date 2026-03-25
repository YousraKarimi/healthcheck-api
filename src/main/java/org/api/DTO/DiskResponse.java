package org.api.DTO;

public class DiskResponse {
    private double total_gb;
    private double used_gb;
    private double free_gb;
    private double used_percent;
    private String checked_at;

//    private boolean alert_triggered;
//    private IncidentInfo incident;

    public DiskResponse() {}

    public DiskResponse(double total_gb, double used_gb, double free_gb, double used_percent, String checked_at) {
        this.total_gb = total_gb;
        this.used_gb = used_gb;
        this.free_gb = free_gb;
        this.used_percent = used_percent;
        this.checked_at = checked_at;
    }

    public double getTotal_gb() { return total_gb; }
    public void setTotal_gb(double total_gb) { this.total_gb = total_gb; }

    public double getUsed_gb() { return used_gb; }
    public void setUsed_gb(double used_gb) { this.used_gb = used_gb; }

    public double getFree_gb() { return free_gb; }
    public void setFree_gb(double free_gb) { this.free_gb = free_gb; }

    public double getUsed_percent() { return used_percent; }
    public void setUsed_percent(double used_percent) { this.used_percent = used_percent; }

    public String getChecked_at() { return checked_at; }
    public void setChecked_at(String checked_at) { this.checked_at = checked_at; }

//    public boolean isAlert_triggered() { return alert_triggered; }
//    public void setAlert_triggered(boolean alert_triggered) { this.alert_triggered = alert_triggered; }
//
//    public IncidentInfo getIncident() { return incident; }
//    public void setIncident(IncidentInfo incident) { this.incident = incident; }
}
