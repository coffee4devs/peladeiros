package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
public class TeamEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public TeamEntity(String name) {
        setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

}
