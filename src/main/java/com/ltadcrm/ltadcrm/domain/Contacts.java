package com.ltadcrm.ltadcrm.domain;

import java.io.Serializable;

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


@Entity(name="Contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name= "tb_contact")
public class Contacts implements Serializable{
   

    @Column(name= "id_contact")
    @JsonProperty("id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "email_contact")
    @JsonProperty("email")
    private String email;
    @Column(name= "phone_contact")
    @JsonProperty("telefone")
    private String phone;
    @Column(name= "occupation_contact")
    @JsonProperty("ocupação")
    private String occupation;
    

    
}
