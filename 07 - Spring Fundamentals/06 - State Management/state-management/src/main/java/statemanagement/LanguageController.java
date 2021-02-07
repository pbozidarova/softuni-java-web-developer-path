package statemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LanguageController {
    private final String defaultLang = "bg";
    private final List<String> allLangs = List.of("bg", "en", "de");

    @PostMapping("/save")
    public String save(@RequestParam String lang, HttpServletResponse response,
                       HttpSession session){
        session.setAttribute("lang", lang);

        return "redirect:/all";
    }


    @GetMapping("/all")
    public String allLangs(Model model,
        HttpSession session){

        Object preferedLang = session.getAttribute("lang");
        if(preferedLang == null) {
            preferedLang = defaultLang;
        }

        model.addAttribute("all", allLangs);
        model.addAttribute("preferredLang", preferedLang);

        return "languages";
    }

}
