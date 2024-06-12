package it.mauluk92.lms.config.validator.schema;

import it.mauluk92.lms.validator.schema.query.QueryFileSchemaValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.IOException;

import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorConfigConstants.*;
import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorErrorHandlerConfigConstants.QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER;

@Configuration
public class QueryFileSchemaValidatorConfig {



    @Bean(QUERY_FILE_SCHEMA_VALIDATOR)
    public QueryFileSchemaValidator queryFileSchemaValidator(
            @Qualifier(QUERY_FILE_XSD_RESOURCE) Resource schemaResource,
            @Qualifier(QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER) ErrorHandler errorHandler

    ) throws IOException, SAXException {
        return new QueryFileSchemaValidator(schemaResource, errorHandler);
    }

    @Bean(QUERY_FILE_XSD_RESOURCE)
    public Resource schemaResource(){
        return new ClassPathResource(QUERY_FILE_SCHEMA_FILE_PATH);
    }
}
