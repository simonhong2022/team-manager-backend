package org.mrs.teamapi.team;

import org.mrs.teamapi.employee.Employee;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Document
public class Team {

    @Id
    private String id;

    private String name;

    private List<String> employees;

    public Team() {
    }

    public Team(String id, String name, List<String> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) { this.employees = employees; }
}
