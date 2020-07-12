package com.example.workorder.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**leonardo created on 07/07/2020
*/
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WorkOrder extends GenericEntity {

    @ManyToOne
    @NotNull
    private Device device;

    @ManyToOne
    @NotNull
    private Customer customer;

    @ManyToOne
    private Professional accountable;

    @NotNull
    @NotBlank
    private String problem;

    @Enumerated
    @NotNull
    private Status status = Status.PENDING;

    private Date startMoment;

    private Date endMoment;

    public enum Status { PENDING, PROGRESS, FINISHED, STOPPED }
}
