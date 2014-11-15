package fr.polytech.orm.buisness;

import fr.polytech.orm.entities.Souhait;
import java.util.List;

public interface SouhaitManagement {

    public List<Souhait> getAllSouhaits();
    
    public void addSouhait(Souhait souhait);
    
    public void updateSouhait(Souhait souhait);
    
    public void deleteSouhait(Souhait souhait);
}
