package com.isi.maven.services.mapping;

import com.isi.maven.services.dto.AppRoles;
import com.isi.maven.services.model.AppRolesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-23T17:30:25+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class AppRolesMapperImpl implements AppRolesMapper {

    @Override
    public AppRoles toAppRoles(AppRolesEntity appRolesEntity) {
        if ( appRolesEntity == null ) {
            return null;
        }

        AppRoles appRoles = new AppRoles();

        appRoles.setId( appRolesEntity.getId() );
        appRoles.setNom( appRolesEntity.getNom() );

        return appRoles;
    }

    @Override
    public AppRolesEntity fromAppRoles(AppRoles appRoles) {
        if ( appRoles == null ) {
            return null;
        }

        AppRolesEntity appRolesEntity = new AppRolesEntity();

        appRolesEntity.setId( appRoles.getId() );
        appRolesEntity.setNom( appRoles.getNom() );

        return appRolesEntity;
    }
}
