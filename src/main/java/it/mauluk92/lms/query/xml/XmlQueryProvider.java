package it.mauluk92.lms.query.xml;

import it.mauluk92.lms.dto.query.XmlQueryDto;
import it.mauluk92.lms.query.QueryProvider;
import it.mauluk92.lms.validator.schema.XmlSchemaValidator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

import static it.mauluk92.lms.utils.constants.query.xml.QueryXmlProviderConfig.*;

public class XmlQueryProvider implements QueryProvider, InitializingBean {

    private final Document document;
    private final Resource xmlResource;
    private final XPath xPath;
    private final XmlSchemaValidator xmlSchemaValidator;

    public XmlQueryProvider(Resource xmlResource, XmlSchemaValidator xmlSchemaValidator)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        this.document = builder.parse(xmlResource.getInputStream());
        this.xPath = XPathFactory.newInstance().newXPath();
        this.xmlSchemaValidator = xmlSchemaValidator;
        this.xmlResource = xmlResource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!this.xmlSchemaValidator.validate(this.xmlResource)){
            throw new RuntimeException();
        }
    }

    @Override
    public XmlQueryDto getQuery(String queryName) throws XPathExpressionException {
        String expression = String.format(QUERY_X_PATH, queryName);
        XmlQueryDto xmlQueryDto = new XmlQueryDto();
        Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
        for (int index = 0; index < node.getChildNodes().getLength(); index++){
            Node currentNode = node.getChildNodes().item(index);
            String currentNodeName = currentNode.getNodeName();
            switch (currentNodeName) {
                case NAME_FIELD-> xmlQueryDto.setName(currentNode.getTextContent());
                case VALUE_FIELD -> xmlQueryDto.setValue(currentNode.getTextContent());
                case DESCRIPTION_FIELD -> xmlQueryDto.setDescription(currentNode.getTextContent());
            }

        }
        return xmlQueryDto;
    }
}
