package com.crjaconsultoria.crjaconsultoriateste.service.impl;

import com.crjaconsultoria.crjaconsultoriateste.dto.TarefaDTO;
import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import com.crjaconsultoria.crjaconsultoriateste.entity.Tarefa;
import com.crjaconsultoria.crjaconsultoriateste.repository.TarefaRepository;
import com.crjaconsultoria.crjaconsultoriateste.service.PessoaService;
import com.crjaconsultoria.crjaconsultoriateste.service.TarefaService;
import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.ObjectNotFoundException;
import com.crjaconsultoria.crjaconsultoriateste.shared.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    PessoaService pessoaService;

    public Tarefa find(Integer id) {
        Optional<Tarefa> obj = tarefaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                Mensagens.REGISTRO_NAO_ENCONTRADO));
    }

    public Tarefa montaEntidadeTarefa(Tarefa tarefa, TarefaDTO tarefaDTO) {
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setPrazo(tarefaDTO.getPrazo());
        tarefa.setIdDepartamento(tarefaDTO.getIdDepartamento());
        tarefa.setDuracao(tarefaDTO.getDuracao());
        if (Objects.nonNull(tarefaDTO.getIdPessoa())) {
            tarefa.setPessoa(pessoaService.find(tarefaDTO.getIdPessoa()));
        }
        tarefa.setFinalizado(tarefaDTO.isFinalizado());
        return tarefa;
    }

    @Override
    public String cadastrar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        montaEntidadeTarefa(tarefa, tarefaDTO);
        tarefaRepository.save(tarefa);
        return Mensagens.REGISTRO_CADASTRADO;
    }

    @Override
    public String finalizar(Integer id) {
        Tarefa tarefa = find(id);
        if (tarefa.isFinalizado()) {
            tarefa.setFinalizado(true);
            tarefaRepository.save(tarefa);
            return Mensagens.REGISTRO_ATUALIZADO;
        } else {
            return Mensagens.REGISTRO_FINALIZADO;
        }
    }

    @Override
    public String alocarPessoaTarefa(Integer id) throws Exception {
        Tarefa tarefa = find(id);
        Pessoa pessoa = pessoaService.buscarPessoaPorIdDepartamento(tarefa.getIdDepartamento());
        tarefa.setPessoa(pessoa);
        tarefaRepository.save(tarefa);
        return Mensagens.REGISTRO_ATUALIZADO;
    }
}
