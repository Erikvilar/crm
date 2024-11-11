package com.ltadcrm.ltadcrm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltadcrm.ltadcrm.domain.CostCenter;
import com.ltadcrm.ltadcrm.domain.Descriptions;
import com.ltadcrm.ltadcrm.domain.DTO.domainDTO.ItemDetailDTO;
import com.ltadcrm.ltadcrm.repository.CostCenterRepository;
import com.ltadcrm.ltadcrm.repository.DescriptionsRepository;
import com.ltadcrm.ltadcrm.repository.ItemsRepository;
import com.ltadcrm.ltadcrm.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RequestMapping("/equipments")
@RestController
public class EquipmentsController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemsRepository itemsRepository;

    @GetMapping("/showAllDetails")
    public ResponseEntity<List<ItemDetailDTO>> showDTO() throws Exception {
        return new ResponseEntity<>(itemService.getItemDetails(), HttpStatus.OK);

    }

  


}
