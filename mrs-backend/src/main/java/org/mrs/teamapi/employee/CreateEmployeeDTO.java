package org.mrs.teamapi.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEmployeeDTO(@JsonProperty String firstName, @JsonProperty String lastName,
                                @JsonProperty String type, @JsonProperty int months,
                                @JsonProperty String teamId) {
}
