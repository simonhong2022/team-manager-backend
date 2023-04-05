package org.mrs.teamapi.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequestDTO(@JsonProperty String username, @JsonProperty String password) {
}
