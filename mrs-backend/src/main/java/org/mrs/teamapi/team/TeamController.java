package org.mrs.teamapi.team;

import org.mrs.teamapi.employee.TeamEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;
    public TeamController(TeamService service) { this.teamService = service; }

    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<TeamResponseDTO> getTeam(@PathVariable String id) {
        return ResponseEntity.ok(teamService.getTeam(id));
    }

    @PostMapping
    public ResponseEntity<TeamResponseDTO> addTeam(@RequestBody CreateTeamDTO dto, HttpServletRequest req) {
        TeamResponseDTO newTeam = teamService.addTeam(
                new Team(UUID.randomUUID().toString(), dto.name(), new ArrayList<>())
        );
        if(newTeam != null) {
            URI location = URI.create((req.getRequestURL() + "/" + newTeam.id())
                    .replace("teams//", "teams/"));
            return ResponseEntity.created(location).body(newTeam);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(path = "{name}")
    public ResponseEntity<TeamResponseDTO> renameTeam(@PathVariable String name,
                                                      @RequestBody CreateTeamDTO dto) {
        TeamResponseDTO updatedTeam = teamService.renameTeam(name, dto.name());
        if(updatedTeam != null) {
            return ResponseEntity.accepted().body(updatedTeam);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "{name}")
    ResponseEntity<Team> deleteTeam(@PathVariable String name) {
      teamService.deleteTeam(name);
      return ResponseEntity.noContent().build();
    }

}
