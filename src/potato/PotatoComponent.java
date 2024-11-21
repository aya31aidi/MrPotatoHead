package potato;

import java.awt.Graphics;

public abstract class PotatoComponent {
	protected PotatoComponent potato;
	protected String imageBasePath = "C:/Users/LENOVO/OneDrive - Ministere de l'Enseignement Superieur et de la Recherche Scientifique/Documents/2eme ing/sem1/design pattern/data/images/";
    public abstract String getDescription();
    public abstract double getCost();
    public abstract void draw(Graphics g); 
 // Méthode pour retirer un décorateur spécifique
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retourner l'objet sans le décorateur courant
        } else if (potato != null) {
            potato = potato.removeDecorator(decorator);  // Appel récursif
        }
        return this;  // Si le décorateur n'est pas trouvé, on retourne l'objet tel quel
    }
    
}
