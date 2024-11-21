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
        return potato.getCost() + 1.00; // Prix des expressions
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g);
        ImageIcon expressions = new ImageIcon(imageBasePath + "expression" + expressionsIndex + ".png");
        g.drawImage(expressions.getImage(), 100, 175, null); // Modifier selon la position des yeux
    }
    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Retirer l'expression et retourner l'objet de base
        }
        return super.removeDecorator(decorator); // Appel récursif à la méthode parent
    }
}

