package fr.devlogic.tutorial.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name="helloService", targetNamespace="http://devlogic.fr/services/ws/tutorial/")
@SOAPBinding(style=Style.RPC)
public class Hello {
	@WebMethod(operationName="hello")
	public HelloResponse hello(final @WebParam(name="hello") HelloRequest hello) {
		HelloResponse response = new HelloResponse();
		
		response.setMessage("hello " + hello.getFirstName() + " " + hello.getLastName());
		return response;
	}
}
