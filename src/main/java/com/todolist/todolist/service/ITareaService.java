package com.todolist.todolist.service;

import java.util.List;
import com.todolist.todolist.model.Tarea;

public interface ITareaService {
    public void crearTarea(Tarea tarea);

    public List<Tarea> traerTareas();

    public Tarea traerTarea(Long id_tarea);

    public void editarTarea(Long id_tarea, Tarea tarea);

    public void eliminarTarea(Long id_tarea);

    public List<Tarea> traerTareasActivas();

    public List<Tarea> traerTareasDesacivadas();

    public void cambiarEstado(Long id_tarea);
}
