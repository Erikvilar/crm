package com.ltadcrm.ltadcrm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_receiving")
public class Receiving {
 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long receivingID;
    private String term;
    private String lotation;
    private String localization;
    private String assign;
    /*
     * should may change this column on next future
     */
    private String empSIAFI;



}
