package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import java.util.List;

/**
 *
 * @author Missaoui
 */
public interface ProductManagement {

    public void addItem(Item item);

    public List<Item> getAllItems();

    public Item getItem(String reference);

    public void addExemplaire(Exemplaire exemplaire);

    public List<Exemplaire> getAllExemplaires();
}
