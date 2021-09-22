package org.example.app.pokeapi.responses;

import lombok.Data;

@Data
public class GetTypeData {
    private int slot;
    private GetTypeName type;
}
