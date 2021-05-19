package com.mesh.tacocloud.api.v2;

import com.mesh.tacocloud.domain.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;


public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoController2.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateModel(Taco entity) {
        return new TacoResource(entity);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }

}
