package org.example.app.pokeapi.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPokeDataRequest {
    String name;
}
