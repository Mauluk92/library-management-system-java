package it.mauluk92.lms.validator.schema;

import org.springframework.core.io.Resource;

import java.io.IOException;

public interface XmlSchemaValidator {

    boolean validate(Resource xmlToValidateResource) throws IOException;
}
