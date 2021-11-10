package com.usa.retos.repository;

import com.usa.retos.crud.MachineCrud;
import com.usa.retos.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrud machineCrud;

    public List<Computer> getAll() {
        return (List<Computer>) machineCrud.findAll();
    }

    public Optional<Computer> getMachine(int id) {
        return machineCrud.findById(id);
    }

    public Computer save (Computer machine) {
        return machineCrud.save(machine);
    }

    public void delete (Computer machine) {
        machineCrud.delete(machine);
    }
}
