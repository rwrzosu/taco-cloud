package com.mesh.tacocloud.data;

import com.mesh.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
