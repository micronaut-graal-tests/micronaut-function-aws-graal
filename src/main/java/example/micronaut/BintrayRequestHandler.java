package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import javax.inject.Inject;

@Introspected
public class BintrayRequestHandler extends MicronautRequestHandler<BintrayRequest, BintrayPackage> {

    @Inject
    BintrayClient bintrayClient;

    @Override
    public BintrayPackage execute(BintrayRequest input) {
        return bintrayClient.fetchPackages()
                .stream()
                .filter(bintrayPackage -> bintrayPackage.getName().equals(input.getMicronautPackage()))
                .findFirst()
                .orElse(null);
    }
}
