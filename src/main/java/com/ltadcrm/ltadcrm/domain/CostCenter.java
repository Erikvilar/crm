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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cdc")
public class CostCenter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idCostCenter;
    private String name;
    private String identification;
    private Date initialDate;
    private Date endDate;
}
