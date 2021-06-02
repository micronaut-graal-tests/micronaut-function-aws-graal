package example.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;
import jakarta.inject.Singleton;

import java.net.MalformedURLException;

@Singleton
public class JokeLambdaRuntime extends AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, JokeRequest, Joke> {

    public static void main(String[] args) {
        try {
            new JokeLambdaRuntime().run(args);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<JokeRequest, Joke> createRequestHandler(String... args) {
        return new JokeRequestHandler();
    }
}
