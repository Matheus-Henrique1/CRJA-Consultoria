package com.crjaconsultoria.crjaconsultoriateste.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDate prazo;
	private Integer idDepartamento;
	private Integer duracao;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id" , referencedColumnName = "id")
	private Pessoa pessoa;
	private boolean finalizado;
	

}


