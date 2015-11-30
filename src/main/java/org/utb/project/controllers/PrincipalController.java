/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author JAIR Y BRANCES
 */
@Controller
public class PrincipalController {
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        Object autenticado = request.getSession().getAttribute("autenticado");
        if(autenticado != null && (boolean)autenticado) {
            return "index";
        } else {
            return "redirect:/index";
        }
    }
}
