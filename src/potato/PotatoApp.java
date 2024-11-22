package potato;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PotatoApp extends JFrame {
    private PotatoComponent potato;
    private PotatoStateManager stateManager;
    private JLabel totalCostLabel; // Label to display total cost
    
    // Indices for arms, accessories, expressions
    private int armsIndex = 1;  // Default to arm 1
    private int accessoryIndex = 1; // Default to accessory 1
    private int expressionIndex = 1; // Default to expression 1
    private int mouthIndex = 1; // Default to mouth 1
    private int feetIndex = 1;  // Default to feet 1

    // Initializing decorator tracking variables
    private ExpressionsDecorator expressionsDecorator = null;
    private AccessoryDecorator accessoryDecorator = null;
    private ArmsDecorator armsDecorator = null;
    private MouthDecorator mouthDecorator = null;
    private FeetDecorator feetDecorator = null;

    public PotatoApp() {
        potato = new PlainPotato(); // Base body
        stateManager = new PotatoStateManager(potato);  // State manager
        stateManager.saveState(potato); // Save initial state

        // Interface setup
        setLayout(new BorderLayout()); // Use BorderLayout for the main window

        // Panel for buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 4, 10, 10)); // 2 rows, 4 columns

        // Button to change expression (eyes)
        JButton changeExpressionButton = new JButton("Change Expression");
        changeExpressionButton.addActionListener(e -> {
            if (expressionsDecorator != null) {
                potato = potato.removeDecorator(expressionsDecorator);
                expressionsDecorator = null;
            }
            expressionIndex = (expressionIndex % 3) + 1;
            expressionsDecorator = new ExpressionsDecorator(potato, expressionIndex);
            potato = expressionsDecorator;
            stateManager.saveState(potato);
            repaint();
        });

        // Button to change accessory
        JButton changeAccessoryButton = new JButton("Change Accessory");
        changeAccessoryButton.addActionListener(e -> {
            if (accessoryDecorator != null) {
                potato = potato.removeDecorator(accessoryDecorator);
                accessoryDecorator = null;
            }
            accessoryIndex = (accessoryIndex % 3) + 1;
            accessoryDecorator = new AccessoryDecorator(potato, accessoryIndex);
            potato = accessoryDecorator;
            stateManager.saveState(potato);
            repaint();
        });

        // Button to change arms
        JButton changeArmsButton = new JButton("Change Arms");
        changeArmsButton.addActionListener(e -> {
            if (armsDecorator != null) {
                potato = potato.removeDecorator(armsDecorator);
                armsDecorator = null;
            }
            armsIndex = (armsIndex % 3) + 1;
            armsDecorator = new ArmsDecorator(potato, armsIndex);
            potato = armsDecorator;
            stateManager.saveState(potato);
            repaint();
        });

        // Button to change mouth
        JButton changeMouthButton = new JButton("Change Mouth");
        changeMouthButton.addActionListener(e -> {
            if (mouthDecorator != null) {
                potato = potato.removeDecorator(mouthDecorator);
                mouthDecorator = null;
            }
            mouthIndex = (mouthIndex % 3) + 1;
            mouthDecorator = new MouthDecorator(potato, mouthIndex);
            potato = mouthDecorator;
            stateManager.saveState(potato);
            repaint();
        });

        // Button to change feet
        JButton changeFeetButton = new JButton("Change Feet");
        changeFeetButton.addActionListener(e -> {
            if (feetDecorator != null) {
                potato = potato.removeDecorator(feetDecorator);
                feetDecorator = null;
            }
            feetIndex = (feetIndex % 3) + 1;
            feetDecorator = new FeetDecorator(potato, feetIndex);
            potato = feetDecorator;
            stateManager.saveState(potato);
            repaint();
        });

        // Button "Previous" with image
        ImageIcon previousIcon = new ImageIcon(potato.imageBasePath + "previous.png");
        JButton previousButton = new JButton(previousIcon);
        previousButton.addActionListener(e -> {
            potato = stateManager.previousState();
            repaint();
        });

        // Button "Next" with image
        ImageIcon nextIcon = new ImageIcon(potato.imageBasePath + "next.png");
        JButton nextButton = new JButton(nextIcon);
        nextButton.addActionListener(e -> {
            potato = stateManager.nextState();
            if (potato != null) {
                repaint();
            }
        });

        // Add buttons to the panel
        buttonsPanel.add(changeExpressionButton);
        buttonsPanel.add(changeAccessoryButton);
        buttonsPanel.add(changeArmsButton);
        buttonsPanel.add(changeMouthButton);
        buttonsPanel.add(changeFeetButton);
        buttonsPanel.add(previousButton);
        buttonsPanel.add(nextButton);

        // Add button panel to the bottom of the window
        add(buttonsPanel, BorderLayout.SOUTH);

        setSize(600, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateTotalCost() {
        int totalCost = 0;
        PotatoComponent current = potato;

        // Traverse through all decorators and sum their costs
        while (current instanceof PotatoDecorator) {
            PotatoDecorator decorator = (PotatoDecorator) current;
            totalCost += decorator.getCost();
            current = decorator.getWrapped();
        }

        totalCostLabel.setText("Total Cost: $" + totalCost);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        potato.draw(g); // Draw the potato at the center
        // Set font size and style for cost display
        g.setFont(new Font("Arial", Font.BOLD, 24)); // Change "24" to adjust size
        g.drawString("Total Cost: $" + potato.getCost(), 200, 50); // Adjust position
    }

    public static void main(String[] args) {
        new PotatoApp().setVisible(true);
    }
}
