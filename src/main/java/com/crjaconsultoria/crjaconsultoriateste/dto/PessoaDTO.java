package com.crjaconsultoria.crjaconsultoriateste.dto;

import java.io.Serializable;
import java.util.List;

import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private DepartamentoEnum departamento;

}
