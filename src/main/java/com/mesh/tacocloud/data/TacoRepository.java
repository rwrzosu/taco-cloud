package com.mesh.tacocloud.data;

import com.mesh.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
