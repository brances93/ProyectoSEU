/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.utb.project.dao.UsuarioDao;
import org.utb.project.entities.Usuario;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class UsuariosController {
    @Autowired
    private UsuarioDao usuarioDao;
    
    @RequestMapping(path = "/usuarios/formulario/nuevo", method = RequestMethod.GET)
    public String formularioNuevo() {
        return "usuarios/formulario_nuevo";
    }
    
    @RequestMapping(path = "/usuarios/formulario/nuevo", method = RequestMethod.POST)
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioDao.agregar(usuario);
        return "redirect:/usuarios/listado";
    }
    
    @RequestMapping(path = "/usuarios/listado", method = RequestMethod.GET)
    public String listado(ModelMap model) {
        List<Usuario> usuarios = usuarioDao.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listado";
    }
}
