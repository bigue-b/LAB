package com.isi.maven.services.mapping;

import com.isi.maven.services.dto.Produit;
import com.isi.maven.services.model.ProduitEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-20T23:16:29+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ProduitMapperImpl implements ProduitMapper {

    @Override
    public Produit toProduit(ProduitEntity produitEntity) {
        if ( produitEntity == null ) {
            return null;
        }

        Produit produit = new Produit();

        produit.setId( produitEntity.getId() );
        produit.setNom( produitEntity.getNom() );
        produit.setQtStock( produitEntity.getQtStock() );

        return produit;
    }

    @Override
    public ProduitEntity fromProduit(Produit produit) {
        if ( produit == null ) {
            return null;
        }

        ProduitEntity produitEntity = new ProduitEntity();

        produitEntity.setId( produit.getId() );
        produitEntity.setNom( produit.getNom() );
        produitEntity.setQtStock( produit.getQtStock() );

        return produitEntity;
    }
}
