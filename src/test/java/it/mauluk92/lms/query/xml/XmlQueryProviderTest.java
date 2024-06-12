package it.mauluk92.lms.query.xml;

import it.mauluk92.lms.dto.query.XmlQueryDto;
import it.mauluk92.lms.query.QueryProvider;
import it.mauluk92.lms.validator.schema.XmlSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static it.mauluk92.lms.utils.constants.config.validator.schema.QueryFileSchemaValidatorConfigConstants.QUERY_FILE_SCHEMA_VALIDATOR;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig
public class XmlQueryProviderTest {

    @Qualifier(QUERY_FILE_SCHEMA_VALIDATOR)
    @MockBean
    private XmlSchemaValidator xmlSchemaValidator;

    @Test
    public void whenExecutedCorrectNodeQueryRetrieved() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        QueryProvider queryProvider = new XmlQueryProvider(new ClassPathResource("/test/test-query.xml"), xmlSchemaValidator);
        XmlQueryDto xmlQueryDto = XmlQueryDto.builder()
                .name("TEST_QUERY")
                .value("TEST_VALUE")
                .description("TEST_DESCRIPTION")
                .build();
        XmlQueryDto result = queryProvider.getQuery("TEST_QUERY");
        Assertions.assertEquals(xmlQueryDto.getName(), result.getName());

    }
}
