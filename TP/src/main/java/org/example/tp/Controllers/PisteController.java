package org.example.tp.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.tp.Entities.Piste;
import org.example.tp.Services.IPisteService;

@RestController

public class PisteController
{
    public PisteController(IPisteService pisteService) {
        PisteService = pisteService;
    }
    @Autowired
    private final IPisteService PisteService;

    @PostMapping("/addPiste" )
    public Piste addPiste(@RequestBody Piste piste) {
        return PisteService.addPiste(piste);
    }
    @PutMapping("/updatePiste" )
    public Piste updatePiste(@RequestBody Piste piste) {
        return PisteService.updatePiste(piste);
    }

    @GetMapping("/getPiste/{numPiste}" )
    public Piste getPisteBy(@PathVariable Long numPiste) {
        return PisteService.retrievePiste(numPiste);
    }

    @GetMapping("/getAllPistes" )
    public java.util.List<Piste> getAllPistes() {
        return PisteService.retrieveAllPistes();
    }

    @PutMapping("/deletePiste" )
    public void deletePiste(@RequestBody Long numPiste) {
        PisteService.removePiste(numPiste);
    }
}
