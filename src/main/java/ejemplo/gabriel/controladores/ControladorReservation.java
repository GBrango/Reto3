/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.gabriel.controladores;

import ejemplo.gabriel.modelo.datos.Client;
import ejemplo.gabriel.modelo.datos.Reservation;
import ejemplo.gabriel.modelo.servicios.ClientServicios;
import ejemplo.gabriel.modelo.servicios.ReservationServicios;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/api/Reservation")
public class ControladorReservation {
    
   @Autowired /**Inyectamos la dependencias*/
    ReservationServicios reservationServicios;
    @GetMapping("/all")
    public List<Reservation> buscarTodasLasReservas() {
        return reservationServicios.buscarTodosLasReservas();/**Retornamos todos los usarios invocando el método buscarTodos*/
    }
    
    /**ok*/
    
    
    @GetMapping("/Reservation/{id}")
    public Reservation getPorIdReserva(@PathVariable("id") Integer id) {
        return reservationServicios.buscarPorIdReserva(id);
    }
    
    
    @PostMapping("/save")
    public ResponseEntity<?> guardarReserva(@RequestBody Reservation input) {
        reservationServicios.guardarReservasion(input);/**Este input recibe el cuerpo de los datos que se van a cargar*/
            return ResponseEntity.status(201).build();
    }
    
    
    
    /**Estos metodos son del reto4*/
   @PutMapping("/Reservation/update")
    public ResponseEntity<?> put(@RequestBody Reservation input) {
      reservationServicios.guardarReservasion(input);
       return ResponseEntity.status(201).build();
    }
    
    
    @DeleteMapping("/Reservation/{id}")
    public void delete(@PathVariable("id")Integer id) {
        reservationServicios.borrarReservacion(id);
    }
        
}
