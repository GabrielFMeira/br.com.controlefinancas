package br.com.controlefinancas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class AppInitializationService implements ApplicationListener<ContextRefreshedEvent> {

    BillService billService;

    @Autowired
    public AppInitializationService(BillService billService) {
        this.billService = billService;
    }

    public void onApplicationEvent(ContextRefreshedEvent event){
        billService.updateBillExpiring();
    }
}
