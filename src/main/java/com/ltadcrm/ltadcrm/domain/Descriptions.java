package com.ltadcrm.ltadcrm.domain;

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

@Entity(name = "Descriptions")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_description")
public class Descriptions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_description")
    @JsonProperty("id")
    private Long idDescription;
    @Column(name = "model_description")
    @JsonProperty("modelo")
    private String model;
    @Column(name = "brand_description")
    @JsonProperty("marca")
    private String brand;
    @Column(name = "serie_description")
    @JsonProperty("serie")
    private String serie;
    @Column(name = "description_description")
    @JsonProperty("descrição")
    private String description;
    @Column(name = "local_description")
    @JsonProperty("localização")
    private String local;

}
