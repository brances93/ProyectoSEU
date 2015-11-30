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
import org.utb.project.dao.ProfesorDao;
import org.utb.project.entities.Profesor;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class ProfesorController{

   @Autowired

    ProfesorDao profesorDao;
    
    @RequestMapping(value = "/profesores/listado", method = RequestMethod.GET)
    public String listado(){
        return "profesores/listado";
    }
    
    @RequestMapping(path = "/api/profesores", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Profesor profesor) {
        profesorDao.agregar(profesor);
    }
    
    @RequestMapping(path = "/api/profesores/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Profesor profesor) {
        profesor.setId(id);
        profesorDao.editar(profesor);
    }
    
    @RequestMapping(path = "/api/profesores/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        profesorDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/profesores", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Profesor> listar() {
        return profesorDao.listar();
    }
    
    @RequestMapping(path = "/api/profesores/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Profesor obtener(@PathVariable("id") Long id) {
        return profesorDao.obtener(id);
    }

    public ProfesorDao getProfesorDao() {
        return profesorDao;
    }

    public void setProfesorDao(ProfesorDao profesorDao) {
        this.profesorDao = profesorDao;
    }
}
