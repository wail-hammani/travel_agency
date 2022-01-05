package fr.lernejo.prediction;

import java.util.List;

public record Temperature(String country, List<Temperatures> temperatures) {

public record Temperatures(String date, Number temperature) {}
}
