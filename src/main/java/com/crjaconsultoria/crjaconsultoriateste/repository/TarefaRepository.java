package com.crjaconsultoria.crjaconsultoriateste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crjaconsultoria.crjaconsultoriateste.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
