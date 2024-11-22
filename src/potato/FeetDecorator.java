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
        return potato.getCost() + 1.50; // Cost of feet
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Draw the base potato
        ImageIcon feet = new ImageIcon(imageBasePath + "feet" + feetIndex + ".png");
        g.drawImage(feet.getImage(), 100, 400, null); // Adjust the position according to the design
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Remove the feet and return the base object
        }
        return super.removeDecorator(decorator); // Recursive call
    }
}
