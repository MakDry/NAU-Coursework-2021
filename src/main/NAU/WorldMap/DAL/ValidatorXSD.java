package DAL;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

class ValidatorXSD {
    static void validator() {
        String fileName = "resources\\XMLdata.xml";
        String schemaName = "resources\\WorldMap.xsd";

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new WorldMapErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
        }
    }
}