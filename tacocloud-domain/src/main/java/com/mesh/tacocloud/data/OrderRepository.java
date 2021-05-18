package com.mesh.tacocloud.data;

import com.mesh.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository
        extends CrudRepository<Order, Long> {

}
