package com.isi.maven.services.service.imp;

import com.isi.maven.services.service.IcommandeService;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements IcommandeService {
    @Override
    public String getCommande() {
        return "Commande de vehicules " ;
    }

    @Override
    public Integer somme(int a, int b) {
        return a + b;
    }
}
