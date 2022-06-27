package com.crjaconsultoria.crjaconsultoriateste.service;

import com.crjaconsultoria.crjaconsultoriateste.dto.TarefaDTO;
import org.springframework.stereotype.Component;

@Component
public interface TarefaService {

    String cadastrar(TarefaDTO tarefaDTO);

    String finalizar(Integer id);

    String alocarPessoaTarefa(Integer id) throws Exception;
}
