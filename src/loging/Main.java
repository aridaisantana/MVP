/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging;

import java.util.List;
import loging.model.Account;
import loging.model.DefaultAccount;
import loging.persistance.AccountsLoader;
import loging.persistance.db.AccountsLoaderDB;
import loging.presenter.Presenter;
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
        AccountsLoader loader = new AccountsLoaderDB();
        List <Account> accounts = loader.accounts();
        view.setPresenter(new Presenter(accounts, view));
        view.display();
    }
    
}
