package br.edu.iftm.tspi.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
    
    @RequestMapping("/alo")
    public String alo(Model modelo) {
        modelo.addAttribute("nro", 1);
		return "home";
    }


}
