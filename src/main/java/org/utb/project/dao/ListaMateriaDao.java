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
import org.springframework.stereotype.Component;
import org.utb.project.entities.ListaMateria;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class ListaMateriaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(ListaMateria materia) {
        entityManager.persist(materia);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(ListaMateria materia) {
        entityManager.merge(materia);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
       ListaMateria materia = entityManager.find(ListaMateria.class, id);
        entityManager.remove(materia);
        entityManager.flush();
    }
    
    @Transactional
    public ListaMateria obtener(Long id) {
        ListaMateria materia = entityManager.find(ListaMateria.class, id);
        return materia;
    }

    @Transactional
    public List<ListaMateria> listar() {
        List<ListaMateria> materias = entityManager.createQuery("SELECT a FROM Articulo a").getResultList();
        return materias;
    }
}
