package fr.devlogic.tutorial.ws;

import org.junit.Test;

import fr.devlogic.services.ws.tutorial.HelloRequest;
import fr.devlogic.services.ws.tutorial.HelloResponse;
import fr.devlogic.services.ws.tutorial.HelloService;
import fr.devlogic.services.ws.tutorial.HelloService_Service;

public class HelloTest {
	@Test
	public void hello() {
		HelloService service = new HelloService_Service().getHelloServicePort();
		
		HelloRequest request = new HelloRequest();
		request.setFirstName("Laurent");
		request.setLastName("Joyeux");
		HelloResponse response = service.hello(request);
		
		System.out.println(response.getMessage());
	}
}
