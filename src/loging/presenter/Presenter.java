/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging.presenter;


import java.util.List;
import loging.model.Account;
import loging.view.Display;
import loging.view.swing.SwingDisplay;

/**
 *
 * @author usuario
 */
public class Presenter {
    
    private List<Account> account;
    private Display display;

    public Presenter(List <Account> account, Display display) {
        this.account = account;
        this.display = display;
    }
    
    public void login( String name, String pass){
        String result = "Something went wrong";
        
        for (Account a : account) {
            if (a.getUser().equals(name) && a.getPassword().equals(pass)){
            result = "Loging succesful";
            }
        }
     
        
        display.updateStatusLabel(result);
    }
    
}
