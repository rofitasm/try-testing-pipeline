package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.app.data.Pokemon;
import org.example.app.data.PokemonStats;
import org.example.app.pokeapi.responses.GetPokeDataResponse;
import org.example.controllers.PokeapiController;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PokemonSteps {

    Pokemon pokeapiPokemon;
    PokeapiController pokeapiController;

    @Given("prepare variables to get pokemon data")
    public void prepareVariablesToGetPokemonData() {
        pokeapiPokemon = new Pokemon();
        pokeapiPokemon.pokemonTypeList = new ArrayList<>();
        pokeapiPokemon.pokemonBaseStats = new HashMap<>();
        pokeapiController = new PokeapiController();
    }

    @When("get {string} pokemon data from pokeapi")
    public void getPokemonNamePokemonDataFromPokeapi(String pokeName) {
        pokeapiPokemon.pokemonName = pokeName;
        Response response = pokeapiController.getPokemonData(pokeapiPokemon.pokemonName.toLowerCase());
        assertThat("Pokemon is not found in PokeAPI web", response.getStatusCode(), equalTo(200));

        GetPokeDataResponse getPokeDataResponse = response.getBody().as(GetPokeDataResponse.class);
        pokeapiPokemon.pokemonNumber = getPokeDataResponse.getId();

        for ( int i=0; i < getPokeDataResponse.getTypes().size(); i++) {
            pokeapiPokemon.pokemonTypeList.add(getPokeDataResponse.getTypes().get(i).getType().getName().toLowerCase());
        }

        for( int i=0; i < getPokeDataResponse.getStats().size(); i++) {
            pokeapiPokemon.pokemonBaseStats.put(PokemonStats.baseStatsKey.get(i),
                    getPokeDataResponse.getStats().get(i).getBase_stat());
        }
    }

    @Then("get pokemon data should be success")
    public void getPokemonDataShouldBeSuccess() {
        assertThat("Pokemon number is not found", pokeapiPokemon.pokemonNumber, notNullValue());
        assertThat("Pokemon type is not found", pokeapiPokemon.pokemonTypeList, notNullValue());

        for (String baseStat : PokemonStats.baseStatsKey) {
            assertThat(baseStat + "is not found",
                    pokeapiPokemon.pokemonBaseStats.get(baseStat), notNullValue());
        }
    }
}
