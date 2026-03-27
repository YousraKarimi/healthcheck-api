package org.api.DTOMetier;

public class CpuResponse {
    private double total_usage_percent;
    private int logical_cores;
    private int physical_cores;
    private String checked_at;

    private boolean alert_triggered;
    private IncidentInfo incident;

    public CpuResponse() {}

    public CpuResponse(double total_usage_percent, int logical_cores, int physical_cores, String checked_at) {
        this.total_usage_percent = total_usage_percent;
        this.logical_cores = logical_cores;
        this.physical_cores = physical_cores;
        this.checked_at = checked_at;
    }

    public double getTotal_usage_percent() { return total_usage_percent; }
    public void setTotal_usage_percent(double total_usage_percent) { this.total_usage_percent = total_usage_percent; }

    public int getLogical_cores() { return logical_cores; }
    public void setLogical_cores(int logical_cores) { this.logical_cores = logical_cores; }

    public int getPhysical_cores() { return physical_cores; }
    public void setPhysical_cores(int physical_cores) { this.physical_cores = physical_cores; }

    public String getChecked_at() { return checked_at; }
    public void setChecked_at(String checked_at) { this.checked_at = checked_at; }

    public boolean isAlert_triggered() { return alert_triggered; }
    public void setAlert_triggered(boolean alert_triggered) { this.alert_triggered = alert_triggered; }

    public IncidentInfo getIncident() { return incident; }
    public void setIncident(IncidentInfo incident) { this.incident = incident; }
}
