package potato;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ExpressionsDecorator extends PotatoDecorator {
    private int expressionsIndex;

    public ExpressionsDecorator(PotatoComponent potato, int index) {
        super(potato);
        this.expressionsIndex = index;
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + ", Expressions " + expressionsIndex;
    }

    @Override
    public double getCost() {
        return potato.getCost() + 1.00; // Cost of expressions
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Draw the base potato
        ImageIcon expressions = new ImageIcon(imageBasePath + "expression" + expressionsIndex + ".png");
        g.drawImage(expressions.getImage(), 100, 175, null); // Adjust the position for the eyes
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Remove the expression and return the base object
        }
        return super.removeDecorator(decorator); // Recursive call to the parent method
    }
}
