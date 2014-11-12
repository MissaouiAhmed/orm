package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Emprunt;
import java.util.List;

public interface EmpruntManagement {

    public void addEmprunt(Emprunt emprunt);

    public List<Emprunt> getAllEmprunt();

    public Emprunt getEmprunt(String reference);

    public void updateEmprunt(Emprunt emprunt);

    public void deleteEmprunt(Emprunt emprunt);

}
