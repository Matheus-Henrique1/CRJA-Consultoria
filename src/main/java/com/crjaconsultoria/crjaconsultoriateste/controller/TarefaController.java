package com.crjaconsultoria.crjaconsultoriateste.controller;

import com.crjaconsultoria.crjaconsultoriateste.dto.TarefaDTO;
import com.crjaconsultoria.crjaconsultoriateste.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> cadastrar(@RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok().body(tarefaService.cadastrar(tarefaDTO));
    }

    @RequestMapping(value = "/finalizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> finalizar(@PathVariable Integer id){
        return ResponseEntity.ok(tarefaService.finalizar(id));
    }

    @RequestMapping(value = "/alocar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> alocar(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(tarefaService.alocarPessoaTarefa(id));
    }

    @RequestMapping(value = "/pendentes", method = RequestMethod.GET)
    public ResponseEntity<List<TarefaDTO>> listarTarefasAntigas(){
        return ResponseEntity.ok(tarefaService.listarTarefasAntigas());
    }

}
