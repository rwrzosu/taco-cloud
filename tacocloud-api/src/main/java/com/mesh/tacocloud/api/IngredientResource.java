package com.mesh.tacocloud.api;

import com.mesh.tacocloud.domain.Ingredient;
import com.mesh.tacocloud.domain.Ingredient.Type;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    @Getter
    private String name;

    @Getter
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}
