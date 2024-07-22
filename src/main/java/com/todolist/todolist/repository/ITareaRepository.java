package com.todolist.todolist.repository;

import org.springframework.stereotype.Repository;
import com.todolist.todolist.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {

}
