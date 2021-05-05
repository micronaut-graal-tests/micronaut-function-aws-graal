package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class GithubRequest {

    private final String micronautVersion;

    public GithubRequest(String micronautVersion) {
        this.micronautVersion = micronautVersion;
    }

    public String getMicronautVersion() {
        return micronautVersion;
    }
}
