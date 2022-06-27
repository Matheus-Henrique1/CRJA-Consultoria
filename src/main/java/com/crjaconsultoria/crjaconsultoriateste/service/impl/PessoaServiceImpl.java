package com.crjaconsultoria.crjaconsultoriateste.service.impl;

import com.crjaconsultoria.crjaconsultoriateste.dto.PessoaDTO;
import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;
import com.crjaconsultoria.crjaconsultoriateste.repository.PessoaRepository;
import com.crjaconsultoria.crjaconsultoriateste.repository.TarefaRepository;
import com.crjaconsultoria.crjaconsultoriateste.service.PessoaService;
import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.ObjectNotFoundException;
import com.crjaconsultoria.crjaconsultoriateste.shared.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                Mensagens.REGISTRO_NAO_ENCONTRADO));
    }

    private Pessoa montaEntidadePessoa(Pessoa entidadePessoa, PessoaDTO pessoaDTO) {
        entidadePessoa.setNome(pessoaDTO.getNome());
        entidadePessoa.setIdDepartamento(pessoaDTO.getIdDepartamento());
        return entidadePessoa;
    }

    private PessoaDTO montaPessoaDTO(PessoaDTO pessoaDTO, Pessoa entidadePessoa) {
        pessoaDTO.setId(entidadePessoa.getId());
        pessoaDTO.setNome(entidadePessoa.getNome());
        pessoaDTO.setIdDepartamento(entidadePessoa.getIdDepartamento());
        pessoaDTO.setDepartamento(DepartamentoEnum.toEnum(entidadePessoa.getIdDepartamento()).getDescricao());
        return pessoaDTO;
    }

    @Override
    public String cadastrar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        montaEntidadePessoa(pessoa, pessoaDTO);
        pessoaRepository.save(pessoa);
        return Mensagens.REGISTRO_CADASTRADO;
    }

    @Override
    public String atualizar(Integer id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = find(id);
        montaEntidadePessoa(pessoa, pessoaDTO);
        pessoaRepository.save(pessoa);
        return Mensagens.REGISTRO_ATUALIZADO;
    }

    @Override
    public String deletar(Integer id) {
        pessoaRepository.delete(find(id));
        return Mensagens.REGISTRO_EXCLUIDO;
    }

    @Override
    public List<PessoaDTO> buscarPessoas() throws Exception {
        List<PessoaDTO> listaPessoasDTO = new ArrayList<>();
        List<Pessoa> listaPessoas = pessoaRepository.findAll();
        if (!listaPessoas.isEmpty()) {
            for (Pessoa item : listaPessoas) {
                PessoaDTO pessoaDTO = new PessoaDTO(item.getNome());
                pessoaDTO.setDepartamento(DepartamentoEnum.toEnum(item.getIdDepartamento()).getDescricao());
                pessoaDTO.setTodaHorasTarefas(tarefaRepository.buscarTotalHorasTarefasPorPessoa(item.getId()));
                listaPessoasDTO.add(pessoaDTO);
            }
            return listaPessoasDTO;
        } else {
            throw new ObjectNotFoundException(Mensagens.LISTA_VAZIA);
        }

    }

    @Override
    public Pessoa buscarPessoaPorIdDepartamento(Integer idDepartamento) throws Exception {
        List<Pessoa> pessoas = pessoaRepository.buscarPessoaPorIdDepartamento(idDepartamento);
        if (!pessoas.isEmpty()) {
            Pessoa pessoa = pessoas.get(0);
            return pessoa;
        } else {
            throw new ObjectNotFoundException("Não tem pessoa nesse departamento!");
        }
    }

    @Override
    public Integer buscarTotalDePessoasPorDepartamento(Integer idDepartamento) {
        Integer totalPessoasDepartamento = pessoaRepository.buscarTotalPessoasPorDepartamento(idDepartamento);
        return totalPessoasDepartamento;
    }
}
