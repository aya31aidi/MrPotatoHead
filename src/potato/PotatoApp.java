package potato;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PotatoApp extends JFrame {
    private PotatoComponent potato;
    private PotatoStateManager stateManager;

    // Indices pour les bras, accessoires, expressions
    private int armsIndex = 1;  // Par défaut, on commence avec le bras 1
    private int accessoryIndex = 1; // Par défaut, on commence avec l'accessoire 1
    private int expressionIndex = 1; // Par défaut, on commence avec l'expression 1
    private int mouthIndex = 1; // Default to mouth 1
    private int feetIndex = 1;  // Default to feet 1

 // Initializing decorator tracking variables
    private ExpressionsDecorator expressionsDecorator = null;
    private AccessoryDecorator accessoryDecorator = null;
    private ArmsDecorator armsDecorator = null;
    private MouthDecorator mouthDecorator = null;
    private FeetDecorator feetDecorator = null;


    public PotatoApp() {
        potato = new PlainPotato(); // Corps de base
        stateManager = new PotatoStateManager(potato);  // Gestionnaire d'état
        stateManager.saveState(potato); // Sauvegarder l'état initial

        // Interface
        setLayout(new BorderLayout()); // Utiliser BorderLayout pour la fenêtre principale

        // Panneau pour les boutons
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 4, 10, 10)); // 2 lignes, 4 colonnes

        // Bouton pour changer les yeux (expression)
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

        // Bouton pour changer d'accessoire
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

        // Bouton pour changer les bras
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

        // Bouton pour changer la bouche
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

        // Bouton pour changer les pieds
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

        // Bouton "Previous" avec image
        ImageIcon previousIcon = new ImageIcon(potato.imageBasePath + "previous.png");
        JButton previousButton = new JButton(previousIcon);
        previousButton.addActionListener(e -> {
            potato = stateManager.previousState();
            repaint();
        });

        // Bouton "Next" avec image
        ImageIcon nextIcon = new ImageIcon(potato.imageBasePath + "next.png");
        JButton nextButton = new JButton(nextIcon);
        nextButton.addActionListener(e -> {
            potato = stateManager.nextState();
            if (potato != null) {
                repaint();
            }
        });

        // Ajouter les boutons au panneau
        buttonsPanel.add(changeExpressionButton);
        buttonsPanel.add(changeAccessoryButton);
        buttonsPanel.add(changeArmsButton);
        buttonsPanel.add(changeMouthButton);
        buttonsPanel.add(changeFeetButton);
        buttonsPanel.add(previousButton);
        buttonsPanel.add(nextButton);

        // Ajouter le panneau des boutons au bas de la fenêtre
        add(buttonsPanel, BorderLayout.SOUTH);

        setSize(800, 600); // Ajuster la taille de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        potato.draw(g); // Dessiner la pomme de terre au centre
    }

    public static void main(String[] args) {
        new PotatoApp().setVisible(true);
    }

}
