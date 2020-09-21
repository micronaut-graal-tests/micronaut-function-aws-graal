package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class BintrayRequest {

    private final String micronautPackage;

    public BintrayRequest(String micronautPackage) {
        this.micronautPackage = micronautPackage;
    }

    public String getMicronautPackage() {
        return micronautPackage;
    }
}
