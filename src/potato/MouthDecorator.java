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
        return potato.getCost() + 1.00; // Cost of the mouth
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Draw the base potato
        ImageIcon mouth = new ImageIcon(imageBasePath + "mouth" + mouthIndex + ".png");
        g.drawImage(mouth.getImage(), 100, 270, null); // Adjust the position according to the design
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Remove the mouth and return the base object
        }
        return super.removeDecorator(decorator); // Recursive call
    }
}
