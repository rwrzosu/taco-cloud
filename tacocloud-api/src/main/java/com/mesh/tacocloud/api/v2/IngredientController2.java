package com.mesh.tacocloud.api.v2;

import com.mesh.tacocloud.data.IngredientRepository;
import com.mesh.tacocloud.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


//@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController2 {

    private IngredientRepository repo;

    @Autowired
    public IngredientController2(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public CollectionModel<IngredientResource> allIngredients() {
        Iterable<Ingredient> ingredients = repo.findAll();

        CollectionModel<IngredientResource> resources = new IngredientResourceAssembler().toCollectionModel(ingredients);

        resources.add(
                linkTo(methodOn(DesignTacoController2.class).recentTacos()).withRel("recent")
        );
        return resources;
    }
}
