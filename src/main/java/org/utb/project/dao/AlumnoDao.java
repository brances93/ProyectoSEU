/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.utb.project.entities.Alumno;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class AlumnoDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Alumno alum) {
        entityManager.persist(alum);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Alumno alum) {
        entityManager.merge(alum);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       Alumno alum = entityManager.find(Alumno.class, id);
        entityManager.remove(alum);
        entityManager.flush();
    }
    
    @Transactional
    public Alumno obtener(Long id) {
        Alumno alum = entityManager.find(Alumno.class, id);
        return alum;
    }

    @Transactional
    public List<Alumno> listar() {
        List<Alumno> almus = entityManager.createQuery("SELECT a FROM Alumnos a").getResultList();
        return almus;
    }
}

