package com.reedelk.google.drive.v3.internal.attribute;

import com.reedelk.runtime.api.annotation.Type;
import com.reedelk.runtime.api.annotation.TypeProperty;
import com.reedelk.runtime.api.message.MessageAttributes;

import static com.reedelk.google.drive.v3.internal.attribute.FileDeleteAttributes.ID;

@Type
@TypeProperty(name = ID, type = String.class)
public class FileDeleteAttributes extends MessageAttributes {

    static final String ID = "id";

    public FileDeleteAttributes(String fileId) {
        put(ID, fileId);
    }
}
