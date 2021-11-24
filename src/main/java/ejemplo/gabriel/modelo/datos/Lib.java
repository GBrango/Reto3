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

/**
 *
 * @author gabriel
 */
 /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
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
   
   @ManyToOne
   @JoinColumn(name="Category_id")
   @JsonIgnoreProperties({"libs"})
   private Category category;
   
   @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="lib")
   @JsonIgnoreProperties({"lib"})
   public List<Message> message;

   @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="lib")
   @JsonIgnoreProperties({"lib"})
   public List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
   
   
   
}
