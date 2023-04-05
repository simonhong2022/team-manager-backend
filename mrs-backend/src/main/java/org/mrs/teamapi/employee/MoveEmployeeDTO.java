package org.mrs.teamapi.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MoveEmployeeDTO(@JsonProperty String empId, @JsonProperty String teamToId) {
}
