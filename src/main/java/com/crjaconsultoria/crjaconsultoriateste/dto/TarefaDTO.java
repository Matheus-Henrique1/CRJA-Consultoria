package com.crjaconsultoria.crjaconsultoriateste.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.crjaconsultoria.crjaconsultoriateste.entity.Tarefa;
import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TarefaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate prazo;
	private Integer idDepartamento;
	private String departamento;
	private Double duracao;
	private Integer idPessoa;
	private boolean finalizado;

	public TarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.prazo = tarefa.getPrazo();
		this.idDepartamento = tarefa.getIdDepartamento();
		this.duracao = tarefa.getDuracao();
		this.finalizado = tarefa.isFinalizado();
	}

}
