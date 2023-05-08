package com.party.controller;


import com.party.EquipmentStatus;
import com.party.PartyEquipmentInt;
import com.party.model.PartyEquipment;
import com.party.repository.PartyEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class PartyService implements PartyEquipmentInt {

    @Autowired
    private PartyEquipmentRepository equipmentRepository;

    @GetMapping("party_equipments")
    public List<PartyEquipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @GetMapping(value = "getByStatus")
    public List<PartyEquipment> getEquipmentByStatus(@RequestParam("status") EquipmentStatus status) {return equipmentRepository.findByStatus(status);}

    @GetMapping("getById")
    @Override
    public Optional<PartyEquipment> getEquipmentById(@RequestParam("id") Long id) {return equipmentRepository.findById(id); }

    @GetMapping(value = "getByName")
    public List<PartyEquipment> getEquipmentByName(@RequestParam("name") String name) {return equipmentRepository.findByName(name);}

    @GetMapping(value = "getByDescription")
    public List<PartyEquipment> getEquipmentByDescription(@RequestParam("description") String description) {return equipmentRepository.findByBeschreibung(description);}

    @Override
    public void addEquipment(PartyEquipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public void updateEquipment(PartyEquipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Transactional
    @Override
    public void ausleihen(Long id) {
        Optional<PartyEquipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent() && equipment.get().getStatus() == EquipmentStatus.VERFUEGBAR) {
            PartyEquipment eq = equipment.get();
            eq.setStatus(EquipmentStatus.AUSGELIEHEN);
            equipmentRepository.save(eq);
        }
    }

    @Transactional
    @Override
    public void zurueckgeben(Long id) {
        Optional<PartyEquipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent() && equipment.get().getStatus() == EquipmentStatus.AUSGELIEHEN) {
            equipment.get().setStatus(EquipmentStatus.VERFUEGBAR);
            equipmentRepository.save(equipment.get());
        }
    }

    @Transactional
    @Override
    public void defektMelden(Long id) {
        Optional<PartyEquipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent()) {
            equipment.get().setStatus(EquipmentStatus.DEFEKT);
            equipmentRepository.save(equipment.get());
        }
    }

    @Transactional
    @Override
    public void repariertMarkieren(Long id) {
        Optional<PartyEquipment> equipment = equipmentRepository.findById(id);
        if (equipment.isPresent() && equipment.get().getStatus() == EquipmentStatus.DEFEKT) {
            equipment.get().setStatus(EquipmentStatus.VERFUEGBAR);
            equipmentRepository.save(equipment.get());
        }
    }
}
