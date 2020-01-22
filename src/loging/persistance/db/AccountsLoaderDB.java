
package loging.persistance.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import loging.model.Account;
import loging.model.DefaultAccount;
import loging.persistance.AccountsLoader;


public class AccountsLoaderDB implements AccountsLoader {
    
    private List <Account> accounts;
    
    @Override
    public List <Account> accounts() {
        String URL_BD_SQLITE = new String("jdbc:sqlite:C:\\Users\\usuario\\Documents\\NetBeansProjects\\Loging\\Loging\\accounts.db");
        
        Connection connection = connect(URL_BD_SQLITE);
        
        accounts = getAccounts();
        return this.accounts;
    }
    
     private  Connection connect(String URL_BD_SQLITE){
        
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD_SQLITE);
            System.out.println("Base de datos conectada...");
            selectData_PEOPLE(connection);
           
        }
        catch(SQLException exception){
            System.out.println("ERROR Loging (SQLException)" + exception.getMessage());
        }
        finally{
            try{
                if ( connection != null){
                    connection.close();
                }
            }
            catch ( SQLException exception){
                System.out.println("ERROR Loging (SQLException finally)" + exception.getMessage());
            }
        }
        return connection;
    }
    
    private  void selectData_PEOPLE(Connection connection) {
        int i = 0;
        List<Account> accounts = new ArrayList<>();
        
        String SQL = "SELECT * FROM ACCOUNTS";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            while ( resultset.next()){
                       String user = resultset.getString("USER");
                       String password = resultset.getString("PASSWORD");
                       DefaultAccount account = new DefaultAccount(user,password);
                       accounts.add(account);
            }
           this.accounts = accounts;
        }
        catch(SQLException exception){
            System.out.println("Error kata5 (SQLException)" + exception.getMessage());
        }
        
    }
    
    
    private List <Account> getAccounts() {
        return this.accounts;
    }
}
