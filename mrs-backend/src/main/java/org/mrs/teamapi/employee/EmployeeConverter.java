package org.mrs.teamapi.employee;

public class EmployeeConverter {
    public static TeamEmployeeDTO toDTO(Employee emp) {
        return new TeamEmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getType(),
                emp.getMonths(), emp.getTeamId(), emp.getTeamName());
    }
}
