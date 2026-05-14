package com.example.demo_springboot_apirest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name= "Domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Domicilio extends Base{
    @Column(name= "calle")
    private String calle;
    @Column(name= "numero")
    private int numero;

    // Relacion con localidad
    // Con optional=false indicamos que no puede ser nulo localidad
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name= "fk_localidad")
    private Localidad localidad;
}
