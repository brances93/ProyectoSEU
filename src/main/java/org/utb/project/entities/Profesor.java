/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utb.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author JAIR Y BRANCES
 */
@Entity
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    private String codigo;
    private String nombre;
    private String apellido;
  
    @OneToMany(mappedBy = "profesor")
    @JsonIgnore
    private List<ListaMateria> listamateria = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }

    public List<ListaMateria> getListamateria() {
        return listamateria;
    }

    public void setListamateria(List<ListaMateria> listamateria) {
        this.listamateria = listamateria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<ListaMateria> getListaMateria() {
        return listamateria;
    }

    public void setListaMateria(List<ListaMateria> listamateria) {
        this.listamateria = listamateria;
    }
    
}
