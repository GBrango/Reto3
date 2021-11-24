/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.modelo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author gabriel
 */
/*@Data /**Condensamos la creacion de los constructores, Getter y Setter para evitar codigo*/
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
   @JoinColumn(name="Libr_id")
   @JsonIgnoreProperties({"reservations"})
   private Lib lib;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id; 
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Lib getLib() {
        return lib;
    }

    public void setLib(Lib lib) {
        this.lib = lib;
    }
   
   
    
}
