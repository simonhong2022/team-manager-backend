package org.mrs.teamapi.team;

import org.mrs.teamapi.SharedRepository;
import org.mrs.teamapi.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    SharedRepository repo;

    public TeamService() {
    }

    public TeamService(SharedRepository repo) { this.repo = repo; }

    public List<TeamResponseDTO> getAllTeams() {
        return repo.getAllTeams().stream().map(team -> {
            return TeamConverter.toDTO(team, repo.getEmployeesByIds(team.getEmployees()));
        }).toList();
    }

    public TeamResponseDTO getTeam(String id) {
        Team team = repo.getTeam(id);
        return TeamConverter.toDTO(team, repo.getEmployeesByIds(team.getEmployees()));
    }

    public TeamResponseDTO addTeam(Team team) {
        Team existingTeam = repo.getTeamByName(team.getName());
        if(existingTeam == null) {
            return TeamConverter.toDTO(repo.saveTeam(team), repo.getEmployeesByIds(team.getEmployees()));
        }
        return null;
    }

    public TeamResponseDTO renameTeam(String teamId, String newName) {
        Team team = repo.getTeam(teamId);
        Team existingTeam = repo.getTeamByName(newName);
        if(existingTeam == null) {
            team.setName(newName);
            return TeamConverter.toDTO(repo.saveTeam(team), repo.getEmployeesByIds(team.getEmployees()));
        }
        return null;
    }

    public void deleteTeam(String name) {
        List<String> empIds = repo.getTeamByName(name).getEmployees();
        for(String id : empIds) {
            Employee emp = repo.getEmployee(id);
            if(emp != null) {
                emp.setTeamName("None");
                emp.setTeamId("deleted");
                repo.saveEmployee(emp);
            }
        }
        repo.deleteTeamByName(name);
    }
}
