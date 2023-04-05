package org.mrs.teamapi.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mrs.teamapi.employee.TeamEmployeeDTO;

import java.util.List;

public record TeamResponseDTO(@JsonProperty String id, @JsonProperty String name,
                              @JsonProperty List<TeamEmployeeDTO> employees) {
}
