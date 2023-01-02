package br.com.coffeefordevs.peladeiros.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDTO {

    private Integer idTeam;
    private Integer idPlayer;
    private Integer active;

}
