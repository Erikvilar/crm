package com.ltadcrm.ltadcrm.usescases;



import org.springframework.stereotype.Service;

import com.ltadcrm.ltadcrm.repositories.CostCenterRepository;

@Service
public class CostCenterService {


    CostCenterRepository costCenterRepository;
    public CostCenterService(CostCenterRepository costCenterRepository){
        this.costCenterRepository=costCenterRepository;
    }



}
