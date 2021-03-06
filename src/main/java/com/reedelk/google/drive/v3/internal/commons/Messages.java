package com.reedelk.google.drive.v3.internal.commons;

import com.reedelk.runtime.api.commons.FormattedMessage;

public class Messages {

    private Messages() {
    }

    public enum FileDelete implements FormattedMessage {

        GENERIC_ERROR("The file with File ID=[%s] could not be deleted on Google Drive, cause=[%s]."),
        FILE_ID_EMPTY("The File ID was empty: I cannot delete a file from an empty File ID."),
        FILE_ID_NULL("The File ID was null: I cannot delete a file with null ID (DynamicValue=[%s]).");

        private final String message;

        FileDelete(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum FileDownload implements FormattedMessage {

        GENERIC_ERROR("The file with File ID=[%s] could not be downloaded from Google Drive, cause=[%s]."),
        FILE_ID_EMPTY("The File ID was empty: I cannot download a file from an empty File ID."),
        FILE_ID_NULL("The File ID was null: I cannot download a file with null ID (DynamicValue=[%s]).");

        private final String message;

        FileDownload(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum FileList implements FormattedMessage {

        GENERIC_ERROR("Could not list files from Google Drive with configuration " +
                "query=[%s], orderBy=[%s], driveId=[%s], nextPageToken=[%s], pageSize=[%d], cause=[%s].");

        private final String message;

        FileList(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum FileUpdate implements FormattedMessage {

        GENERIC_ERROR("The file with File ID=[%s] could not be updated on Google Drive, cause=[%s]."),
        FILE_ID_NULL("The File ID was null: I cannot update a file with null ID (DynamicValue=[%s])."),
        FILE_ID_EMPTY("The File ID was empty: I cannot update a file from an empty File ID.");

        private final String message;

        FileUpdate(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum FileUpload implements FormattedMessage {

        FILE_NAME_EMPTY("The File name was empty: I cannot upload a file with an empty file name (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not upload file on Google Drive with configuration " +
                "fileName=[%s], fileDescription=[%s], indexableText=[%s], parentFolderId=[%s], cause=[%s].");

        private final String message;

        FileUpload(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum FolderCreate implements FormattedMessage {

        FOLDER_NAME_EMPTY("The Folder name was empty: I cannot create a folder from an empty Folder name."),
        FOLDER_NAME_NULL("The Folder name was empty: I cannot create a folder with an empty name (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not create folder on Google Drive with configuration " +
                "folderName=[%s], parentFolderId=[%s], folderDescription=[%s], cause=[%s].");

        private final String message;

        FolderCreate(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum PermissionCreate implements FormattedMessage {

        FILE_ID_EMPTY("The File ID was empty: I cannot create a permission from an empty File ID."),
        FILE_ID_NULL("The File ID was null: I cannot create a permission for a file with null ID (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not create permission for file on Google Drive with configuration " +
                "fileId=[%s], type=[%s], role=[%s], emailAddress=[%s], domain=[%s], sendNotificationEmail=[%s], cause=[%s].");

        private final String message;

        PermissionCreate(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum PermissionDelete implements FormattedMessage {

        PERMISSION_ID_EMPTY("The Permission ID was empty: I cannot delete a permission from an empty Permission ID."),
        FILE_ID_EMPTY("The File ID was empty: I cannot delete a permission from an empty File ID."),
        PERMISSION_ID_NULL("The Permission ID was null: I cannot delete a permission for a file with null permission ID (DynamicValue=[%s])."),
        FILE_ID_NULL("The File ID was null: I cannot delete a permission for a file with null ID (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not delete permission for file on Google Drive with configuration " +
                "permissionId=[%s], fileId=[%s], cause=[%s].");

        private final String message;

        PermissionDelete(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum PermissionList implements FormattedMessage {

        FILE_ID_EMPTY("The File ID was empty: I cannot list permissions from an empty File ID."),
        FILE_ID_NULL("The File ID was null: I cannot list permissions for a file with null ID (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not list permissions from Google Drive with configuration fileId=[%s], cause=[%s].");

        private final String message;

        PermissionList(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum PermissionUpdate implements FormattedMessage {

        PERMISSION_ID_EMPTY("The Permission ID was empty: I cannot update a permission from an empty Permission ID."),
        FILE_ID_EMPTY("The File ID was empty: I cannot update a permission from an empty File ID."),
        PERMISSION_ID_NULL("The Permission ID was null: I cannot update a permission for a file with null permission ID (DynamicValue=[%s])."),
        FILE_ID_NULL("The File ID was null: I cannot update a permission for a file with null ID (DynamicValue=[%s])."),
        GENERIC_ERROR("Could not update permission for file on Google Drive with configuration " +
                "fileId=[%s], role=[%s], cause=[%s].");

        private final String message;

        PermissionUpdate(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }

    public enum Misc implements FormattedMessage {

        DRIVE_CREDENTIALS_ERROR_GENERIC("Could not create Google Drive Credentials, cause=[%s]"),
        DRIVE_CREDENTIALS_ERROR("Could not create Google Drive Credentials from file path=[%s], cause=[%s]");

        private final String message;

        Misc(String message) {
            this.message = message;
        }

        @Override
        public String template() {
            return message;
        }
    }
}
