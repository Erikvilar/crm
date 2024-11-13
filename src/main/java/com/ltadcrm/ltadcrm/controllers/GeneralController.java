package com.ltadcrm.ltadcrm.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.usescases.GeneralService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("general")
@RestController

public class GeneralController {

    GeneralService generalService;

    public GeneralController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ItemDetailDTO>> showAllDTO() throws Exception {
        return new ResponseEntity<>(generalService.getItemDetails(), HttpStatus.OK);

    }

    @PutMapping("/save")
    public ResponseEntity<String> postMethodName(@RequestBody @Valid UpdateDTO updateDTO) {
        try {
            generalService.updateAllItems(updateDTO);
            return ResponseEntity.ok("Sucesso ao salvar items");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar item: " + e.getMessage());
        }

    }

}
