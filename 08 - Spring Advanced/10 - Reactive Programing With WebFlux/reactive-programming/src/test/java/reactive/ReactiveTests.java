package reactive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;

public class ReactiveTests {

    @Test
    public void testAllItemsConsumed(){
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        SimpleSubscriber<String> mySubscriber = new SimpleSubscriber<>();

        publisher.subscribe(mySubscriber);

        Assertions.assertEquals(1, publisher.getNumberOfSubscribers());

        List<String> names = List.of("Anna", "John", "Pesho");

        names.forEach(publisher::submit);
        publisher.close();

        await()
                .atMost(1, TimeUnit.SECONDS)
                .until(() -> mySubscriber.getConsumedElementsCount() == names.size());

        Assertions.assertEquals(3, mySubscriber.getConsumedElementsCount());
    }

    @Test
    public void testTransformation(){
        //given
        Function<String, String> transformation = String::toUpperCase;

        TransformationProcessor<String, String> transformationPipe =
                new TransformationProcessor(transformation);

        SubmissionPublisher<String> startPublisher = new SubmissionPublisher<>();
        SimpleSubscriber<String> finishSubscriber = new SimpleSubscriber<>();

        List<String> items = List.of("SeNKo", "Pesho", "Lilly");
        List<String> expectedItems = List.of("SENKO", "PESHO", "LILLY");

        //when
        startPublisher.subscribe(transformationPipe);
        transformationPipe.subscribe(finishSubscriber);

        items.forEach(startPublisher::submit);
        startPublisher.close();

        await()
                .atMost(1, TimeUnit.SECONDS)
                .until(() -> expectedItems.equals(finishSubscriber.getConsumedElements()));

        Assertions.assertEquals(expectedItems, finishSubscriber.getConsumedElements());

    }
}
