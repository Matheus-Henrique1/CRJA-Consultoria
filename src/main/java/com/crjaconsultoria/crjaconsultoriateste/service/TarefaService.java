package com.crjaconsultoria.crjaconsultoriateste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crjaconsultoria.crjaconsultoriateste.dto.TarefaDTO;
import com.crjaconsultoria.crjaconsultoriateste.entity.Tarefa;
import com.crjaconsultoria.crjaconsultoriateste.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	PessoaService pessoaService = new PessoaService();
	
	
	public Tarefa montaEntidadeTarefa(Tarefa tarefa, TarefaDTO tarefaDTO) {
		tarefa.setTitulo(tarefaDTO.getTitulo());
		tarefa.setDescricao(tarefaDTO.getDescricao());
		tarefa.setPrazo(tarefaDTO.getPrazo());
		tarefa.setDepartamento(tarefaDTO.getDepartamento());
		tarefa.setDuracao(tarefaDTO.getDuracao());
		tarefa.setPessoa(pessoaService.find(tarefaDTO.getIdPessoa()));
		tarefa.setFinalizado(tarefaDTO.getFinalizado());
		return tarefa;
		
	}

}
