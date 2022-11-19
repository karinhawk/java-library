package org.example;

public class Admin extends Person {

    private boolean isAdmin = true;

    public Admin(String username, String password, int accountID, boolean isAdmin) {
        super(username, password, accountID);
        this.isAdmin = isAdmin;
    }

    public void reportOfBooksOnLoan(){

    }

    public int timesLoanedOut(){
        return 0;
    }


}
