package Serenity.abilities;

import jnr.ffi.annotations.In;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class GetInformation implements Ability {
    private String location;
    private LocalDate departureDay;
    private LocalDate returnDay;
    private int numberOfAdult;
    private int numberOfChildren;
    private int numberOfRoom;
    public GetInformation(String location,LocalDate departureDay,LocalDate returnDay,int numberOfAdult, int numberOfChildren,int numberOfRoom){
        this.location=location;
        this.departureDay=departureDay;
        this.returnDay=returnDay;
        this.numberOfAdult=numberOfAdult;
        this.numberOfChildren=numberOfChildren;
        this.numberOfRoom=numberOfRoom;
    }

    public static GetInformation fromUserProfile(){
        FileReader reader =null;
        Properties properties=null;
        try{
            reader= new FileReader("src\\test\\resources\\userInfo.properties");
            properties = new Properties();
            properties.load(reader);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        GetInformation getInformation = new GetInformation(
                properties.getProperty("Location"),
                LocalDate.parse(properties.getProperty("DepartureDay"),formatter),
                LocalDate.parse(properties.getProperty("ReturnDay"),formatter),
                Integer.valueOf(properties.getProperty("NumberOfAdult")),
                Integer.valueOf(properties.getProperty("NumberOfChildren")),
                Integer.valueOf(properties.getProperty("NumberOfRoom"))
        );
        return getInformation;
    }

    public static GetInformation getInformation(Actor actor){
        return actor.abilityTo(GetInformation.class);
    }
    public String getLocation(){
        return this.location;
    }
    public LocalDate getDepartureDay(){
        return this.departureDay;
    }
    public LocalDate getReturnDay(){
        return this.returnDay;
    }
    public int getNumAdult(){
        return this.numberOfAdult;
    }
    public int getNumChildren(){
        return numberOfChildren;
    }
    public int getNumRoom(){
        return numberOfRoom;
    }
}
