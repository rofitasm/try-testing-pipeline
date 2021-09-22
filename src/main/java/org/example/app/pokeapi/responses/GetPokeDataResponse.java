package org.example.app.pokeapi.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPokeDataResponse {
    private int id;
    private List<GetTypeData> types;
    private List<GetStatData> stats;
}
