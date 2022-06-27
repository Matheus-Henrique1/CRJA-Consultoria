package com.crjaconsultoria.crjaconsultoriateste.repository;

import com.crjaconsultoria.crjaconsultoriateste.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("SELECT count (p) FROM Tarefa p WHERE p.idDepartamento = :id")
    Integer buscarTotalTarefasPorDepartamento(@Param("id") Integer idDepartamento);

    @Query("SELECT sum (t.duracao) FROM Tarefa t WHERE t.pessoa.id = :id")
    Integer buscarTotalHorasTarefasPorPessoa(@Param("id") Integer idPessoa);

}
