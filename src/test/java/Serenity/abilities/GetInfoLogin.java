package Serenity.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetInfoLogin implements Ability {
    private String email;
    private String password;

    public GetInfoLogin(String email,String password){
        this.email=email;
        this.password=password;
    }


    public static GetInfoLogin fromHerLoginProfile() {
        FileReader reader = null;
        Properties properties = null;
        try{
            reader= new FileReader("src\\test\\resources\\loginInfo.properties");
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GetInfoLogin(
                properties.getProperty("Email"),
                properties.getProperty("Password")
        );

    }

    public static GetInfoLogin getInfoLogin(Actor actor) {
        return actor.abilityTo(GetInfoLogin.class);
    }

    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
