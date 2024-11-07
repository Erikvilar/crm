package com.ltadcrm.ltadcrm.domain;

import java.io.Serializable;

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
@Table(name= "contato")
public class Contacts implements Serializable{
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idContacts;
    private String email;
    private String phone;
    private String occupation;

    
}
