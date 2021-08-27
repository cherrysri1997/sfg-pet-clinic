package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String getVetsIndexPage() {
        return "/vets/index";
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String getOwnersIndexPage() {
        return "owners/index";
    }
}
