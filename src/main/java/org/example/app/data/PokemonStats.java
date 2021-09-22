package org.example.app.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface PokemonStats {
    List<String> baseStatsKey =
            Collections.unmodifiableList(Arrays.asList
            ("HP","Attack","Defense","Special Attack","Special Defense","Speed"));
}
