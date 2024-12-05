package com.ltadcrm.ltadcrm.domain;

import java.time.LocalDateTime;






import jakarta.persistence.CascadeType;


import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;





@Data
@Table(name = "tb_inventoryItems")
public class InventoryItems{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long inventoryID;
    private String codePatrimony;
    private String especification;
    private String pathImage;
    private Long sde;
    private String order;
    private String status;
    private String nfInvoice;
    private Double unityValue;
    private String userLastupdate;
    private LocalDateTime updateIn;

    /*
     * @Definindo relacionamentos para a a tabela items(Patrimonios)
     */
   
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_users")
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "receivingID")
    private Receiving receiving;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_costCenter")
    private CostCenter costCenter;

}
