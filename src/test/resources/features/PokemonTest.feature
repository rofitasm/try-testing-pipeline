@Pokemon

Feature: PokeAPI Test Data

  Scenario Outline: Test Pokemon data from PokeAPI
    Given prepare variables to get pokemon data
    When get '<pokemonName>' pokemon data from pokeapi
    Then get pokemon data should be success

    Examples:
      | pokemonName |
      | Pikachu     |
      | Charizard   |
      | Eevee       |
      | Mewtwo      |
      | Garurumon   |
      | Koffing     |
      | Meowth      |
      | Blastoise   |
      | Ivysaur     |
      | Squirtle    |
      | Mew         |
