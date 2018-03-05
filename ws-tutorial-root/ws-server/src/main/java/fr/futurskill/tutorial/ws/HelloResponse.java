package fr.futurskill.tutorial.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "helloResponse", namespace = "http://devlogic.fr/services/ws/tutorial/")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "helloResponse", namespace = "http://devlogic.fr/services/ws/tutorial/")
public class HelloResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
