package fr.lernejo.travelsite;

public record Register(String userEmail,String userName,String userCountry,WeatherExpectation weatherExpectation) {

    public enum WeatherExpectation{WARMER,COLDER};

}
