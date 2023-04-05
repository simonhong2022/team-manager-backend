package org.mrs.teamapi.team;

import org.mrs.teamapi.employee.Employee;
import org.mrs.teamapi.employee.TeamEmployeeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TeamConverter {
    public static TeamResponseDTO toDTO(Team team, List<Employee> emps) {
        List<TeamEmployeeDTO> employees = emps.stream()
                .map(emp -> {
                    return new TeamEmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(),
                            emp.getType(), emp.getMonths(), emp.getTeamId(), emp.getTeamName());
                }).toList();
        return new TeamResponseDTO(team.getId(), team.getName(), employees);
    }

    public static Team fromDTO(TeamResponseDTO dto) {
        List<String> employees = dto.employees().stream()
                .map(TeamEmployeeDTO::id).collect(Collectors.toList());
        return new Team(dto.id(), dto.name(), employees);
    }

}
