package errorhandling.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello1Controller {

    @GetMapping("/crash-me2")
    public ModelAndView crashMe1(){
        throw new HelloException("I crashed!");
    }

}
