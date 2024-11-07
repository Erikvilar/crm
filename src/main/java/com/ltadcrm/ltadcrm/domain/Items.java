package com.ltadcrm.ltadcrm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_items")
public class Items {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id_items")
    @JsonProperty("id")
    private Long idItems;
    @Column(name= "code_item")
    @JsonProperty("patrimonio")
    private String number;
    @Column(name= "observation_item")
    @JsonProperty("observação")
    private String observation;
    @Column(name= "pathImage_item")
    @JsonProperty("Image")
    private String pathImage;
    @Column(name= "sde_item")
    @JsonProperty("SDE")
    private Long sde;
    @Column(name= "orderOrigin_item")
    @JsonProperty("Pedido")
    private String pedido;
    @Column(name= "status_item")
    @JsonProperty("status")
    private String status;
    @Column(name= "nf_invoice_item")
    @JsonProperty("NF_INVOICE")
    private String nfInvoice;

    private Double value;
    /*
     * @Definindo relacionamentos para a a tabela items(Patrimonios)
     */
    @ManyToOne
    @JoinColumn(name = "idDescriptions")
    private Descriptions descriptions;
    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "idCostCenter")
    private CostCenter costCenter;

}
