package fr.futurskill.tutorial.ws.model;

public class AccountFactory {

    public static Account account(String login) {
        Account account = new Account();
        account.setLogin(login);

        return account;
    }
}
