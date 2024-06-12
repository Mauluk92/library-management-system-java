package it.mauluk92.lms.validator.schema.query;

import it.mauluk92.lms.validator.schema.XmlSchemaValidator;
import org.springframework.core.io.Resource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class QueryFileSchemaValidator implements XmlSchemaValidator {

    private final Validator validator;

    public QueryFileSchemaValidator(Resource schemaResource, ErrorHandler errorHandler) throws IOException, SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaResource.getFile());
        schemaFactory.setErrorHandler(errorHandler);
        this.validator = schema.newValidator();
    }

    @Override
    public boolean validate(Resource xmlToValidateResource) throws IOException {
        Source schemaFile = new StreamSource(xmlToValidateResource.getFile());
        try{
            this.validator.validate(schemaFile);
            return true;
        } catch (SAXException saxException){
            return false;
        }
    }
}
