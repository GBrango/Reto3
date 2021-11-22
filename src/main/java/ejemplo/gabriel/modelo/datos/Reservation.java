/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.datos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author gabriel
 */
@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
@Entity
@Table(name ="Reservation")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Integer id;
    private Date startDate;
    private Date devolutionDate;
   /**LLaves foraneas*/
    
    @ManyToOne
    @JoinColumn(name = "Lib_id")
    private Lib library;
   
    @OneToOne
    private Category cartegory_id;
    
    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;   /**Nombre del objeto para llamar en el JsonIgnore*/
        
    
}
