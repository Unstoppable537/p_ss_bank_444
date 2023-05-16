package com.bank.publicinfo.model;


import com.bank.publicinfo.serializers.LicenseSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;

@JsonSerialize(using = LicenseSerializer.class)
@Entity
@Table(name="license", schema = "public_bank_information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class License extends BaseClass{
    //лицензии банка
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private byte[] photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankDetailsId", referencedColumnName = "id")
    private BankDetails bankDetails;


}
