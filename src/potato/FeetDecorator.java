package potato;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class FeetDecorator extends PotatoDecorator {
    private int feetIndex;

    public FeetDecorator(PotatoComponent potato, int index) {
        super(potato);
        this.feetIndex = index;
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + ", Feet " + feetIndex;
    }

    @Override
    public double getCost() {
        return potato.getCost() + 1.50; // Prix des pieds
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g);
        ImageIcon feet = new ImageIcon(imageBasePath + "feet" + feetIndex + ".png");
        g.drawImage(feet.getImage(), 100, 400, null); // Ajuster la position selon le design
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retirer les pieds et retourner l'objet de base
        }
        return super.removeDecorator(decorator); // Appel récursif
    }
}
