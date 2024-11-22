package potato;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ArmsDecorator extends PotatoDecorator {
    private int armIndex;

    public ArmsDecorator(PotatoComponent potato, int i) {
        super(potato);
        this.armIndex = i;  // Image of the arms
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Draw the base potato
        ImageIcon arms = new ImageIcon(imageBasePath + "arms" + armIndex + ".png");
        g.drawImage(arms.getImage(), 100, 300, null); // Position the arms
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + " with arms";
    }

    @Override
    public double getCost() {
        return potato.getCost() + 3.00;  // Cost of the arms
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Remove the arms and return the base object
        }
        return super.removeDecorator(decorator); // Recursive call to the parent method
    }
}
