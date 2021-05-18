package com.mesh.tacocloud.api;

import com.mesh.tacocloud.api.v2.DesignTacoController2;
import com.mesh.tacocloud.domain.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;


public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoController2.class, TacoResource.class);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return new TacoResource(entity);
    }
}
