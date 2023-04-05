package org.mrs.teamapi;
import org.mrs.teamapi.employee.Employee;
import org.mrs.teamapi.employee.EmployeeDbRepository;
import org.mrs.teamapi.team.Team;
import org.mrs.teamapi.team.TeamDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SharedRepository {
    @Autowired
    TeamDbRepository teamRepo;
    @Autowired
    EmployeeDbRepository empRepo;

    public SharedRepository() {
    }

    public SharedRepository(TeamDbRepository teamRepo, EmployeeDbRepository empRepo) {
        this.teamRepo = teamRepo;
        this.empRepo = empRepo;
    }

    public List<Team> getAllTeams() { return Streamable.of(teamRepo.findAll()).toList(); }

    public Team saveTeam(Team team) { return teamRepo.save(team); }

    public Team getTeam(String id) { return teamRepo.findById(id).orElse(null); }

    public Team getTeamByName(String name) { return teamRepo.findTeamByName(name); }

    public void deleteTeamByName(String name) {
        Team teamToDelete = getTeamByName(name);
        teamRepo.delete(teamToDelete);
    }

    public void deleteTeamById(String id) {
        teamRepo.deleteById(id);
    }

    public List<Employee> getAllEmployees() { return Streamable.of(empRepo.findAll()).toList(); }

    public Employee saveEmployee(Employee employee) { return empRepo.save(employee); }

    public Employee getEmployee(String id) { return empRepo.findById(id).orElse(null); }

    public Employee getEmployeeByFullName(String firstName, String lastName) {
        return empRepo.findEmployeeByFirstNameAndLastName(firstName, lastName);
    }

    public void deleteEmployee(String id) { empRepo.deleteById(id); }

    public List<Employee> getEmployeesByIds(List<String> ids) { return empRepo.findByIdIn(ids); }
}
