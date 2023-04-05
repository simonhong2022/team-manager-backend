package org.mrs.teamapi.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TeamEmployeeDTO(@JsonProperty String id, @JsonProperty String firstName,
                              @JsonProperty String lastName, @JsonProperty String type,
                              @JsonProperty int months, @JsonProperty String teamId,
                              @JsonProperty String teamName) {
}
