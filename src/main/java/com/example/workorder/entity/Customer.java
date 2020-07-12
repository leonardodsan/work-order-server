package com.example.workorder.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
public class Customer extends GenericEntity {

    @NotNull
    @NotEmpty(message = "Nome do cliente é obrigatório")
    private String name;

    private String address;

    private String phone;

    private String mail;
}
