package com.ltadcrm.ltadcrm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="db_users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idUsers;
    private String name;
    private String type;
}
