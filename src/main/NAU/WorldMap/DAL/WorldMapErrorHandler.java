package DAL;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class WorldMapErrorHandler implements ErrorHandler {
    private static Logger logger = LogManager.getLogManager().getLogger("logger");

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.warning(exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.log(Level.SEVERE, exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.log(Level.SEVERE, exception.getMessage());
    }
}
