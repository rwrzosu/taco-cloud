package com.mesh.tacocloud.bootstrap;

import com.mesh.tacocloud.data.IngredientRepository;
import com.mesh.tacocloud.data.TacoRepository;
import com.mesh.tacocloud.domain.Ingredient;
import com.mesh.tacocloud.domain.Taco;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TacoRepository tacoRepository;
    private final IngredientRepository ingredientRepository;

    public Bootstrap(TacoRepository tacoRepository, IngredientRepository ingredientRepository) {
        this.tacoRepository = tacoRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Taco taco = new Taco();
        taco.setName("EmptyTaco");
        Ingredient ingredient = new Ingredient("pomidor", "pomidor", Ingredient.Type.VEGGIES);
        Ingredient saved = ingredientRepository.save(ingredient);
        taco.setIngredients(List.of(saved));

        tacoRepository.save(taco);
    }
}
