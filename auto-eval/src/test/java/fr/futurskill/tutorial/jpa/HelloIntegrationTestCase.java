package fr.futurskill.tutorial.jpa;

import org.junit.Test;

public class HelloIntegrationTestCase {

    @Test
    public void ping() {
        String response = AutoEvalIntegrationTestSuite.getWebTarget().path("/").request().get(String.class);
        assert response!=null;
        assert response.contains("Hello World!");

        System.out.println("Server is ALIVE and the application is deployed");
    }
}
