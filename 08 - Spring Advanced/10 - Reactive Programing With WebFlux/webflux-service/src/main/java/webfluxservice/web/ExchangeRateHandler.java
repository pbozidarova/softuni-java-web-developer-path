package webfluxservice.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import webfluxservice.model.ExchangeRate;
import webfluxservice.service.ExchangeRateService;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ExchangeRateHandler {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateHandler(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    public Mono<ServerResponse> getExchangeRates(ServerRequest request){
        int size = Integer.parseInt(request.queryParam("size").orElse("10"));

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(this.exchangeRateService.getExchangeRateStream(0)
                        .take(size), ExchangeRate.class);
    }

    public Mono<ServerResponse> streamExchangeRates(ServerRequest request){

        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(this.exchangeRateService.getExchangeRateStream(1),
                        ExchangeRate.class);
    }


}
