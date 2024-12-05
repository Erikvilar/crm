package com.ltadcrm.ltadcrm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tb_process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long processID;
    private String enterprise;
    private String termProcess;
    private String typeProcess;
    private String nfInvoice;
    private String supplier;
    private String grant;
    
}
