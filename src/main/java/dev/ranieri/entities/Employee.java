package dev.ranieri.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private int eId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Employee() {
    }

    public Employee(int eId, String username, String password) {
        this.eId = eId;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
