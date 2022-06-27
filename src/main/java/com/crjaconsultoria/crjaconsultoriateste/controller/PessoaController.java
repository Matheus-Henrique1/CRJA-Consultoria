package com.crjaconsultoria.crjaconsultoriateste.controller;

import java.util.List;

import com.crjaconsultoria.crjaconsultoriateste.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crjaconsultoria.crjaconsultoriateste.dto.PessoaDTO;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> cadastrar(@RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok().body(pessoaService.cadastrar(pessoaDTO));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok().body(pessoaService.atualizar(id, pessoaDTO));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletar(@PathVariable Integer id){
		return ResponseEntity.ok(pessoaService.deletar(id));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> buscarPessoas() throws Exception {
		return ResponseEntity.ok(pessoaService.buscarPessoas());
	}

}
