package com.ltadcrm.ltadcrm.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="CostCenter")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_costCenter")
public class CostCenter {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerID;
    private String name;
    private String identification;
    private Date initialDate;
    private Date endDate;

}
