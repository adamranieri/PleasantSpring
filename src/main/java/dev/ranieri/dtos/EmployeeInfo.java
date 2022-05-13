package dev.ranieri.dtos;

public class EmployeeInfo {

    private int eId;
    private String username;

    public EmployeeInfo() {
    }

    public EmployeeInfo(int eId, String username) {
        this.eId = eId;
        this.username = username;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
