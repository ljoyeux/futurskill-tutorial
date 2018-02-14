package fr.devlogic.tutorial.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "helloRequest", namespace = "http://devlogic.fr/services/ws/tutorial/")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "helloRequest", namespace = "http://devlogic.fr/services/ws/tutorial/")
public class HelloRequest {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
