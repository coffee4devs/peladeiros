package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public UserEntity(Integer idPeople, String password) {
        this.idPeople = idPeople;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private Integer idPeople;

    @NonNull
    private String password;

}
