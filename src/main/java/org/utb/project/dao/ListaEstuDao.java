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
import org.utb.project.entities.ListaEstu;

/**
 *
 * @author JAIR Y BRANCES
 */

public class ListaEstuDao {
     @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(ListaEstu alumno) {
        entityManager.persist(alumno);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(ListaEstu alumno) {
        entityManager.merge(alumno);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       ListaEstu alumno = entityManager.find(ListaEstu.class, id);
        entityManager.remove(alumno);
        entityManager.flush();
    }
    
    @Transactional
    public ListaEstu obtener(Long id) {
        ListaEstu alumno = entityManager.find(ListaEstu.class, id);
        return alumno;
    }

    @Transactional
    public List<ListaEstu> listar() {
        List<ListaEstu> alumno = entityManager.createQuery("SELECT a FROM Articulo a").getResultList();
        return alumno;
    }
}
