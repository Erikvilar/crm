package com.ltadcrm.ltadcrm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ltadcrm.ltadcrm.repository.ItemsRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("dashboard")
@RestController
public class DashboardController {

   
    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/showAll")
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(itemsRepository.findAllItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro ao processar os items "+e, HttpStatus.OK);
        }
    }

}
