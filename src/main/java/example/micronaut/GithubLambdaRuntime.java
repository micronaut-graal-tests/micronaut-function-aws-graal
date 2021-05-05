package example.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import javax.inject.Singleton;
import java.net.MalformedURLException;

@Singleton
public class GithubLambdaRuntime extends AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, GithubRequest, GithubRelease> {

    public static void main(String[] args) {
        try {
            new GithubLambdaRuntime().run();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    protected RequestHandler<GithubRequest, GithubRelease> createRequestHandler(String... args) {
        return new GithubRequestHandler();
    }

}
