package potato;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class AccessoryDecorator extends PotatoDecorator {
    private int accessoryIndex;

    public AccessoryDecorator(PotatoComponent potato, int index) {
        super(potato);
        this.accessoryIndex = index;
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + ", Accessory " + accessoryIndex;
    }

    @Override
    public double getCost() {
        return potato.getCost() + 1.50; // Prix de chaque accessoire
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Dessiner les éléments précédents
        // Ajouter l'image de l'accessoire
        ImageIcon accessory = new ImageIcon(imageBasePath + "accesory" + accessoryIndex + ".png");
        g.drawImage(accessory.getImage(), 100, 100, null); // Modifier les coordonnées
    }
    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retirer l'accessoire et retourner l'objet de base
        }
        return super.removeDecorator(decorator); // Appel récursif à la méthode parent
    }
}
