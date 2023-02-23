package lk.ijse.spring.controller;

import com.sun.deploy.nativesandbox.comm.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

//@RestController
//@CrossOrigin
//@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public RedirectView index(){

        return new RedirectView("http://localhost:63342/Car_Rental_System/Front_End/index.html?_ijt=9aeturfjk6mj569iibiq5sc4km");
    }
}
