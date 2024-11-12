package com.ltadcrm.ltadcrm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Items")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_items")
@Data
public class Items {

    @Column(name= "id_items")
    @JsonProperty("id_items")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "code_item")
    @JsonProperty("patrimonio")
    private String number;
    @Column(name= "observation_item")
    @JsonProperty("observação")
    private String observation;
    @Column(name= "pathImage_item")
    @JsonProperty("imagem")
    private String pathImage;
    @Column(name= "sde_item")
    @JsonProperty("SDE")
    private Long sde;
    @Column(name= "orderOrigin_item")
    @JsonProperty("pedido")
    private String order;
    @Column(name= "status_item")
    @JsonProperty("status")
    private String status;
    @Column(name= "nf_invoice_item")
    @JsonProperty("NF_INVOICE")
    private String nfInvoice;
    @Column(name= "value_item")
    @JsonProperty("valor")
    private Double value;
    /*
     * @Definindo relacionamentos para a a tabela items(Patrimonios)
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_description")
    private Descriptions descriptions;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_users")
    private Users users;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_costCenter")
    private CostCenter costCenter;

}
