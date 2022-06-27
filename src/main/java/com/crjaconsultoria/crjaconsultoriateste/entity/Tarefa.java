package com.crjaconsultoria.crjaconsultoriateste.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.persistence.*;

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
@Table(name = "tarefa")
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
	private Double duracao;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id" , referencedColumnName = "id")
	private Pessoa pessoa;
	private boolean finalizado;

	public Tarefa(LocalDate prazo, Double duracao) {
		this.prazo = prazo;
		this.duracao = duracao;
	}

}


