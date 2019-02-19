package models.users;
import models.*;

public class Login{
    private String email;
    private String password;

    public String validate(){
        if (User.authenticate(email, password) == null){
            return "Invalid user and password";
        }
        return null;
    }

    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
