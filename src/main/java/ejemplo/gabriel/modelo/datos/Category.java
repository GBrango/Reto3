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
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
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
    
    @OneToOne
    @JoinColumn(name="lib_id")
    private Lib libs;
    
    /**@OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"categoria"})
    private List<Lib> libs;*/
    
    
}
