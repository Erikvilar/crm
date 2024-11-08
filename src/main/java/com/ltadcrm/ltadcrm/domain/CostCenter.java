package com.ltadcrm.ltadcrm.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id_cost_center")
    @JsonProperty("id")
    private Long idCostCenter;
    @Column(name= "name_costCenter")
    @JsonProperty("nome")
    private String name;
    @Column(name= "identification_costCenter")
    @JsonProperty("identificação")
    private String identification;
    @Column(name= "initial_date_costCenter")
    @JsonProperty("data de inicio")
    private Date initialDate;
    @Column(name= "end_date_costCenter")
    @JsonProperty("data de fim")
    private Date endDate;
}
