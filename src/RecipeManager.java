import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class RecipeManager {
    private JFrame frame = new JFrame("RecipeManager");

    private JPanel mainPanel;
    private JTabbedPane mainTabbedPane;
    private JPanel existingRecipePane;
    private JPanel newRecipePane;
    private JList existingRecipeList;
    private JTextField newRecipeName;
    private JTextField newRecipeCookTime;
    private JTextArea newRecipeDirections;
    private JTextArea newRecipeIngredients;
    private JButton createNewButton;
    private JButton createButton;
    private JEditorPane existingRecipeDisplay;

    public RecipeManager() {

        frame.setContentPane(new RecipeManager().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        existingRecipeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selected a new recipe!");
            }
        });
    }

    public static void main(String[] args) {

        // create initial test recipe
        System.out.println("Hello! Welcome to the RecipeManager.");
        Directions dirs = new Directions(3);
        CookTime time = new CookTime(15);
        Review rv = new Review(4);
        Ingredient ing = new Ingredient("Salt", "2 tbsp");
        String recipeName = "Meatballs";

        Recipe meatballs = new Recipe(recipeName, ing, dirs, time, rv);

        DefaultListModel recipes = new DefaultListModel();

        recipes.addElement(meatballs);

        // run the frame for the actual app
        SwingUtilities.invokeLater(RecipeManager::new);

        System.out.println(meatballs);

    }
}
