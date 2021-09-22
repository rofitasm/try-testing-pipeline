package org.example.app.pokeapi.responses;

import lombok.Data;

@Data
public class GetStatData {
    private int base_stat;
    private int effort;
    private GetStatName stat;
}
