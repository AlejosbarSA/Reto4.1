package com.usa.retos.service;

import com.usa.retos.model.Computer;
import com.usa.retos.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll() {
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id) {
        return computerRepository.getComputer(id);
    }

    public Computer save(Computer computer){
        if(computer.getId()==null){
            return computerRepository.save(computer);
        }else{
            Optional<Computer> e=computerRepository.getComputer(computer.getId());
            if(e.isEmpty()){
                return computerRepository.save(computer);
            }else{
                return computer;
            }
        }
    }

    public Computer update(Computer computer){
        if(computer.getId()!=null){
            Optional<Computer> tmpComputer =computerRepository.getComputer(computer.getId());
            if(!tmpComputer.isEmpty()){
                if(computer.getName()!=null){
                    tmpComputer.get().setName(computer.getName());
                }
                if(computer.getBrand()!=null){
                    tmpComputer.get().setBrand(computer.getBrand()); ;
                }
                if(computer.getYear() !=null){
                    tmpComputer.get().setYear(computer.getYear());
                }
                if(computer.getDescription()!=null){
                    tmpComputer.get().setDescription(computer.getDescription());
                }
                if(computer.getCategory()!=null){
                    tmpComputer.get().setCategory(computer.getCategory());
                }
                computerRepository.save(tmpComputer.get());
                return tmpComputer.get();
            }else{
                return computer;
            }
        }else{
            return computer;
        }
    }

    public boolean deleteComputer(int id) {
        Boolean aBoolean = getComputer(id).map(computer -> {
            computerRepository.delete(computer);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
