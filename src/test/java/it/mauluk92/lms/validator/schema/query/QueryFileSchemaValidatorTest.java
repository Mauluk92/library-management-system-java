package it.mauluk92.lms.validator.schema.query;

import it.mauluk92.lms.config.validator.schema.QueryFileSchemaValidatorConfig;
import it.mauluk92.lms.validator.schema.error.handler.QueryFileSchemaValidatorErrorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.IOException;

import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorErrorHandlerConfigConstants.QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER;
import static it.mauluk92.lms.utils.constants.validator.schema.query.QueryFileSchemaValidatorTestConstants.QUERY_XSD_FILE_PATH;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig
@ContextConfiguration(classes = {
        QueryFileSchemaValidatorConfig.class
})
public class QueryFileSchemaValidatorTest {

    @Autowired
    private QueryFileSchemaValidator queryFileSchemaValidator;
    @MockBean
    @Qualifier(QUERY_FILE_SCHEMA_VALIDATOR_ERROR_HANDLER)
    private QueryFileSchemaValidatorErrorHandler errorHandler;

    @Test
    public void whenCorrectXmlFileValidateCorrectly() throws IOException {
        Resource resource = new ClassPathResource(QUERY_XSD_FILE_PATH);
        Assertions.assertTrue(queryFileSchemaValidator.validate(resource));
    }

}
