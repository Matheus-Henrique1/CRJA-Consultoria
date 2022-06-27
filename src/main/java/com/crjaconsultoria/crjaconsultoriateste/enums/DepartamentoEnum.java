package com.crjaconsultoria.crjaconsultoriateste.enums;

import java.util.Arrays;
import java.util.Objects;

import com.crjaconsultoria.crjaconsultoriateste.service.exceptions.ObjectNotFoundException;

import lombok.Getter;

@Getter
public enum DepartamentoEnum {

	INICIO_ENUM(0, ""),
	FINANCEIRO(1, "Financeiro"),
	COMERCIAL(2, "Comercial"),
	DESENVOLVIMENTO(3, "Desenvolvimento");

	private int cod;
	private String descricao;

	private DepartamentoEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static DepartamentoEnum toEnum(Integer cod) {
		if (Objects.isNull(cod)) {
			return null;
		}
		for (DepartamentoEnum item : DepartamentoEnum.values()) {
			if (item.cod == cod) {
				return item;
			}
		}
		throw new ObjectNotFoundException("Código do departamento inválido: " + cod);
	}
	
	public static String getDescricaoDepartamentoEnum(DepartamentoEnum departamentoEnum) {
        return Arrays.stream(DepartamentoEnum.values())
                .filter(item -> item == departamentoEnum)
                .map(DepartamentoEnum::getDescricao)
                .findFirst().orElse(null);
    }

}
