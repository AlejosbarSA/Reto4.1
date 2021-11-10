package com.usa.retos.repository;

import com.usa.retos.crud.ComputerCrud;
import com.usa.retos.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {
    @Autowired
    private ComputerCrud computerCrud;

    public List<Computer> getAll() {
        return (List<Computer>) computerCrud.findAll();
    }

    public Optional<Computer> getComputer(int id) {
        return computerCrud.findById(id);
    }

    public Computer save (Computer computer) {
        return computerCrud.save(computer);
    }

    public void delete (Computer computer) {
        computerCrud.delete(computer);
    }
}
