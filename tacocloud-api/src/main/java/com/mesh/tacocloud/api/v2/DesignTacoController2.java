package com.mesh.tacocloud.api.v2;

import com.mesh.tacocloud.data.TacoRepository;
import com.mesh.tacocloud.domain.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@RestController
@RequestMapping(path = "/api/v2/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController2 {
    private TacoRepository tacoRepo;

    public DesignTacoController2(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }


    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();

        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(tacos);
        tacoResources.add(
                linkTo(methodOn(DesignTacoController2.class).recentTacos()).withRel("recents")
        );

        return tacoResources;
    }


//ControllerLinkBuilder.linkTo(DesignTacoController.class)
//.slash("recent")
//.withRel("recents"));


//  @GetMapping("/recenth")
//  public Resources<TacoResource> recenthTacos() {
//    PageRequest page = PageRequest.of(
//            0, 12, Sort.by("createdAt").descending());
//    List<Taco> tacos = tacoRepo.findAll(page).getContent();
//
//    List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
//    
//    Resources<TacoResource> tacosResources = new Resources<>(tacoResources);
////    Link recentsLink = ControllerLinkBuilder
////        .linkTo(DesignTacoController.class)
////        .slash("recent")
////        .withRel("recents");
//
//    Link recentsLink = 
//        linkTo(methodOn(DesignTacoController.class).recentTacos())
//        .withRel("recents");
//    tacosResources.add(recentsLink);
//    return tacosResources;
//  }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }


    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        return optTaco.orElse(null);
    }

//  @GetMapping("/{id}")
//  public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
//    Optional<Taco> optTaco = tacoRepo.findById(id);
//    if (optTaco.isPresent()) {
//      return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
//    }
//    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//  }


}
