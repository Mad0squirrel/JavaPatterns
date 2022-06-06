package com.example.newtask15.services;

import com.example.newtask15.Manufacture;
import com.example.newtask15.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManufactureService {
    private ManufactureRepository manufactureRepository;

    @Autowired
    ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    public void create(Manufacture manufacture) {
        log.info("Save manufacture");
        manufactureRepository.save(manufacture);
    }

    public List<Manufacture> readAll() {
        log.info("Read all manufactures");
        return manufactureRepository.findAll();
    }

    public Manufacture read(long id) {
        log.info("Read manufacture by id = {}", id);
        return manufactureRepository.getById(id);
    }

    public boolean update(Manufacture manufacture, long id) {
        log.info("Update manufacture with id = {}", id);
        manufacture.setId(id);
        manufactureRepository.save(manufacture);
        return true;
    }

    public boolean delete(long id) {
        log.info("Delete manufacture by id = {}", id);
        manufactureRepository.deleteById(id);
        return true;
    }

    public List<Manufacture> findManufacturesByCode(int code) {
        log.info("Find manufactures by code = {}", code);
        return manufactureRepository.findAllByCode(code);
    }

}