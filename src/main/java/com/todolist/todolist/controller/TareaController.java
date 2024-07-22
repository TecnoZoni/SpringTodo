package com.todolist.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.model.Tarea;
import com.todolist.todolist.service.ITareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private ITareaService tareaService;

    @PostMapping
    public ResponseEntity<String> crearTarea(@RequestBody Tarea tarea) {
        tareaService.crearTarea(tarea);
        return ResponseEntity.ok("La Tarea se creo con Exito.");
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> traerTareas() {
        List<Tarea> listaTareas = tareaService.traerTareas();
        return ResponseEntity.ok(listaTareas);
    }

    @GetMapping("/{id_tarea}")
    public ResponseEntity<Tarea> traerTarea(@PathVariable Long id_tarea) {
        Tarea tarea = tareaService.traerTarea(id_tarea);
        return ResponseEntity.ok(tarea);
    }

    @PutMapping("/{id_tarea}")
    public ResponseEntity<String> editarTarea(@PathVariable Long id_tarea, @RequestBody Tarea tarea) {
        tareaService.editarTarea(id_tarea, tarea);
        return ResponseEntity.ok("La Tarea se edito con Exito.");
    }

    @DeleteMapping("/{id_tarea}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id_tarea) {
        tareaService.eliminarTarea(id_tarea);
        return ResponseEntity.ok("La Tarea se elimino con Exito.");
    }

    @GetMapping("/activas")
    public ResponseEntity<List<Tarea>> traerTareasActivas() {
        List<Tarea> listaTareasActivas = tareaService.traerTareasActivas();
        return ResponseEntity.ok(listaTareasActivas);
    }

    @GetMapping("/desactivadas")
    public ResponseEntity<List<Tarea>> traerTareasDesacivadas() {
        List<Tarea> listaTareasDesacivadas = tareaService.traerTareasDesacivadas();
        return ResponseEntity.ok(listaTareasDesacivadas);
    }

    @PutMapping("/cambiarEstado/{id_tarea}")
    public ResponseEntity<String> editarEstadoTarea(@PathVariable Long id_tarea) {
        tareaService.cambiarEstado(id_tarea);
        return ResponseEntity.ok("La Tarea cambio su estado.");
    }

}
