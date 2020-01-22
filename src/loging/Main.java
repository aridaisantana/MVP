/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging;

import loging.model.Account;
import loging.model.DefaultAccount;
import loging.presenter.Presenter;
import loging.view.Display;
import loging.view.swing.SwingDisplay;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingDisplay view = new SwingDisplay();
        Account account = new DefaultAccount("Pepe","1234");
        view.setPresenter(new Presenter(account, view));
        view.display();
    }
    
}
