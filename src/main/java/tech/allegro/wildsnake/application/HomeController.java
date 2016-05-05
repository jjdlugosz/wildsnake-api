package tech.allegro.wildsnake.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.allegro.wildsnake.showcase.service.ShowcaseService;

@Controller
public class HomeController {

    private final ShowcaseService showcaseService;
    private final String pageMessage;

    @Autowired
    public HomeController(ShowcaseService showcaseService, @Value("${mainpage.message}")String pageMessage) {
        this.showcaseService = showcaseService;
        this.pageMessage = pageMessage;
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("pageMessage", pageMessage);
        model.addAttribute("showcaseItems", showcaseService.getItems());
        return "index";
    }
}
