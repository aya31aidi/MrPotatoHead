package potato;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PlainPotato extends PotatoComponent {
    @Override
    public String getDescription() {
        return "Plain Potato Body";
    }

    @Override
    public double getCost() {
        return 5.00; // Prix de base
    }

    @Override
    public void draw(Graphics g) {
        // Afficher l'image du corps
        ImageIcon body = new ImageIcon(imageBasePath + "body.png");
        g.drawImage(body.getImage(), 100, 100, null);
    }
}
