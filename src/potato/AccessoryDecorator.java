package potato;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class AccessoryDecorator extends PotatoDecorator {
    private int accessoryIndex;

    public AccessoryDecorator(PotatoComponent potato, int index) {
        super(potato);
        this.accessoryIndex = index;
    }

    @Override
    public String getDescription() {
        return potato.getDescription() + ", Accessory " + accessoryIndex;
    }

    @Override
    public double getCost() {
        return potato.getCost() + 1.50; // Price of each accessory
    }

    @Override
    public void draw(Graphics g) {
        potato.draw(g); // Draw previous elements
        // Add the image of the accessory
        ImageIcon accessory = new ImageIcon(imageBasePath + "accesory" + accessoryIndex + ".png");
        g.drawImage(accessory.getImage(), 100, 100, null); // Adjust coordinates
    }

    @Override
    public PotatoComponent removeDecorator(PotatoComponent decorator) {
        if (this == decorator) {
            return potato;  // Remove the accessory and return the base object
        }
        return super.removeDecorator(decorator); // Recursive call to the parent method
    }
}
