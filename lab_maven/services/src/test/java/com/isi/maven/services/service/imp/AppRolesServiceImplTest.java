package com.isi.maven.services.service.imp;

import com.isi.maven.services.dto.AppRoles;
import com.isi.maven.services.exception.RequestException;
import com.isi.maven.services.mapping.AppRolesMapper;
import com.isi.maven.services.model.AppRolesEntity;
import com.isi.maven.services.repository.IAppRolesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppRolesServiceImplTest {

    @Mock
    private IAppRolesRepository iAppRolesRepository;
    @Mock
    private AppRolesMapper appRolesMapper;
    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private AppRolesServiceImpl appRolesService;

    @Test
    void getAppRoles_ShouldReturnAllRoles() {
        var entityRoleEntity = new AppRolesEntity();
        var dtoRole = new AppRoles();

        when(iAppRolesRepository.findAll()).thenReturn(List.of(entityRoleEntity));
        when(appRolesMapper.toAppRoles(entityRoleEntity)).thenReturn(dtoRole);

        List<AppRoles> result = appRolesService.getAppRoles();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iAppRolesRepository).findAll();
    }

    @Test
    void getAppRole_WithValidId_ShouldReturnRole() {
        int id = 1;
        var dtoRole = new AppRoles();
        var entityRoleEntity = new AppRolesEntity();

        when(iAppRolesRepository.findById(id)).thenReturn(Optional.of(entityRoleEntity));
        when(appRolesMapper.toAppRoles(entityRoleEntity)).thenReturn(dtoRole);

        AppRoles result = appRolesService.getAppRole(id);

        assertNotNull(result);
        verify(iAppRolesRepository).findById(id);
    }

    @Test
    void getAppRole_WithInvalidId_ShouldThrowEntityNotFoundException() {
        int id = 999;
        when(iAppRolesRepository.findById(id)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("role.notfound"), any(), eq(Locale.getDefault())))
                .thenReturn("Role not found");

        assertThrows(EntityNotFoundException.class, () -> appRolesService.getAppRole(id));

        verify(iAppRolesRepository).findById(id);
    }

    @Test
    void createAppRoles_ShouldReturnCreatedRole() {
        var dtoRole = new AppRoles();
        var entityRoleEntity = new AppRolesEntity();


        when(appRolesMapper.fromAppRoles(dtoRole)).thenReturn(entityRoleEntity);
        when(iAppRolesRepository.save(entityRoleEntity)).thenReturn(entityRoleEntity);
        when(appRolesMapper.toAppRoles(entityRoleEntity)).thenReturn(dtoRole);

        AppRoles result = appRolesService.createAppRoles(dtoRole);

        assertNotNull(result);
        verify(iAppRolesRepository).save(entityRoleEntity);
    }

    @Test
    void updateAppRoles_WithValidId_ShouldReturnUpdatedRole() {
        int id = 1;
        var dtoRole = new AppRoles();
        var entityRoleEntity = new AppRolesEntity();


        when(iAppRolesRepository.findById(id)).thenReturn(Optional.of(entityRoleEntity));
        when(appRolesMapper.fromAppRoles(dtoRole)).thenReturn(entityRoleEntity);
        when(iAppRolesRepository.save(entityRoleEntity)).thenReturn(entityRoleEntity);
        when(appRolesMapper.toAppRoles(entityRoleEntity)).thenReturn(dtoRole);

        AppRoles result = appRolesService.updateAppRoles(id, dtoRole);

        assertNotNull(result);
        verify(iAppRolesRepository).findById(id);
        verify(iAppRolesRepository).save(entityRoleEntity);
    }

    @Test
    void updateAppRoles_WithInvalidId_ShouldThrowEntityNotFoundException() {
        int id = 999;
        var dtoRole = new AppRoles();


        when(iAppRolesRepository.findById(id)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("role.notfound"), any(), eq(Locale.getDefault())))
                .thenReturn("Role not found");

        assertThrows(EntityNotFoundException.class, () -> appRolesService.updateAppRoles(id, dtoRole));

        verify(iAppRolesRepository).findById(id);
        verify(iAppRolesRepository, never()).save(any());
    }

    @Test
    void deleteAppRoles_WithValidId_ShouldDeleteRole() {
        int id = 1;
        var entityRoleEntity = new AppRolesEntity();

        when(iAppRolesRepository.findById(id)).thenReturn(Optional.of(entityRoleEntity));
        doNothing().when(iAppRolesRepository).deleteById(id);

        appRolesService.deleteAppRoles(id);

        verify(iAppRolesRepository).findById(id);
        verify(iAppRolesRepository).deleteById(id);
    }

    @Test
    void deleteAppRoles_WithInvalidId_ShouldThrowRequestException() {
        int id = 99;

        when(iAppRolesRepository.findById(id)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("role.errordeletion"), any(), eq(Locale.getDefault())))
                .thenReturn("Error deleting role");

        assertThrows(RequestException.class, () -> appRolesService.deleteAppRoles(id));

        verify(iAppRolesRepository).findById(id);
        verify(iAppRolesRepository, never()).deleteById(any());
    }
}
