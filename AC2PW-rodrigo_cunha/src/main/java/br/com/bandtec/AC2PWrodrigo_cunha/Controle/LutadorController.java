package br.com.bandtec.AC2PWrodrigo_cunha.Controle;

import br.com.bandtec.AC2PWrodrigo_cunha.Dominio.Lutador;
import br.com.bandtec.AC2PWrodrigo_cunha.Repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")

public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @GetMapping
    public ResponseEntity getLutadores(){
        List<Lutador> lutadores = repository.findAllByOrderByForcaGolpeDesc();

        if (lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(lutadores);
        }
    }


    @GetMapping("/contagem-vivos")
    public ResponseEntity getLutadoresVivos(){
        long totalVivos = repository.countAllByVivoTrue();
        return ResponseEntity.status(201).build();
    }


    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

}