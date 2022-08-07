package dcc193.trabalho.avaliacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
    @Autowired
        
    @RequestMapping({ "/", "/index.html" })
    public String index() {
        return "index";
    }
}