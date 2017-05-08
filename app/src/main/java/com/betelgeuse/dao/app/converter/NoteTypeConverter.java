package com.betelgeuse.dao.app.converter;

import com.betelgeuse.dao.app.model.NoteType;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by sajid.shahriar on 5/7/17.
 */

public class NoteTypeConverter implements PropertyConverter<NoteType, String> {
    @Override
    public NoteType convertToEntityProperty(String databaseValue) {
        return NoteType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(NoteType entityProperty) {
        return entityProperty.name();
    }
}