package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Exemplaire;
import fr.polytech.orm.entities.Item;
import java.util.List;

public interface ProductManagement {

    public void addItem(Item item);

    public List<Item> getAllItems();

    public Item getItem(String reference);
    
    public List<Item> getItemsbyAuteur(String auteur);
    
    public List<Item> getItemsbyTitre(String titre);
    
    public List<Item> getItemsbyTitreAndAuteur (String titre, String auteur);

    public void addExemplaire(Exemplaire exemplaire);

    public Exemplaire getExemplaire(String reference);

    public List<Exemplaire> getAllExemplaires();

    public void deleteItem(Item item);

    public Exemplaire getDispExemplaire(List<Exemplaire> Exemplaires);

    public void deleteExemplaire(Exemplaire exemplaire);
    public void updateExemplaire(Exemplaire exemplaire);

}
