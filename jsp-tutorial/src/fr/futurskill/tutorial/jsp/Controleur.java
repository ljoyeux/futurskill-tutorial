package fr.futurskill.tutorial.jsp;

import java.util.HashMap;
import java.util.Map;

public class Controleur {
	
	private String login;
	private String password;
	private String message;
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getLogin() {
		return login==null ? "" : login;
	}
	
	public String getMessage() {
		return message==null ? "": message;
	}
	
	public String getPassword() {
		return password==null ? "" : password;
	}
	
	Map<String, String> logins = new HashMap<>();
	{
		logins.put("ljoyeux", "qwerty");
	}
	
	public String login() {
		boolean error = false;
		if (login==null || login.trim().isEmpty()) {
			error = true;
			message = "Login is missing";
		} else if (password==null || password.trim().isEmpty()) {
			error = true;
			message = "Password is missing";
		}
		
		if(!error) {
			if(logins.containsKey(login)) {
				if( !logins.get(login).equals(password)) {
					error = true;
					message = "Wrong password";
				}
			} else {
				error = true;
				message = "Invalid user";
			}
		}
		
		String page = error ? "login.jsp" : "success.jsp";
//		System.out.println(page);
		return page;
	}
}
