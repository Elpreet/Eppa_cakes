package ca.sheridancollege.bajajak.assignment2.controllers;

import ca.sheridancollege.bajajak.assignment2.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import ca.sheridancollege.bajajak.assignment2.beans.Cheese;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    private MainService mainService;

    public MainController() {
        super();
    }


    @Autowired
    public void setMainService(final MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping({"/"})    //to request main home page
    public String showCheeseHomePage() {
        return "index";
    }

    @RequestMapping({"/cheese"})   //to request list_inventory page (View Chez ) as per project assignment
    public String showCheeses() {
        return "list_inventory";
    }


    @RequestMapping(value="/listInventory")
    public String listInventory(Model model) {
        List<Cheese> allCheeses = this.mainService.findAllCheeses();
        model.addAttribute("allCheeses", allCheeses);
        return "list_inventory";
    }

    @RequestMapping(value="/view")  // to request view_cheeses (view.html) as per project assignment
    public String view(Model model) {
        List<Cheese> viewCheeses = this.mainService.findAllCheeses();
        List<String> cheeseList = new ArrayList<>();
        for (Cheese cheese : viewCheeses) {
            cheeseList.add(cheese.getName()+ " : " + cheese.getWeight()+ " " + cheese.getUnitsId());
        }
        model.addAttribute("cheeseList", cheeseList);
        return "view_cheeses";
    }

    @RequestMapping({"/add_inventory"})  // to request add_inventory (index.html) as per project assignment
    public String addInventory(final Cheese cheese, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";   // if error occurs in the form then show this as a fallback
        }
        return "add_inventory";
    }

    @RequestMapping(value="/saveCheese", params={"save"})
    public String saveCheese(final Cheese cheese, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";   // if error occurs in the form then show this as a fallback
        }
        this.mainService.saveCheese(cheese);
        return "add_inventory";
    }
}
