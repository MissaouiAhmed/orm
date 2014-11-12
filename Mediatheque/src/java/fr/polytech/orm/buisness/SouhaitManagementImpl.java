/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Souhait;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tounsi
 */

@Stateful
public class SouhaitManagementImpl implements SouhaitManagement{
 @PersistenceContext
    private EntityManager em;
 
    public List<Souhait> getAllSouhaits() {
         return em.createQuery("select a from Souhait a").getResultList();
    }
    
}
