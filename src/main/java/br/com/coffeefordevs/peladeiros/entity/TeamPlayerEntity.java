package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teamplayer")
public class TeamPlayerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public TeamPlayerEntity(Integer idTeam, Integer idPlayer, Integer active) {
        setIdTeam(idTeam);
        setIdPlayer(idPlayer);
        setActive(active);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private Integer idTeam;

    @NonNull
    private Integer idPlayer;

    @NonNull
    private Integer active = 1;

}
