package bg.softuni.webfluxclient;

import bg.softuni.webfluxclient.config.ClientConfig;
import bg.softuni.webfluxclient.model.ExchangeRate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ExchangeRateClient {

  private final String SERVICE_URL;
  private final String API_PATH = "/rates";

  public ExchangeRateClient(ClientConfig clientConfig) {
    SERVICE_URL = clientConfig.getSchema() + "://" + clientConfig.getHost() + ":" + clientConfig.getPort();
  }

  public Flux<ExchangeRate> getRateStream() {
    return WebClient.
        builder().
        baseUrl(SERVICE_URL).
        build().
        get().
        uri(API_PATH).
        accept(MediaType.APPLICATION_STREAM_JSON).
        retrieve().
        bodyToFlux(ExchangeRate.class);
  }
}
