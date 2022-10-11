package kz.oskarbay.restservicebackend.models.validator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUserValidator {
    Long id;

    String url;

    String fullName;

    String email;

    boolean online;
}
