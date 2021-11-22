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
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
@Entity
@Table(name ="Client")
public class Client implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;
    @Column(length = 60)
    private String name;
    @Column(length = 60, unique = true)
    private String email;
    @Column(length = 12)
    private String password;
    @Column(length = 3)
    private Integer age;
    
    
    /**FK*/
    /*@ManyToOne*/
    /**@JoinColumn(name="message_id")*/
   @OneToMany(mappedBy= "client", cascade = CascadeType.PERSIST)
   @JsonIgnoreProperties({"client","library"})
   private List<Message> messages; 
    
    /*private Message messages;*/
    
   /* @ManyToOne*/
   /** @JoinColumn(name="resevation_id")*/
  /* private Reservation reservation;*/
   
     
    /**Evidamos recurrencia de datos*/  
   @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
   @JsonIgnoreProperties({"library", "client"})
   private List<Reservation> reservations;  /**Esta es la lista de reservaciones que me traigo sin recussividad por el JsonIgnore*/ 
   
   
  
}
