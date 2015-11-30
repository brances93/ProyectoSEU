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
import org.utb.project.dao.ListaEstuDao;
import org.utb.project.dao.AlumnoDao;
import org.utb.project.entities.ListaEstu;
import org.utb.project.entities.Alumno;

/**
 *
 * @author JAIR Y BRANCES
 */
public class ListaEstuController {
    @Autowired
    ListaEstuDao listaestuDao;
    @Autowired
    AlumnoDao alumnoDao;
    
    @RequestMapping(value = "/listaEstu/listado", method = RequestMethod.GET)
    public String listado(){
        return "listaEstu/listado";
    }
    
    @RequestMapping(path = "/api/listaEstu", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute ListaEstu alumno, @ModelAttribute("alumno_id") Long alumnoId) {
        Alumno alum = alumnoDao.obtener(alumnoId);
        alumno.setAlumno(alum);
        listaestuDao.agregar(alumno);
    }
    
    @RequestMapping(path = "/api/listaEstu/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute ListaEstu alumno, @ModelAttribute("alumno_id") Long profesorId) {
        Alumno alum = alumnoDao.obtener(profesorId);
        alumno.setAlumno(alum);
        alumno.setId(id);
        listaestuDao.editar(alumno);
    }
    
    @RequestMapping(path = "/api/listaEstu/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        listaestuDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/listEstu", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ListaEstu> listar() {
        return listaestuDao.listar();
    }
    
    @RequestMapping(path = "/api/listaEstu/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ListaEstu obtener(@PathVariable("id") Long id) {
        return listaestuDao.obtener(id);
    }
}
