package com.mesh.tacocloud.data;

import com.mesh.tacocloud.domain.Taco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}
