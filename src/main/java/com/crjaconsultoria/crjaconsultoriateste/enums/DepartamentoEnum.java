package com.crjaconsultoria.crjaconsultoriateste.enums;

import lombok.Getter;

@Getter
public enum DepartamentoEnum {

	FINANCEIRO(1, "Financeiro"),
	COMERCIAL(2, "Comercial"),
	DESENVOLVIMENTO(3, "Desenvolvimento");
	
	private int cod;
	private String descricao;
	
	private DepartamentoEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
}


