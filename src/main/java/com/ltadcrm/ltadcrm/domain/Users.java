package com.ltadcrm.ltadcrm.domain;




import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


@Data
@Table(name="tb_users")
public class Users {

  
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String coResponsable;
    private String solicitor;
    private String userType;
    private String lastModification;
}
