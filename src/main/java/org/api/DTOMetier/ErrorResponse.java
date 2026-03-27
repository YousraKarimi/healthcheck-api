package org.api.DTOMetier;

public class ErrorResponse {

    private String error;
    private int status;
    private String checked_at;

    public ErrorResponse() {}

    public ErrorResponse(String error, int status, String checked_at) {
        this.error = error;
        this.status = status;
        this.checked_at = checked_at;
    }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getChecked_at() { return checked_at; }
    public void setChecked_at(String checked_at) { this.checked_at = checked_at; }
}