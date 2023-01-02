package br.com.coffeefordevs.peladeiros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer idPeople;
    private Integer invited;

}
