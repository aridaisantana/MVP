/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging.presenter;

import loging.model.Account;
import loging.view.Display;
import loging.view.swing.SwingDisplay;

/**
 *
 * @author usuario
 */
public class Presenter {
    
    private Account account;
    private Display display;
    
    public Presenter(Account account) {
        this.account = account;
    }
    
    public void login( String name, String pass){
        String result = "Something went wrong";
        
        if (account.getUser().equals(name) && account.getPassword().equals(pass)){
            result = "Loging succesful";
        }
        
        SwingDisplay.updateStatusLabel(result);
    }
    
}
