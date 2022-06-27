package com.crjaconsultoria.crjaconsultoriateste.repository;

import com.crjaconsultoria.crjaconsultoriateste.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT p FROM Pessoa p WHERE p.idDepartamento = :id")
    List<Pessoa> buscarPessoaPorIdDepartamento(@Param("id") Integer idDepartamento);

    @Query("SELECT count (p) FROM Pessoa p WHERE p.idDepartamento = :id")
    Integer buscarTotalPessoasPorDepartamento(@Param("id") Integer idDepartamento);

}
