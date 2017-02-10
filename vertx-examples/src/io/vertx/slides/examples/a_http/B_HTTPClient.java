package io.vertx.slides.examples.a_http;

import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.web.client.HttpResponse;
import io.vertx.rxjava.ext.web.client.WebClient;
import rx.Single;

/**
 * Port: 8082
 * Cors enabled
 * <p>
 * "Hello " + buffer
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class B_HTTPClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        WebClient client = WebClient.create(vertx);

        vertx.createHttpServer()
            .requestHandler(request ->
                invoke(client).subscribe(
                    payload -> request.response()
                        .putHeader("Access-Control-Allow-Origin", "*")
                        .end("Hello " + payload))
            )
            .listen(PORT);
    }

    private static Single<String> invoke(WebClient client) {
        return client.get(SERVICE_PORT, SERVICE_HOST, "/")
            .rxSend()
            .map(HttpResponse::bodyAsString);
    }


    public static final int PORT = 8082;
    public static final int SERVICE_PORT = 8081;
    public static final String SERVICE_HOST = "localhost";
}
