package fr.devlogic.tutorial.ws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloService {

    @WebMethod
    public String hello(@WebParam(name = "name") String name) {
        return "hello " + name;
    }
}
