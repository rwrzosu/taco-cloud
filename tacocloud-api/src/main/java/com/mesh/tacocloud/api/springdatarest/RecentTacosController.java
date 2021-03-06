package com.mesh.tacocloud.api.springdatarest;

import com.mesh.tacocloud.api.v2.TacoResource;
import com.mesh.tacocloud.api.v2.TacoResourceAssembler;
import com.mesh.tacocloud.data.TacoRepository;
import com.mesh.tacocloud.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class RecentTacosController {

    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<TacoResource>> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();

        CollectionModel<TacoResource> tacoResources =
                new TacoResourceAssembler().toCollectionModel(tacos);

        tacoResources.add(
                linkTo(methodOn(RecentTacosController.class).recentTacos()).withRel("recents")
        );

        return new ResponseEntity<>(tacoResources, HttpStatus.OK);
    }

}
