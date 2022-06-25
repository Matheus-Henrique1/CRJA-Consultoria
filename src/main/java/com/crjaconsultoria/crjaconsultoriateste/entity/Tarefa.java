package com.crjaconsultoria.crjaconsultoriateste.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private Integer idDepartamento;
	private Integer duracao;
	private Integer idPessoa;
	private boolean finalizado;
	
	
	

}


