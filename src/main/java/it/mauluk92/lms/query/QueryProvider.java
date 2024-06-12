package it.mauluk92.lms.query;

import it.mauluk92.lms.dto.query.XmlQueryDto;

import javax.xml.xpath.XPathExpressionException;

public interface QueryProvider {

   XmlQueryDto getQuery(String queryName) throws XPathExpressionException;
}
