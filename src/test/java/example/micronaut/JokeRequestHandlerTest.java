package example.micronaut;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JokeRequestHandlerTest {

    private static JokeRequestHandler jokeRequestHandler;

    @BeforeAll
    public static void setupServer() {
        jokeRequestHandler = new JokeRequestHandler();
    }

    @AfterAll
    public static void stopServer() {
        if (jokeRequestHandler != null) {
            jokeRequestHandler.getApplicationContext().close();
        }
    }

    @Test
    public void testHandler() {
        Joke joke = jokeRequestHandler.execute(new JokeRequest("category"));

        assertNotNull(joke);
        assertEquals("success", joke.getType());
        assertNotNull(joke.getFactId());
        assertNotNull(joke.getText());
    }

}


