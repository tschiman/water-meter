package com.schimandle.watermeter.users;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID, String>{
    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return uuid == null ? UUID.randomUUID().toString() : uuid.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String uuid) {
        return uuid == null ? null : UUID.fromString(uuid);
    }
}
