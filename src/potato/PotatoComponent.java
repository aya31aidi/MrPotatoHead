package potato;

import java.awt.Graphics;

public abstract class PotatoComponent {
    protected PotatoComponent potato;
    protected String imageBasePath = "data/images/";

    // Method to get description of the potato component
    public abstract String getDescription();

    // Method to get the cost of the potato component
    public abstract double getCost();

    // Method to draw the potato component
    public abstract void draw(Graphics g);

    // Method to remove a specific decorator
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Return the object without the current decorator
        } else if (potato != null) {
            potato = potato.removeDecorator(decorator);  // Recursive call
        }
        return this;  // If the decorator is not found, return the object as is
    }
}
