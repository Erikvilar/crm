package com.ltadcrm.ltadcrm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descriptions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idDescriptions;
    private String model;
    private String brand;
    private String serie;
    private String description;
    private String local;

}
