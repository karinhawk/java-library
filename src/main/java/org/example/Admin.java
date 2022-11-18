package org.example;

public class Admin extends Person {

    private boolean isAdmin = true;

    public Admin(boolean isAdmin, String username) {
        this.isAdmin = isAdmin;
    }

    public void reportOfBooksOnLoan(){

    }

    public int timesLoanedOut(){
        return 0;
    }


}
