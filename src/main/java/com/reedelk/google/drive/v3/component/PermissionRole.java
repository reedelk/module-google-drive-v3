package com.reedelk.google.drive.v3.component;

import com.google.api.services.drive.model.Permission;
import com.reedelk.runtime.api.annotation.DisplayName;

public enum PermissionRole {

    @DisplayName("Owner")
    OWNER("owner"),
    @DisplayName("Writer")
    WRITER("writer"),
    @DisplayName("Commenter")
    COMMENTER("commenter"),
    @DisplayName("Reader")
    READER("reader");

    private final String value;

    PermissionRole(String value) {
        this.value = value;
    }

    public void set(Permission permission) {
        permission.setRole(value);
    }
}
