package example.micronaut;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import javax.annotation.Nullable;
import javax.inject.Singleton;
import java.net.MalformedURLException;

@Singleton
public class BintrayLambdaRuntime extends AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, BintrayRequest, BintrayPackage> {

    public static void main(String[] args) {
        try {
            new BintrayLambdaRuntime().run();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    protected RequestHandler<BintrayRequest, BintrayPackage> createRequestHandler(String... args) {
        return new BintrayRequestHandler();
    }

}
