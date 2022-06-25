package com.crjaconsultoria.crjaconsultoriateste.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private DepartamentoEnum departamento;
	private Integer duracao;
	private Integer idPessoa;
	private Boolean finalizado;

}
