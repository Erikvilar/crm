package com.ltadcrm.ltadcrm.domain;

import java.io.Serializable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;



@Data
@Table(name = "tb_contact")
public class Contacts implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactID;

    private String email;

    private String phone;

    private String occupation;


}
