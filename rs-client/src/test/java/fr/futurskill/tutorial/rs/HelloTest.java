package fr.futurskill.tutorial.rs;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Test;

public class HelloTest {
	@Test
	public void hello() {
		System.out.println("Hello test");
		
		
		Client client = JerseyClientBuilder.newClient();
		
		WebTarget target =
				client.target("http://localhost:8080/rs-server")
						.path("/rs/hello")
						.queryParam("firstName", "Laurent")
						.queryParam("lastName", "Joyeux");
		
		String response = target.request().get(String.class);
		
		System.out.println(response);
	}
}
