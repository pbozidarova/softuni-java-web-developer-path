package spring.advanced.fluxmono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WebfluxGeneralTest {
    @Test
    public void fluxToStream(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        springProjectsFlux
                .toStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void subscribeToFlux(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        springProjectsFlux.subscribe(System.out::println);
    }

    @Test
    public void doOnEach(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        springProjectsFlux.doOnEach(
                s -> {
                    if(s.isOnNext()){
                        System.out.println(s.get());
                    }
                }
        ).subscribe();
    }

    @Test
    public void mapAndFilter(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        springProjectsFlux
                .map(String::toUpperCase)
                .filter(s -> s.contains("REST"))
                .subscribe(System.out::println);
    }

    @Test
    public void collect(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        springProjectsFlux
                .map(String::length)
                .collect(Collectors.summarizingInt(Integer::intValue))
                .subscribe(System.out::println);
    }

    @Test
    public void subscribe(){
        Flux<String> springProjectsFlux = Flux.just(getSpringProjects());

        Consumer<String> onNextConsumer = System.out::println;
        Consumer<Throwable> onErrorConsumer = Throwable::printStackTrace;
        Runnable onDone = () -> System.out.println("We are done!");

        springProjectsFlux.subscribe(
                onNextConsumer,
                onErrorConsumer,
                onDone
        );
    }

    @Test
    public void testOnError(){
        Flux<Integer> numbers = Flux.just("1", "two", "3").map(Integer::parseInt);

        Consumer<Integer> onNextConsumer = System.out::println;
        Consumer<Throwable> onErrorConsumer = Throwable::printStackTrace;
        Runnable onDone = () -> System.out.println("We are done!");

        numbers.subscribe(
                onNextConsumer,
                onErrorConsumer,
                onDone
        );
    }

    @Test
    public void mono(){
        Mono.just("TEST").map(String::toUpperCase).subscribe(System.out::println);
    }

    private String[] getSpringProjects(){
        return new String[] {
                "Spring REST",
                "Spring Data REST",
                "Spring MVC",
                "Spring WebFlux",
                "Spring JMS",
                "Spring Kafka"
        };
    }
}
