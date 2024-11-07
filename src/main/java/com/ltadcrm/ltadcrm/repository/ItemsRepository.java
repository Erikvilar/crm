package com.ltadcrm.ltadcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltadcrm.ltadcrm.domain.Items;
import com.ltadcrm.ltadcrm.domain.DTO.ItemsDTO;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    @Query("SELECT new com.example.PatrimonioDTO(" +
            "p.idPtr, p.nPtr, d.modeloPtr, d.marcaPtr, d.seriePtr, d.descriPtr, d.locPtr, " +
            "u.Usuario, u.tipo, c.nomeCdc, c.siglaCdc, c.dataIniCdc, c.dataFimCdc) " +
            "FROM Patrimonio p " +
            "JOIN p.descricao d " +
            "JOIN p.usuario u " +
            "JOIN p.cdc c")
            
    List<ItemsDTO> findAllItemsDTOs();

}
