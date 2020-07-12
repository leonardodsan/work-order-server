package com.example.workorder.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**leonardo created on 07/07/2020
*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Device extends GenericEntity {

    @NotNull
    @NotEmpty(message = "Nome do dispositivo é obrigatório")
    private String alias;

    private String type;

    private String manufacturer;

}
