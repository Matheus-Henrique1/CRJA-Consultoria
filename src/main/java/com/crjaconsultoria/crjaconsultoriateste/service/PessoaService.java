package com.crjaconsultoria.crjaconsultoriateste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crjaconsultoria.crjaconsultoriateste.dto.PessoaDTO;
import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import com.crjaconsultoria.crjaconsultoriateste.repository.PessoaRepository;
import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.ObjectNotFoundException;
import com.crjaconsultoria.crjaconsultoriateste.shared.Mensagens;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	TarefaService tarefaService;
	
	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id ));
	}
	
	private Pessoa montaEntidadePessoa(Pessoa entidadePessoa, PessoaDTO pessoaDTO) {
		entidadePessoa.setNome(pessoaDTO.getNome());
		entidadePessoa.setDepartamento(pessoaDTO.getDepartamento());
		return entidadePessoa;
	}
	
	public String cadastrar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		montaEntidadePessoa(pessoa, pessoaDTO);
		pessoaRepository.save(pessoa);
		return Mensagens.REGISTRO_CADASTRADO;
	}
	
	public String atualizar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = find(pessoaDTO.getId());
		montaEntidadePessoa(pessoa, pessoaDTO);
		pessoaRepository.save(pessoa);
		return Mensagens.REGISTRO_ATUALIZADO;
	}
	
	public String deletar(Integer id) {
		Pessoa pessoa = find(id);
		pessoaRepository.delete(pessoa);
		return Mensagens.REGISTRO_EXCLUIDO;
	}
	
	

}
