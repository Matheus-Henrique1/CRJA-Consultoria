package com.crjaconsultoria.crjaconsultoriateste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crjaconsultoria.crjaconsultoriateste.dto.PessoaDTO;
import com.crjaconsultoria.crjaconsultoriateste.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> cadastrar(@RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok().body(pessoaService.cadastrar(pessoaDTO));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> atualizar(@RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok().body(pessoaService.atualizar(pessoaDTO));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletar(@PathVariable Integer id){
		return ResponseEntity.ok(pessoaService.deletar(id));
	}

}
