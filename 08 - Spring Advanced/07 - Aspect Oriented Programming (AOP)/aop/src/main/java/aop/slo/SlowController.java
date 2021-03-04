package aop.slo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SlowController {

    @TrackLatency(latency = "operation1")
    @GetMapping("/operation1")
    public String operation1(){
        //stop watch (start)
        //...
        //stop watch (stop)
        //if stop - start > 150ms then send alert

        return "operation1";
    }

    @TrackLatency(latency = "operation2")
    @GetMapping("/operation2")
    public String operation2() throws InterruptedException {
        //emulate hard processing
        Thread.sleep(new Random().nextInt(1000));

        return "operation2";
    }

}
