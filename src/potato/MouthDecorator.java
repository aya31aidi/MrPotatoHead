package potato;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class MouthDecorator extends PotatoDecorator {
    private int mouthIndex;

    public MouthDecorator(PotatoComponent potato, int index) {
        super(potato);
        this.mouthIndex = index;
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + ", Mouth " + mouthIndex;
    }

    @Override
    public double getCost() {
        return potato.getCost() + 1.00; // Prix de la bouche
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g);
        ImageIcon mouth = new ImageIcon(imageBasePath + "mouth" + mouthIndex + ".png");
        g.drawImage(mouth.getImage(), 100, 270, null); // Ajuster la position selon le design
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retirer la bouche et retourner l'objet de base
        }
        return super.removeDecorator(decorator); // Appel récursif
    }
}
