package fr.futurskill.tutorial.ws;

import fr.devlogic.services.ws.tutorial.Hello;
import org.junit.Test;

import fr.devlogic.services.ws.tutorial.HelloRequest;
import fr.devlogic.services.ws.tutorial.HelloResponse;
import fr.devlogic.services.ws.tutorial.HelloService;

public class HelloTest {
	@Test
	public void hello() {
		Hello service = new HelloService().getHelloPort();
		
		HelloRequest request = new HelloRequest();
		request.setFirstName("Laurent");
		request.setLastName("Joyeux");
		service.hello(request);
		HelloResponse response = service.hello(request);
		
		System.out.println(response.getMessage());
	}
}
