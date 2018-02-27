package fr.futurskill.tutorial.ws;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;
import com.sun.jersey.api.json.JSONMarshaller;
import com.sun.jersey.api.json.JSONUnmarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;

public final class XmlJsonUtils {

    private XmlJsonUtils() {
    }

    /**
     * Deserialize an xml stream to an object
     * @param is
     * @param c
     * @param <E>
     * @return
     * @throws JAXBException
     */
    public static <E> E xmlStreamToObject(final InputStream is, final Class<E> c) throws JAXBException {
        final JAXBContext jc = JAXBContext.newInstance(c);
        final Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (E) unmarshaller.unmarshal(is);
    }

    /**
     * Deserialize a json stream to an object
     * @param is
     * @param c
     * @param <E>
     * @return
     * @throws JAXBException
     */
    public static <E> E jsonStreamToObject(final InputStream is, final Class<E> c) throws JAXBException {
        final JSONJAXBContext jc = new JSONJAXBContext(JSONConfiguration.natural().build(), c);
        final JSONUnmarshaller unmarshaller = jc.createJSONUnmarshaller();
        return unmarshaller.unmarshalFromJSON(is, c);
    }

    /**
     * Serialize an object to xml stream
     * @param o
     * @param os
     * @param <O>
     * @return
     * @throws JAXBException
     */
    public static <O extends OutputStream> O objectToXmlStream(final Object o, final O os) throws JAXBException {
        final JAXBContext jc = JAXBContext.newInstance(o.getClass());
        final Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(o, os);

        return os;
    }

    /**
     * Seriaize an objecyt to json stream
     * @param o
     * @param os
     * @param <O>
     * @return
     * @throws JAXBException
     */
    public static <O extends OutputStream> O objectToJsonStream(final Object o, final O os) throws JAXBException {
        final JSONJAXBContext jc = new JSONJAXBContext(JSONConfiguration.natural().build(), o.getClass());
        final JSONMarshaller marshaller = jc.createJSONMarshaller();
        marshaller.marshallToJSON(o, os);

        return os;
    }
}
