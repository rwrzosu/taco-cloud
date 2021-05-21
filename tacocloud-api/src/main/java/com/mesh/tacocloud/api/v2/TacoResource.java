package com.mesh.tacocloud.api.v2;

import com.mesh.tacocloud.domain.Taco;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Relation(value = "taco", collectionRelation = "tacos")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class TacoResource extends RepresentationModel<TacoResource> {

    private static final IngredientResourceAssembler ingredientAssembler = new IngredientResourceAssembler();

    @Getter
    private String name;

    @Getter
    private Date createdAt;

    @Getter
    private CollectionModel<IngredientResource> ingredients;

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }

}
