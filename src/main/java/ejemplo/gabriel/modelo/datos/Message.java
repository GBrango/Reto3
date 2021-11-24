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
/**@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
@Entity
@Table(name ="Message")
public class Message implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;
    @Column(length = 100)
    private String messageText;
    /** POner FK de client_id*/
    
   @ManyToOne
   @JoinColumn(name="Cliente_id")
   @JsonIgnoreProperties({"message"}) 
   private Client client;
   
   @ManyToOne
   @JoinColumn(name="Lib_id")
   @JsonIgnoreProperties({"message"})
   private Lib lib;   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Lib getLib() {
        return lib;
    }

    public void setLib(Lib lib) {
        this.lib = lib;
    }

   /**getter a setter*/

   
   
}
