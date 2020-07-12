package com.example.workorder.entity;

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
public class Professional extends GenericEntity {

    @NotNull
    @NotEmpty(message = "Nome do usuário é obrigatório")
    private String name;

    private String profession;

}
