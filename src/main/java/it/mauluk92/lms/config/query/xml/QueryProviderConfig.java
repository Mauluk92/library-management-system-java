package it.mauluk92.lms.config.query.xml;

import it.mauluk92.lms.query.xml.XmlQueryProvider;
import it.mauluk92.lms.validator.schema.XmlSchemaValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static it.mauluk92.lms.utils.constants.config.query.xml.QueryProviderConfigConstants.*;
import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorConfigConstants.QUERY_FILE_SCHEMA_VALIDATOR;

@Configuration
public class QueryProviderConfig {


    @Bean(BOOK_QUERY_PROVIDER)
    public XmlQueryProvider bookXmlQueryProvider(
            @Qualifier(BOOK_QUERY_FILE_RESOURCE) Resource bookQueryFileResource,
            @Qualifier(QUERY_FILE_SCHEMA_VALIDATOR) XmlSchemaValidator xmlSchemaValidator
    ) throws ParserConfigurationException, IOException, SAXException {
        return new XmlQueryProvider(bookQueryFileResource, xmlSchemaValidator);
    }

    @Bean(BOOK_QUERY_FILE_RESOURCE)
    public Resource bookResource(){
        return new ClassPathResource(BOOK_QUERY_FILE_PATH);
    }
}
