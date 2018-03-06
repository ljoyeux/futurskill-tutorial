package fr.futurskill.tutorial.jpa;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class HelloIntegrationTest {

    private static Client client;
    private WebTarget target;

    @BeforeClass
    public static void initClient() {
        client = JerseyClientBuilder.newClient();
    }

    @Before
    public void initTarget() {
        target = client.target(Constantes.BASE_URL);
    }

    @Test
    public void hello() {
        String response = target.path("/").request().get(String.class);
        assert response!=null;
        assert response.contains("Hello World!");
    }
}
