package br.com.caelum.estoque.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by nando on 21/06/17.
 */
public class Serializador {



    public static <T> String toXML(T object, Class<T> clazz) {
        try {
            Marshaller marshaller = JAXBContext.newInstance(clazz).createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromXML(String xml, Class<T> clazz)  {
        try {
            System.out.println(xml);
            Unmarshaller unmarshaller = JAXBContext.newInstance(clazz).createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
