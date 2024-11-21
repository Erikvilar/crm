package com.ltadcrm.ltadcrm.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltadcrm.ltadcrm.domain.DTO.authentication.RegisterDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.UpdateDTO;
import com.ltadcrm.ltadcrm.usescases.GeneralService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping("general")
@RestController

public class GeneralController {

    GeneralService generalService;

    public GeneralController(GeneralService generalService) {
        this.generalService = generalService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDetailDTO>> showAllDTO() throws Exception {
        return new ResponseEntity<>(generalService.listAll(), HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<String> postMethodName(@RequestBody @Valid UpdateDTO updateDTO, RegisterDTO registerDTO) {

        try {
            updateDTO.setUserLogged(registerDTO.login());
            generalService.updateAllItems(updateDTO);
            return ResponseEntity.ok("Sucesso ao salvar items");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar item: " + e.getMessage());
        }

    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMethod(@RequestBody UpdateDTO updateDTO) {

        try{
            generalService.createItem(updateDTO);
            return ResponseEntity.ok("dados salvos");
        }catch(Exception e){
            
            return ResponseEntity.badRequest().body("ocorreu um erro "+e);
            
        }
    }   
    
 @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        try {
           generalService.deleteItem(id); // Chama o método do serviço para deletar o item
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content em caso de sucesso
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado"); // Retorna 404 se o item não for encontrado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao tentar deletar item: " + e.getMessage());
        }
    }
}
