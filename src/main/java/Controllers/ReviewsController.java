package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewsController {

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }
}
