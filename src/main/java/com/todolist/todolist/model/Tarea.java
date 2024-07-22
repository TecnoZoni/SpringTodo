package com.todolist.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarea;
    private String nombreTarea;
    private String descripcionTarea;
    private Boolean estadoTarea = true;

    public Tarea() {
    }

    public Tarea(Long id_tarea, String nombreTarea, String descripcionTarea, boolean estadoTarea) {
        this.id_tarea = id_tarea;
        this.nombreTarea = nombreTarea;
        this.descripcionTarea = descripcionTarea;
        this.estadoTarea = estadoTarea;
    }

}
