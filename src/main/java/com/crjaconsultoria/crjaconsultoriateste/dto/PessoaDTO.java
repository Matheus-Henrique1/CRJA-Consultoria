package com.crjaconsultoria.crjaconsultoriateste.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer idDepartamento;
	private String departamento;
	private Integer todaHorasTarefas;

	public PessoaDTO(String nome){
		this.nome = nome;
	}
}
