package xml_exercise.utils;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import java.io.FileNotFoundException;

public interface XmlParser {
    <T> T unmarshalFromFiles(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;
    <T> void marshalToFile(String filePath, T rootDto) throws JAXBException;
}
