package br.com.dianome.entregadores.controllers;

import br.com.dianome.entregadores.dtos.EntregadorDto;
import br.com.dianome.entregadores.models.EntregadorModel;
import br.com.dianome.entregadores.repositories.EntregadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntregadoresController {
    @Autowired
    EntregadorRepository entregadorRepository;

    @GetMapping("/entregadores")
    public ResponseEntity<List<EntregadorModel>> listar(){
        List<EntregadorModel> entregadorList = entregadorRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(entregadorList);
    }

    @PostMapping("/entregador")
    public ResponseEntity<EntregadorModel> salvar(@RequestBody @Valid EntregadorDto entregadorDto){
        var entregadorModel = new EntregadorModel();
        BeanUtils.copyProperties(entregadorDto, entregadorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(entregadorRepository.save(entregadorModel));
    }

    @GetMapping("/entregador/{id}")
    public ResponseEntity<Object> detalhar(@PathVariable(value = "id")Integer id){
        Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
        if(entregador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entregador.get());
    }

    @PutMapping("/entregador/{id}")
    public ResponseEntity<Object> atualizarEntregador(@PathVariable(value = "id") Integer id,
                                                      @RequestBody @Valid EntregadorDto entregadorDto){
        Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
        if (entregador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não enconstrado para edição.");
        }
        var entregadorModel = entregador.get();
        BeanUtils.copyProperties(entregadorDto, entregadorModel);
        return ResponseEntity.status(HttpStatus.OK).body(entregadorRepository.save(entregadorModel));
    }
    @DeleteMapping("/entregador/{id}")
    public ResponseEntity<Object> deletarEntregador(@PathVariable(value = "id") Integer id){
        Optional<EntregadorModel> entregador = entregadorRepository.findById(id);
        if (entregador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para Exclusão");
        }
        entregadorRepository.delete(entregador.get());
        return ResponseEntity.status(HttpStatus.OK).body("O Entregador foi excluído.");
    }

}
