package com.mesh.tacocloud.api;

import com.mesh.tacocloud.domain.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;


class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toModel(Ingredient entity) {
        return new IngredientResource(entity);
    }
}