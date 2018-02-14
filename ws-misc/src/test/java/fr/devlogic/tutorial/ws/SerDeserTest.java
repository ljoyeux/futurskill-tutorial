package fr.devlogic.tutorial.ws;

import fr.devlogic.tutorial.ws.model.Account;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SerDeserTest {


    @Test
    public void xml() throws JAXBException {
        System.out.println("Serialization and Deserialization using xml format");

        final Account account = new Account();
        account.setFirstName("Laurent");
        account.setLastName("Joyeux");
        account.setLogin("ljoyeux");

        System.out.println(account);


        final String xml = XmlJsonUtils.objectToXmlStream(account, new ByteArrayOutputStream()).toString();
        System.out.println("XML");
        System.out.println(xml);


        final Account deserializedAccount = XmlJsonUtils.xmlStreamToObject(new ByteArrayInputStream(xml.getBytes()), Account.class);
        System.out.println(deserializedAccount);


        assert account.equals(deserializedAccount);

        System.out.println("=========================");
    }

    @Test
    public void json() throws JAXBException {
        System.out.println("Serialization and Deserialization using json format");

        final Account account = new Account();
        account.setFirstName("Laurent");
        account.setLastName("Joyeux");
        account.setLogin("ljoyeux");

        System.out.println(account);


        final String json = XmlJsonUtils.objectToJsonStream(account, new ByteArrayOutputStream()).toString();
        System.out.println("JSON");
        System.out.println(json);


        final Account deserializedAccount = XmlJsonUtils.jsonStreamToObject(new ByteArrayInputStream(json.getBytes()), Account.class);
        System.out.println(deserializedAccount);

        assert account.equals(deserializedAccount);
        System.out.println("=========================");
    }
}
