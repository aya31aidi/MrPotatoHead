package potato;

import java.awt.Graphics;

public abstract class PotatoDecorator extends PotatoComponent {
    protected PotatoComponent potato;

    // Constructor that initializes the decorator with a specific potato component
    public PotatoDecorator(PotatoComponent potato) {
        this.potato = potato;
    }

    @Override
    public String getDescription() {
        return potato.getDescription();  // Get the description of the decorated potato
    }

    @Override
    public double getCost() {
        return potato.getCost();  // Get the cost of the decorated potato
    }

    // Abstract method to be implemented by decorators for drawing each part on the body
    public abstract void draw(Graphics g);

    // Method to get the original (wrapped) potato object
    public PotatoComponent getWrapped() {
        return potato;
    }
}
