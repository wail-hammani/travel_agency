package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TravelAgencyController {

    final List<Register> membres = new ArrayList<>();



    @PostMapping(value = "api/inscription")
    public void add(@RequestBody Register membre) {
        boolean exist = false;
        for (Register r : membres) {
            if (r.userName().equals(membre.userName())) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            membres.add(membre);
        }

    }

    @GetMapping(value = "api/travels")
    public Object get(@RequestParam String userName)
    {
        List<Country> countries = new ArrayList<>();
        for (Register r : membres)
        {
            if (r.userName().equals(userName))
            {

                countries.add(new Country("Algérie", 30));
                countries.add(new Country("Maroc", 30));


            }
        }
        return countries;
    }
}
