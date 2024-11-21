package potato;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ArmsDecorator extends PotatoDecorator {
    private int armIndex;

    public ArmsDecorator(PotatoComponent potato, int i) {
        super(potato);
        this.armIndex = i;  // Image des bras
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Dessiner la pomme de terre de base
        ImageIcon arms = new ImageIcon(imageBasePath + "arms" + armIndex + ".png");
        g.drawImage(arms.getImage(), 100, 300, null); // Positionner les bras
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + " with arms";
    }

    @Override
    public double getCost() {
        return potato.getCost() + 3.00;  // Coût des bras
    }
    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retirer les bras et retourner l'objet de base
        }
        return super.removeDecorator(decorator); // Appel récursif à la méthode parent
    }
}
