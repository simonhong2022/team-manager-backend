package org.mrs.teamapi.employee;

import org.mrs.teamapi.SharedRepository;
import org.mrs.teamapi.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    SharedRepository repo;

    public EmployeeService(){
    }

    public EmployeeService(SharedRepository repo) {this.repo = repo;}

    public List<TeamEmployeeDTO> getAllEmployees() {
        return repo.getAllEmployees().stream().map(EmployeeConverter::toDTO).toList();
    }

    public TeamEmployeeDTO getEmployee(String id) { return EmployeeConverter.toDTO(repo.getEmployee(id)); }

    public TeamEmployeeDTO addEmployee(CreateEmployeeDTO dto) {
        Team teamTo = repo.getTeam(dto.teamId());
        Employee employee = new Employee(UUID.randomUUID().toString(), dto.firstName(), dto.lastName(),
                dto.type(), dto.months(), dto.teamId(), teamTo.getName());
        List<String> teamToEmps = teamTo.getEmployees();
        teamToEmps.add(employee.getId());
        teamTo.setEmployees(teamToEmps);
        repo.saveTeam(teamTo);
        return EmployeeConverter.toDTO(repo.saveEmployee(employee));
    }

    public TeamEmployeeDTO changeEmployeeTeam(String teamToId, String empId){
        Employee emp = repo.getEmployee(empId);
        Team teamFrom = repo.getTeam(emp.getTeamId());
        if(teamFrom != null) {
            List<String> teamFromEmps = teamFrom.getEmployees();
            teamFromEmps.remove(empId);
            teamFrom.setEmployees(teamFromEmps);
            repo.saveTeam(teamFrom);
        }

        Team teamTo = repo.getTeam(teamToId);
        List<String> teamToEmps = teamTo.getEmployees();
        teamToEmps.add(empId);
        teamTo.setEmployees(teamToEmps);
        repo.saveTeam(teamTo);
        emp.setTeamId(teamToId);
        emp.setTeamName(teamTo.getName());
        return EmployeeConverter.toDTO(repo.saveEmployee(emp));
    }

    public void deleteEmployee(String id) { repo.deleteEmployee(id); }
}
