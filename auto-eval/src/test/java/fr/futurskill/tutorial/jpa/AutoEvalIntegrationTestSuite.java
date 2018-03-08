package fr.futurskill.tutorial.jpa;


import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

@RunWith(Suite.class)
@Suite.SuiteClasses({HelloIntegrationTestCase.class, ModuleIntegrationCase.class})
public class AutoEvalIntegrationTestSuite {
    private static Client client;

    @BeforeClass
    public static void initClient() {
        client = JerseyClientBuilder.newClient();
    }

    public static WebTarget getWebTarget() {
        return client.target(Constantes.BASE_URL);
    }

    public static WebTarget getBaseRestService() {
        return client.target(Constantes.BASE_URL).path("/rs");
    }
}
