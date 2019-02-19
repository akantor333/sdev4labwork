package models.users;

import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;



@Entity
public class User extends Model {
    @Id
    private String email;
    @Constraints.Required
    private String role;
    @Constraints.Required
    private String name;
    @Constraints.Required
    private String password;

    public User(){}

    public User(String e,String r, String n, String p){
        this.email = e;
        this.role = r;
        this.name = n;
        this.password = p;
    }

    public void setEmail(String e){
        this.email = e;
    }
    public void setRole(String r){
        this.role = r;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setPassword(String p){
        this.password = p;
    }

    public String getEmail(){
        return this.email;
    }
    public String getRole(){
        return this.role;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }

    public static Finder<Long,User> find = new Finder<Long,User>(User.class);

    public static List<User> findAll() {
        return User.find.query().where().orderBy("name asc").findList();
     }

     public static User authenticate(String email, String password) {
        return find.query().where().eq("email", email).eq("password", password).findUnique();
       }
       
}