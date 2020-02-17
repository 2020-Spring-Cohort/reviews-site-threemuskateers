package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.CategoryStorage;

@Controller
public class CategoriesController {

    private CategoryStorage categoryStorage;


    @RequestMapping("/categories")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "index.html";
    }
}
