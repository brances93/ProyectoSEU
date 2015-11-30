/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.utb.project.dao.ListaMateriaDao;
import org.utb.project.dao.ProfesorDao;
import org.utb.project.dao.AlumnoDao;
import org.utb.project.entities.ListaMateria;
import org.utb.project.entities.Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class ListaMateriaController {
    @Autowired
    ListaMateriaDao listamateriaDao;
    @Autowired
    ProfesorDao profesorDao;
    @Autowired
    AlumnoDao alumnoDao;
    
    @RequestMapping(value = "/listaMateria/listado", method = RequestMethod.GET)
    public String listado(){
        return "listaMateria/listado";
    }
    
    @RequestMapping(path = "/api/listaMateria", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute ListaMateria materia, @ModelAttribute("profesor_id") Long profesorId) {
        Profesor profesor = profesorDao.obtener(profesorId);
        materia.setProfesor(profesor);
        listamateriaDao.agregar(materia);
    }
    
    @RequestMapping(path = "/api/listaMateria/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute ListaMateria materia, @ModelAttribute("profesor_id") Long profesorId) {
        Profesor profesor = profesorDao.obtener(profesorId);
        materia.setProfesor(profesor);
        materia.setId(id);
        listamateriaDao.editar(materia);
    }
    
    @RequestMapping(path = "/api/listaMateria/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        listamateriaDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/listaMateria", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ListaMateria> listar() {
        return listamateriaDao.listar();
    }
    
    @RequestMapping(path = "/api/listaMateria/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ListaMateria obtener(@PathVariable("id") Long id) {
        return listamateriaDao.obtener(id);
    }
}
