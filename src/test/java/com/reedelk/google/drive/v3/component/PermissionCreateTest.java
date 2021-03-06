package com.reedelk.google.drive.v3.component;

import com.google.api.services.drive.model.Permission;
import com.reedelk.google.drive.v3.internal.command.PermissionCreateCommand;
import com.reedelk.runtime.api.message.Message;
import com.reedelk.runtime.api.message.MessageAttributes;
import com.reedelk.runtime.api.script.dynamicvalue.DynamicString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PermissionCreateTest extends AbstractComponentTest {

    @Captor
    protected ArgumentCaptor<PermissionCreateCommand> captor = ArgumentCaptor.forClass(PermissionCreateCommand.class);

    private PermissionCreate component = spy(new PermissionCreate());

    @BeforeEach
    void setUp() {
        super.setUp();
        component.scriptEngine = scriptEngine;
        component.converterService = converterService;
        doReturn(driveApi).when(component).createApi();
    }

    @Test
    void shouldInvokeCommandWithCorrectArguments() {
        // Given
        String emailAddress = "my-test@mydomain.com";
        String fileId = UUID.randomUUID().toString();
        component.setEmailAddress(DynamicString.from(emailAddress));
        component.setFileId(DynamicString.from(fileId));
        component.setSendNotificationEmail(true);
        component.setRole(PermissionRole.READER);
        component.setType(PermissionType.USER);
        component.initialize();

        Permission permission = new Permission();
        doReturn(permission)
                .when(driveApi)
                .execute(any(PermissionCreateCommand.class));

        // When
        component.apply(context, message);

        // Then
        verify(driveApi).execute(captor.capture());
        PermissionCreateCommand value = captor.getValue();

        assertThat(value).hasFieldOrPropertyWithValue("fileId", fileId);
        assertThat(value).hasFieldOrPropertyWithValue("domain", null);
        assertThat(value).hasFieldOrPropertyWithValue("emailAddress", emailAddress);
        assertThat(value).hasFieldOrPropertyWithValue("sendNotificationEmail", true);
        assertThat(value).hasFieldOrPropertyWithValue("type", PermissionType.USER);
        assertThat(value).hasFieldOrPropertyWithValue("role", PermissionRole.READER);
    }

    @Test
    void shouldReturnCorrectPayloadAndAndAttributes() {
        // Given
        String emailAddress = "my-test@mydomain.com";
        String fileId = UUID.randomUUID().toString();
        component.setEmailAddress(DynamicString.from(emailAddress));
        component.setFileId(DynamicString.from(fileId));
        component.setSendNotificationEmail(true);
        component.setRole(PermissionRole.READER);
        component.setType(PermissionType.USER);
        component.initialize();

        String permissionId = UUID.randomUUID().toString();

        Permission permission = new Permission()
                .setId(permissionId)
                .setEmailAddress(emailAddress)
                .setKind("drive#kind")
                .setRole("reader")
                .setType("user");

        doReturn(permission)
                .when(driveApi)
                .execute(any(PermissionCreateCommand.class));

        // When
        Message actual = component.apply(context, message);

        // Then
        String payload = actual.payload();
        assertThat(payload).isEqualTo(permissionId);

        MessageAttributes attributes = actual.getAttributes();
        assertThat(attributes).containsEntry("fileId", fileId);
        assertThat(attributes).containsEntry("id", permissionId);
        assertThat(attributes).containsEntry("kind", "drive#kind");
        assertThat(attributes).containsEntry("role", "reader");
        assertThat(attributes).containsEntry("type", "user");
    }
}