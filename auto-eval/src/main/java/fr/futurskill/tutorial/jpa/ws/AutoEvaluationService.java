package fr.futurskill.tutorial.jpa.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "AutoEvaluation",
        wsdlLocation = "http://localhost:8080/ws/AutoEvaluation?wsdl",
        targetNamespace = "http://futurskill.fr/tutorial/jpa/ws"
)
public class AutoEvaluationService {
    @WebMethod(operationName = "modifie")
    public modifie(@WebParam)
}
