package org.mrs.teamapi.employee;

import org.mrs.teamapi.team.Team;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Document
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String type;

    private int months;

    private String teamId;

    private String teamName;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String type,
                    int months, String teamId, String teamName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.months = months;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() { return teamName; }

    public void setTeamName(String teamName) { this.teamName = teamName; }
}
