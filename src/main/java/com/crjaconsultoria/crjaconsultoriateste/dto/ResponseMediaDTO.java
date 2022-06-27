package com.crjaconsultoria.crjaconsultoriateste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMediaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double mediaHorasGastas;
    private int periodo;
}
