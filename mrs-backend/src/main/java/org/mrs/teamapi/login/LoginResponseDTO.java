package org.mrs.teamapi.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponseDTO(@JsonProperty String name) {
}
