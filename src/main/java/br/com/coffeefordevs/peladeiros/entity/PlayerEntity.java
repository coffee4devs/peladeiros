package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player")
public class PlayerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PlayerEntity(Integer idPeople, Integer invited) {
        setIdPeople(idPeople);
        setInvited(invited);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private Integer idPeople;

    @NonNull
    private Integer invited = 0;

}
