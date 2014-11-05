/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Molka
 */

@Embeddable
public class LigneCommandeId implements Serializable{
    private Item commandeitem;
    private BonDeCommande Commandebondecommde;

    @ManyToOne
    public Item getCommandeitem() {
        return commandeitem;
    }

    public void setCommandeitem(Item commandeitem) {
        this.commandeitem = commandeitem;
    }

    @ManyToOne
    public BonDeCommande getCommandebondecommde() {
        return Commandebondecommde;
    }

    public void setCommandebondecommde(BonDeCommande Commandebondecommde) {
        this.Commandebondecommde = Commandebondecommde;
    }
    
    
}
