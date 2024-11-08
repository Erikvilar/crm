package com.ltadcrm.ltadcrm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name="Users")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id_users")
    @JsonProperty("id")
    private Long idUsers;
    @Column(name= "name_users")
    @JsonProperty("usuario")
    private String name;
    @Column(name= "type_users")
    @JsonProperty("tipo")
    private String type;
}
