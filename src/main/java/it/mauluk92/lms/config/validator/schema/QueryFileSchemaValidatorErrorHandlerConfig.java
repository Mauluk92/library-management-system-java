package it.mauluk92.lms.config.validator.schema;

import it.mauluk92.lms.validator.schema.error.handler.QueryFileSchemaValidatorErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorErrorHandlerConfigConstants.QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER;

@Configuration
public class QueryFileSchemaValidatorErrorHandlerConfig {


    @Bean(QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER)
    public QueryFileSchemaValidatorErrorHandler queryFileSchemaValidatorErrorHandler(){
        return new QueryFileSchemaValidatorErrorHandler();
    }
}
