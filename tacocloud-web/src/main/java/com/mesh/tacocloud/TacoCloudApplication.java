package com.mesh.tacocloud;

import com.mesh.tacocloud.api.v2.TacoResource;
import com.mesh.tacocloud.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;

@Slf4j
@SpringBootApplication
public class TacoCloudApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TacoCloudApplication.class, args);

        {
            RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);

            Taco entity = restTemplate.getForObject("http://localhost:8080/api/tacos/{id}", Taco.class, "1");
            System.out.println(entity.toString());
        }


        Traverson traverson = new Traverson(
                URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON);

        ParameterizedTypeReference<CollectionModel<TacoResource>> tacoType = new ParameterizedTypeReference<CollectionModel<TacoResource>>() { };

        CollectionModel<TacoResource> tacoRes =
                traverson
                        .follow("tacos")
                        .follow("recents")
                        .toObject(tacoType);

        Collection<TacoResource> tacos = tacoRes.getContent();
        tacos.forEach( i -> System.out.println(i.toString() + "/////////"));

        log.info("{} --- {}", "1", "2");



    }

}
