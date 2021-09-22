package org.example.controllers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PokeapiController {

    public Response getPokemonData(String pokemonName) {

        Response response = given()
                            .header("Accept", "application/json")
                            .when()
                            .get("https://pokeapi.co/api/v2/pokemon/" + pokemonName);

        return response;
    }

}
