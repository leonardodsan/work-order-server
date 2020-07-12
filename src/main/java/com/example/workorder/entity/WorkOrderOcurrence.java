package com.example.workorder.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class WorkOrderOcurrence extends GenericEntity {

    @ManyToOne
    @NotNull
    private WorkOrder workOrder;

    @NotNull
    @NotEmpty
    private String description;

}
