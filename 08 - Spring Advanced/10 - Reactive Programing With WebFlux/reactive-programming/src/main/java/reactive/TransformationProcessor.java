package reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class TransformationProcessor<T, R> implements Flow.Processor<T, R> {

    private Subscription subscription;
    private final Function<T, R> transformation;
    private final SubmissionPublisher<R> publisher;

    public TransformationProcessor(Function<T, R> transformation) {
        this.transformation = transformation;
        this.publisher = new SubmissionPublisher<>();
    }

    //Publisher
    @Override
    public void subscribe(Flow.Subscriber<? super R> subscriber) {
        publisher.subscribe(subscriber);
    }

    //Subscriber
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        R transformed = transformation.apply(item);
        publisher.submit(transformed);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Transformation is complete, closing down!");
    }
}
