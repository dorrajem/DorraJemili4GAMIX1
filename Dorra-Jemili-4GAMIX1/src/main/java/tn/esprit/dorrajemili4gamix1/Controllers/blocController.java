package tn.esprit.dorrajemili4gamix1.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dorrajemili4gamix1.Entity.Bloc;
import tn.esprit.dorrajemili4gamix1.Services.IBlocService;

@RestController

public class blocController {
    public blocController(IBlocService blocService) {
        BlocService = blocService;
    }

    private final IBlocService BlocService;

    @PostMapping("/addBloc" )
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return BlocService.ajouterBloc(bloc);
    }
    @PutMapping("/updateBloc" )
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return BlocService.modifiererBloc(bloc);
    }

    @DeleteMapping("/deleteBloc/{idBloc}" )
    public void deleteBloc(@PathVariable Long idBloc) {
        BlocService.supprimerBloc(idBloc);
    }
    @GetMapping("/getBloc/{idBloc}" )
    public Bloc getBlocBy(@PathVariable Long idBloc) {
        return BlocService.getBloc(idBloc);
    }

    @GetMapping("/getAllBlocs" )
    public java.util.List<Bloc> getAllBlocs() {
        return BlocService.getBlocs();
    }

}
