package org.mrs.teamapi.team;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTeamDTO(@JsonProperty String name) {
}
