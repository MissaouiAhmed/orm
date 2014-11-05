/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Molka
 */
@Entity
@Table(name="Cassette")
public class Cassette extends Type_Item {

    public Cassette() {
    }
    
}
