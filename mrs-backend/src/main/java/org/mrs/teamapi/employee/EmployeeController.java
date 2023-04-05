package org.mrs.teamapi.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService service) { this.empService = service; }

    @GetMapping
    public ResponseEntity<List<TeamEmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(empService.getAllEmployees());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TeamEmployeeDTO> getEmployee(@PathVariable String id) {
        return ResponseEntity.ok(empService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<TeamEmployeeDTO> addEmployee(@RequestBody CreateEmployeeDTO dto, HttpServletRequest req) {
        TeamEmployeeDTO newEmployee = empService.addEmployee(dto);
        URI location = URI.create((req.getRequestURL() + "/" + newEmployee.id())
                .replace("employees//", "employees/"));
        return ResponseEntity.created(location).body(newEmployee);
    }

    @PutMapping
    public ResponseEntity<TeamEmployeeDTO> moveEmployee(@RequestBody MoveEmployeeDTO dto) {
        return ResponseEntity.accepted().body(empService.changeEmployeeTeam(dto.teamToId(), dto.empId()));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<TeamEmployeeDTO> deleteEmployee(@PathVariable String id) {
        empService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
