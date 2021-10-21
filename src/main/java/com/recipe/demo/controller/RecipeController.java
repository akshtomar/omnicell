package com.recipe.demo.controller;

import com.recipe.demo.model.Recipe;
import com.recipe.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class RecipeController {

    private static final String URL = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json";

    @Autowired
    private RecipeRepository recipeRepository;

    @PostConstruct
    private void loadData() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Recipe[]> response =
                restTemplate.getForEntity(
                        URL, Recipe[].class);
        Recipe[] recipe = response.getBody();

        for (Recipe value : recipe) {
            recipeRepository.save(value);
        }
    }

    @ResponseBody
    @GetMapping("/")
    public List<Recipe> showAllRecipes() {
        List<Recipe> recipe = recipeRepository.findAll();
        return recipe;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Recipe showRecipe(@PathVariable("id") long id) {
        Recipe recipe = recipeRepository.findRecipeById(id);
        return recipe;
    }

    @ResponseBody
    @PostMapping("/")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    @ResponseBody
    @GetMapping("/{id}/show")
    public String showRecipeImage(@PathVariable long id) {
        return recipeRepository.findRecipeById(id).image;
    }
}
