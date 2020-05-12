package Serenity.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetInfoRegister implements Ability {
    private String email;
    private String password;
    private String confirmPassword;

    public GetInfoRegister(String email, String password,String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword=confirmPassword;
    }


    public static GetInfoRegister fromRegisterProfile() {
        FileReader reader= null;
        Properties properties=null;
        try{
            reader= new FileReader("src\\test\\resources\\registerInfo.properties");
            properties = new Properties();
            properties.load(reader);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new GetInfoRegister(
                properties.getProperty("Email"),
                properties.getProperty("Password"),
                properties.getProperty("ConfirmPassword")
        );
    }
    public static GetInfoRegister getInfoRegister(Actor actor){
        return actor.abilityTo(GetInfoRegister.class);
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getConfirmPassword(){
        return confirmPassword;
    }
}
