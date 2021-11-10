package com.usa.retos.controller;

import com.usa.retos.model.Computer;
import com.usa.retos.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Computer> getMachine(){

        return machineService.getAll();
    }

    @GetMapping("/{idMachine}")
    public Optional<Computer> getMachine (@PathVariable("idMachine") int id) {

        return machineService.getMachine(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer machine) {

        return machineService.save(machine);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)

    public Computer update(@RequestBody Computer machine) {

        return machineService.update(machine);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return machineService.deleteMachine(id);
    }

}
