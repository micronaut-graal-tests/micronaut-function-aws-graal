package example.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import javax.inject.Inject;

@Introspected
public class GithubRequestHandler extends MicronautRequestHandler<GithubRequest, GithubRelease> {

    @Inject
    GithubApiClient githubApiClient;

    @Override
    public GithubRelease execute(GithubRequest input) {
        return githubApiClient.fetchReleases()
                .stream()
                .filter(githubRelease -> githubRelease.getName().contains(input.getMicronautVersion()))
                .findFirst()
                .orElse(null);
    }
}
