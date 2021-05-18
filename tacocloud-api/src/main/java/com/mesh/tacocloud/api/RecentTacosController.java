package com.mesh.tacocloud.api;

import com.mesh.tacocloud.data.TacoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecentTacosController {

    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

//    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
//    public ResponseEntity<Resources<TacoResource>> recentTacos() {
//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        List<Taco> tacos = tacoRepo.findAll(page).getContent();
//
//        List<TacoResource> tacoResources =
//                new TacoResourceAssembler().toResources(tacos);
//        Resources<TacoResource> recentResources =
//                new Resources<TacoResource>(tacoResources);
//
//        recentResources.add(
//                linkTo(methodOn(RecentTacosController.class).recentTacos())
//                        .withRel("recents"));
//        return new ResponseEntity<>(recentResources, HttpStatus.OK);
//    }

}
