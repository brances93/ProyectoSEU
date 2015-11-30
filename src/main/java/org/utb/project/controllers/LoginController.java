/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.utb.project.dao.UsuarioDao;
import org.utb.project.entities.Usuario;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class LoginController {
    @Autowired
    UsuarioDao usuarioDao;
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@ModelAttribute("error") String error, ModelMap model) {
        return "login";
    }
    
    @RequestMapping(value = "usuarios/login", method = RequestMethod.POST)
    public String autenticar(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap model, HttpServletRequest request) {
        //model.clear();
        Usuario usuario = usuarioDao.buscarPorEmail(email);
        if(usuario != null && password.equals(usuario.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("autenticado", true);
            session.setAttribute("usuarioId", usuario.getId());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Email o Password incorrecto");
            return "redirect:/login";
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String salir(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("autenticado");
        session.removeAttribute("usuarioId");
        session.invalidate();
        return "redirect:/login";
    }
}
