
package com.ltadcrm.ltadcrm.events.Items;



import lombok.Data;

@Data
public class ItemUpdatedEvent {

    private Long itemId;
    private String user;
    private String description;
    private Double price;


    public ItemUpdatedEvent(Long itemId, String user, Double price, String description) {
        this.itemId = itemId;
        this.user = user;
        this.price = price;
        this.description = description;
     
    }

  
}