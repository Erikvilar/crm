package com.ltadcrm.ltadcrm.domain.DTO.domainDTO;

import com.ltadcrm.ltadcrm.domain.Contacts;
import com.ltadcrm.ltadcrm.domain.CostCenter;
import com.ltadcrm.ltadcrm.domain.Descriptions;
import com.ltadcrm.ltadcrm.domain.Users;


public record ItemsDTO(

                Long idUsers,
                String name,
                String observation,
                String type,

                Long itemId,
                String nfInvoiceItem,
                String codeItem,
                String observationItem,
                String pathImageItem,
                String orderOriginItem,
                String sdeItem,
                String statusItem,
                Double valueItem,

                Users user,
                Descriptions description,
                CostCenter costCenter

) {
}