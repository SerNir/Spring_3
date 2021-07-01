package ru.summer.mymarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
    //List<Product> list;
    @Autowired
    ProductRepository repository;

//    http://localhost:8088/summer/add_product
    @GetMapping("add_product")
    public String showAddProductForm(){
        return "add_product";
    }

    @PostMapping("add_product_list")
    public String addProductToList(Model model, @RequestParam int id, @RequestParam String title, @RequestParam float cost){
      Product product = new Product(id,title,cost);
     model.addAttribute(new Product(id, title, cost));
        repository.addToProductList(product);

        return "redirect:/add_product";
    }

    @GetMapping("get_product_list")
    public String getProductList(Model model){

        model.addAttribute("list", repository.getProductList());
         return "products";
    }


}
