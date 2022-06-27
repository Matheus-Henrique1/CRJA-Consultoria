package com.crjaconsultoria.crjaconsultoriateste.service;

import com.crjaconsultoria.crjaconsultoriateste.dto.DepartamentoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DepartamentoService {

    List<DepartamentoDTO> buscarDepartamentos();

}
