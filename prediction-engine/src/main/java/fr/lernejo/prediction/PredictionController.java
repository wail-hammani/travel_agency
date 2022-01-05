package fr.lernejo.prediction;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class PredictionController {
   final TemperatureService tempService = new TemperatureService();

    @GetMapping(value="api/temperature")
    public Object get(@RequestParam String country)
    {
        Temperature temperature=new Temperature(country,new ArrayList<Temperature.Temperatures>());
        try
        {
         temperature.temperatures().add(new Temperature.Temperatures(LocalDate.now().minusDays(1).toString(),tempService.getTemperature(country)));
         temperature.temperatures().add(new Temperature.Temperatures(LocalDate.now().minusDays(2).toString(),tempService.getTemperature(country)));
        }catch(UnknownCountryException e)
        {
            return ResponseEntity.status(417).body("Erreur");
        }

        return temperature;
    }
}
