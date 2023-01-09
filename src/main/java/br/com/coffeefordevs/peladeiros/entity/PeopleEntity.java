package br.com.coffeefordevs.peladeiros.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
public class PeopleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PeopleEntity(String name, String lasName, String phone, String email) {
        this.name = name;
        this.lastName = lasName;
        this.phone = phone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    private String phone;

}
