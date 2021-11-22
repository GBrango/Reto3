/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
@Entity
@Table(name ="Lib")
public class Lib implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;
    @Column(length = 60)
    private String target;
    @Column(length = 100)
    private Integer capacity;
    @Column(length = 60)
    private String name;
    @Column(length = 100)
    private String description;
    /**LLaves foraneas*/
    
    /*@OneToOne
    @JoinColumn(name="id_category")
    private Category categoria;*/
    
        
   /** @ManyToOne
    @JoinColumn(name="message_id")
    private Message Message;*/
    
   /* @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation Reservation;*/
    /**
     creamos la lista de reservaciones de acuerdo con los objetos creados a partir de las FK para evitar redundancia de datos
     */
  
    /**cuando se borre este indica el deshacer*/
    @OneToMany(mappedBy = "library", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"library"})
    private List<Message> messages;
    
    @OneToMany(mappedBy = "libs", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"libs"})
    private List<Category> category;
      
    @OneToMany(mappedBy = "library", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"library"})
    private List<Reservation> reservations;
    
}
