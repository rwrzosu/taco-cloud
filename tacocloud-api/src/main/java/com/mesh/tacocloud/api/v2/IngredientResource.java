package com.mesh.tacocloud.api.v2;

import com.mesh.tacocloud.domain.Ingredient;
import com.mesh.tacocloud.domain.Ingredient.Type;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "ingredient", collectionRelation = "ingredients")
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
