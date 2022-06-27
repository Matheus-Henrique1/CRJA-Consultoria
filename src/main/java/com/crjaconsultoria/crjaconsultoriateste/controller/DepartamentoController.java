package com.crjaconsultoria.crjaconsultoriateste.controller;

import com.crjaconsultoria.crjaconsultoriateste.dto.DepartamentoDTO;
import com.crjaconsultoria.crjaconsultoriateste.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DepartamentoDTO>> buscarDepartamentos(){
        return ResponseEntity.ok(departamentoService.buscarDepartamentos());
    }

}
