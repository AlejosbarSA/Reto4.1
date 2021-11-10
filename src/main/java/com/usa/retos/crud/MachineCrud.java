package com.usa.retos.crud;

import com.usa.retos.model.Computer;
import org.springframework.data.repository.CrudRepository;

public interface MachineCrud extends CrudRepository<Computer, Integer> {
}
