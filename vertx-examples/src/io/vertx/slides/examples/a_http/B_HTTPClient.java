package io.vertx.slides.examples.a_http;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;

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
            invoke(client).setHandler(
                ar -> request.response()
                    .putHeader("Access-Control-Allow-Origin", "*")
                    .end("Hello " + ar.result()))
        )
        .listen(PORT);
  }

  private static Future<String> invoke(WebClient client) {
    Future<String> future = Future.future();
    client.get(SERVICE_PORT, SERVICE_HOST, "/")
        .send(ar -> {
          if (ar.failed()) {
            future.fail(ar.cause());
          } else {
            future.complete(ar.result().bodyAsString());
          }
        });
    return future;
  }


  public static final int PORT = 8082;
  public static final int SERVICE_PORT = 8081;
  public static final String SERVICE_HOST = "localhost";
}
