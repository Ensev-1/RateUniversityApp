import java.sql.*;

import static java.lang.Integer.parseInt;

public class Account {
    private String[][] users;
    ReaderImpl reader;

    public Account(){

    }

    public int loginInfoIsCorrect (String name, String password){
        reader= new ReaderImpl();
        this.users = reader.readUsers();

        for(int i=0; i<users.length; i++){
            if(name.equalsIgnoreCase(users[i][1]+" "+users[i][2]) && password.equals(users[i][4]))
                return parseInt(users[i][0]);
        }
        return -1;
    }

    public boolean signUp(String firstName, String lastName, String email, String password) throws SQLException {
        if(!(firstName.length()>0 &&firstName.length()<=20))
            return false;
        if(!(lastName.length()>0 &&lastName.length()<=20))
            return false;
        if(!(email.length()>0 &&email.length()<=40))
            return false;
        if(!(password.length()>0 &&password.length()<=30))
            return false;

        String query="INSERT INTO users(FirstName, LastName, Email, Password) " +
                "VALUES('"+firstName+"','"+lastName+"','"+email+"','"+password+"')";
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "");
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(query);

        return true;
    }



}