package com.crjaconsultoria.crjaconsultoriateste.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.crjaconsultoria.crjaconsultoriateste.dto.TarefaDTO;
import com.crjaconsultoria.crjaconsultoriateste.enums.DepartamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idDepartamento;
	
}
