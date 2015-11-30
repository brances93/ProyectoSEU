/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.utb.project.dao.AlumnoDao;
import org.utb.project.entities.Alumno;

/**
 *
 * @author JAIR Y BRANCES
 */
public class AlumnoController {
    
     @Autowired

    AlumnoDao alumDao;
    
    @RequestMapping(value = "/alumnos/listado", method = RequestMethod.GET)
    public String listado(){
        return "alumnos/listado";
    }
    
    @RequestMapping(path = "/api/alumnos", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Alumno alumn) {
        alumDao.agregar(alumn);
    }
    
    @RequestMapping(path = "/api/alumnos/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Alumno alumn) {
        alumn.setId(id);
        alumDao.editar(alumn);
    }
    
    @RequestMapping(path = "/api/alumnos/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        alumDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/alumnos", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Alumno> listar() {
        return alumDao.listar();
    }
    
    @RequestMapping(path = "/api/alumnos/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Alumno obtener(@PathVariable("id") Long id) {
        return alumDao.obtener(id);
    }

    public AlumnoDao getProfesorDao() {
        return alumDao;
    }

    public void setProfesorDao(AlumnoDao alumnDao) {
        this.alumDao = alumnDao;
    }
}
