package br.com.coffeefordevs.peladeiros.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CodeEnum {
    SUCCESS(00, "SUCCESS"),
    PEOPLE_NOT_FOUND(41, "PEOPLE NOT FOUND"),
    TEAM_NOT_FOUND(42, "TEAM NOT FOUND"),
    PLAYER_NOT_FOUND(43, "PLAYER NOT FOUND");

    private Integer cod;
    private String message;

}
