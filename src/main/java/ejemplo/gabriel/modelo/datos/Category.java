/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gabriel
 */
 /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
@Entity
@Table(name ="Category")
public class Category implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;
    @Column(length = 100)
    private String name;
    @Column(length = 80)
    private String description;
    /**FK*/
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="category")
    @JsonIgnoreProperties({"reservations"})    
    public List<Lib> libs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lib> getLibs() {
        return libs;
    }

    public void setLibs(List<Lib> libs) {
        this.libs = libs;
    }
    
    
   
    /**Metodos getter and setter*/
    

    
}
