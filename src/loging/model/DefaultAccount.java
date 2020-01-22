/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging.model;

/**
 *
 * @author usuario
 */
public class DefaultAccount implements Account {

    private String defaultUser;
    private String defaultPassword;

    public DefaultAccount(String defaultUser, String defaultPassword) {
        this.defaultUser = defaultUser;
        this.defaultPassword = defaultPassword;
    }
    
    @Override
    public String getUser() {
        return defaultUser;
    }

    @Override
    public String getPassword() {
        return defaultPassword;
    }
    
}
