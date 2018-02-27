package fr.futurskill.tutorial.rs;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Test;

public class HelloTest {

    @Test
	public void hello() {
		System.out.println("Hello get");
		
		
		Client client = JerseyClientBuilder.newClient();
		
		WebTarget target =
				client.target("http://localhost:8080/rs-server")
						.path("/rs/hello")
						.queryParam("firstName", "Laurent")
						.queryParam("lastName", "Joyeux");
		
		String response = target.request().get(String.class);
		
		System.out.println(response);
	}

	@Test
    public void helloPost() {
        System.out.println("Hello post");
        Client client = JerseyClientBuilder.newClient();

        WebTarget target =
                client.target("http://localhost:8080/rs-server")
                        .path("/rs/hello");

		Account account = new Account();
		account.setFirstName("Laurent");
		account.setLastName("Joyeux");

		Response post = target.request().post(Entity.entity(account, MediaType.APPLICATION_JSON));

		String response = post.readEntity(String.class);

		System.out.println(response);
    }
}
