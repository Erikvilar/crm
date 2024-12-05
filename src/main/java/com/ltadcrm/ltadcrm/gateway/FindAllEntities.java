package com.ltadcrm.ltadcrm.gateway;

import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.domain.InventoryItems;
import com.ltadcrm.ltadcrm.repositories.InventoryItemsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllEntities {

    private final InventoryItemsRepository inventoryRepository;



        public InventoryItems save (InventoryItems inventoryItems) throws Exception{
            try{

                return inventoryItems;
        } 
        catch(Exception e){
            throw new  Exception("");
        }  
    }
    

}
