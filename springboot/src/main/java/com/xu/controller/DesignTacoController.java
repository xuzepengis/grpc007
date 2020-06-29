package com.xu.controller;

import com.xu.entity.Ingredient;
import com.xu.entity.Ingredient.Type;
import com.xu.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping(value = "/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP ),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP ),
                new Ingredient("CRBF", "Ground Beef", Ingredient.Type.PROTEIN ),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN ),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES ),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES ),
                new Ingredient("CHED", "Cheddar Tortilla", Ingredient.Type.CHEESE ),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE ),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE ),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.VEGGIES )
                );
        Type[] types = Ingredient.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
        model.addAttribute("design",new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
