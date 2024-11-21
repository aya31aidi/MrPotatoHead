package potato;

import java.awt.Graphics;

public abstract class PotatoDecorator extends PotatoComponent {
    protected PotatoComponent potato;

    public PotatoDecorator(PotatoComponent potato) {
        this.potato = potato;
    }

    @Override
    public String getDescription() {
        return potato.getDescription();
    }

    @Override
    public double getCost() {
        return potato.getCost();
    }

    public abstract void draw(Graphics g); // Pour dessiner chaque partie sur le corps
}
