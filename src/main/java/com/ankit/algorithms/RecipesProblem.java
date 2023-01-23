package com.ankit.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RecipesProblem {

    private static List<Recipe> findAllPossibleRecipes(List<Recipe> recipeList, List<String> supplies){
        return null;
    }

    public static void main(String[] args) {
        Recipe bread = Recipe.builder()
                .name("Bread")
                .addRaw("Flour")
                .addRaw("Yeast")
                .addRaw("Water")
                .build();
        Recipe cheeseSandwich = Recipe.builder()
                .name("Cheese Sandwich")
                .addRaw("Cheese")
                .addIntermediate("Bread")
                .build();

        List<Recipe> recipeList = List.of(bread, cheeseSandwich);
        List<String> supplies = List.of("Water", "Flour", "Meat", "Cheese");

        System.out.println(findAllPossibleRecipes(recipeList, supplies));
    }
}


class Recipe{
    private String name;
    private List<String> raw;
    private List<String> intermediate;
    private RecipeBuilder builder;
    public static class RecipeBuilder{
        private String name;
        private List<String> raw = new ArrayList<>();
        private List<String> intermediate = new ArrayList<>();

        public RecipeBuilder name(String n){
            this.name = n;
            return this;
        }

        public RecipeBuilder addIntermediate(String n){
            this.intermediate.add(n);
            return this;
        }

        public RecipeBuilder addRaw(String n){
            this.raw.add(n);
            return this;
        }

        public Recipe build(){
            Recipe recipe = new Recipe();
            recipe.name  = this.name;
            recipe.intermediate = this.intermediate;
            recipe.builder = this;
            return recipe;
        }

    }

    public static RecipeBuilder builder(){
        return new RecipeBuilder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRaw() {
        return raw;
    }

    public void setRaw(List<String> raw) {
        this.raw = raw;
    }

    public List<String> getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(List<String> intermediate) {
        this.intermediate = intermediate;
    }
}
