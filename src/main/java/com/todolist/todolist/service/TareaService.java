package com.todolist.todolist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.model.Tarea;
import com.todolist.todolist.repository.ITareaRepository;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private ITareaRepository tareaRepo;

    @Override
    public void crearTarea(Tarea tarea) {
        tareaRepo.save(tarea);
    }

    @Override
    public List<Tarea> traerTareas() {
        return tareaRepo.findAll();
    }

    @Override
    public Tarea traerTarea(Long id_tarea) {
        return tareaRepo.findById(id_tarea).orElse(null);
    }

    @Override
    public void editarTarea(Long id_tarea, Tarea tarea) {
        Tarea tare = this.traerTarea(id_tarea);
        tare.setNombreTarea(tarea.getNombreTarea());
        tare.setDescripcionTarea(tarea.getDescripcionTarea());
        tare.setEstadoTarea(tarea.getEstadoTarea());
        this.crearTarea(tare);
    }

    @Override
    public void eliminarTarea(Long id_tarea) {
        tareaRepo.deleteById(id_tarea);
    }

    @Override
    public List<Tarea> traerTareasActivas() {
        List<Tarea> listaTareas = this.traerTareas();
        List<Tarea> listaTareasActivas = new ArrayList<Tarea>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getEstadoTarea() == true) {
                listaTareasActivas.add(tarea);
            }
        }

        return listaTareasActivas;
    }

    @Override
    public List<Tarea> traerTareasDesacivadas() {
        List<Tarea> listaTareas = this.traerTareas();
        List<Tarea> listaTareasDesactivadas = new ArrayList<Tarea>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getEstadoTarea() == false) {
                listaTareasDesactivadas.add(tarea);
            }
        }

        return listaTareasDesactivadas;
    }

    @Override
    public void cambiarEstado(Long id_tarea) {
        Tarea tarea = this.traerTarea(id_tarea);
        if (tarea.getEstadoTarea() == true) {
            tarea.setEstadoTarea(false);
        } else {
            tarea.setEstadoTarea(true);
        }
        this.crearTarea(tarea);
    }

}
