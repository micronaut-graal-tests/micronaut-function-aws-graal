package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class JokeRequest {

    private final String category;

    public JokeRequest(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
