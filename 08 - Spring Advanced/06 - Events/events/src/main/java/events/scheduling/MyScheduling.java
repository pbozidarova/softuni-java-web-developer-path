package events.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduling {

    private int seconds = 0;

    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void doSomeWork(){
        System.out.println("I am starting an every second! " +  (++seconds));
    }

    @Scheduled(cron = "")
    public void scheduledByCron(){

    }
}
