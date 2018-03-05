package fr.futurskill.tutorial.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    private Account parent;

	/**
	 * 
	 */
	private static final long serialVersionUID = -320696688565195696L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String login;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

	@Override
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + "]";
	}
    
    
}
