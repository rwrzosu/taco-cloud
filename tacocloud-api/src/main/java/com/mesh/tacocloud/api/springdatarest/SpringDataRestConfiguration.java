package com.mesh.tacocloud.api.springdatarest;

import com.mesh.tacocloud.api.v2.TacoResource;
import com.mesh.tacocloud.domain.Taco;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public RepresentationModelProcessor<RepresentationModel<TacoResource>> recentTacoProcessor(EntityLinks links) {

        return new RepresentationModelProcessor<RepresentationModel<TacoResource>>() {
            @Override
            public RepresentationModel<TacoResource> process(
                    RepresentationModel<TacoResource> resource) {

                resource.add(
                        links.linkFor(Taco.class)
                                .slash("recent")
                                .withRel("recents"));
                return resource;
            }
        };
    }

}
