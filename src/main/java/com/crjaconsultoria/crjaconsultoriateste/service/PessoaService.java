package com.crjaconsultoria.crjaconsultoriateste.service;

import com.crjaconsultoria.crjaconsultoriateste.dto.PessoaDTO;
import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PessoaService {

    Pessoa find(Integer id);

    String cadastrar(PessoaDTO pessoaDTO);

    String atualizar(Integer id, PessoaDTO pessoaDTO);

    String deletar(Integer id) ;

    List<PessoaDTO> buscarPessoas() throws Exception;

    Pessoa buscarPessoaPorIdDepartamento(Integer idDepartamento) throws Exception;

    List<PessoaDTO> buscarPessoaPorNomeEPeriodo();

}
