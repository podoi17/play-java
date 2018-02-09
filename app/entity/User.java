package entity;

import repositories.UserRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;


@Entity
public class User {

    @Id
    private String email;
    private String name;
    private String password;
    private String randomString;



    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User() {

    }

    public String print() {
        return this.getName() + " " + this.getEmail();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //Google mal nach java UUID
    /*public void setRandomString(int codeLength, String id){
        char[] chars = id.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        this.randomString = sb.toString();


    }*/

    public void setRandomString() {
        UUID uuid= UUID.randomUUID();

        this.randomString = uuid.toString();
    }

    public String getRandomString() {
        return this.randomString;
    }


}
