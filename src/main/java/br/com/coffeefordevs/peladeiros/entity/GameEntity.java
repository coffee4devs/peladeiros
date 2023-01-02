package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "game")
public class GameEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public GameEntity(Date date, String name, String local) {
        setDate(date);
        setName(name);
        setLocal(local);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private Date date;

    @NonNull
    private String name;

    @NonNull
    private String local;

}
