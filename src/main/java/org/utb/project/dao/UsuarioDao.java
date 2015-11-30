/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.utb.project.entities.Usuario;

/**
 *
 * @author JAIR Y BRANCES
 */
@Component
public class UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Usuario usuario) {
        entityManager.persist(usuario);
        entityManager.flush();
    }

    @Transactional
    public List<Usuario> listar() {
        List<Usuario> usuarios = entityManager.createQuery("SELECT u FROM Usuario u").getResultList();
        return usuarios;
    }

    @Transactional
    public Usuario buscarPorEmail(String email) {
        try {
            Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email).getSingleResult();
            return usuario;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
