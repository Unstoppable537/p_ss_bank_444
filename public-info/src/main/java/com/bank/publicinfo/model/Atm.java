package com.bank.publicinfo.model;


import com.bank.publicinfo.serializers.AtmSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalTime;

@JsonSerialize(using = AtmSerializer.class)
@Entity
@Table(name="atm", schema = "public_bank_information")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Atm extends BaseClass{
    //банкоматы банка, привязаны к определенному отделению
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 0, max = 370, message = "address must be not more 370 symbols")
    private String address;
    @Column
    @NotNull
    private LocalTime startOfWork;
    @Column
    @NotNull
    private LocalTime endOfWork;
    @Column
    private boolean allHours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branchId", referencedColumnName = "id")
    private Branch branch;

}
