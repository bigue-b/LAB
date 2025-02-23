package com.isi.maven.services.mapping;

import com.isi.maven.services.dto.AppUser;
import com.isi.maven.services.model.AppUserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-23T17:30:25+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUser toAppUser(AppUserEntity appUserEntity) {
        if ( appUserEntity == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( appUserEntity.getId() );
        appUser.setNom( appUserEntity.getNom() );
        appUser.setPrenom( appUserEntity.getPrenom() );
        appUser.setEmail( appUserEntity.getEmail() );
        appUser.setPassword( appUserEntity.getPassword() );
        appUser.setEtat( appUserEntity.getEtat() );

        return appUser;
    }

    @Override
    public AppUserEntity fromAppUser(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        AppUserEntity appUserEntity = new AppUserEntity();

        appUserEntity.setId( appUser.getId() );
        appUserEntity.setNom( appUser.getNom() );
        appUserEntity.setPrenom( appUser.getPrenom() );
        appUserEntity.setEmail( appUser.getEmail() );
        appUserEntity.setPassword( appUser.getPassword() );
        appUserEntity.setEtat( appUser.getEtat() );

        return appUserEntity;
    }
}
