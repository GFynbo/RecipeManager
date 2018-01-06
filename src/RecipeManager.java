import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class RecipeManager {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
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

        // run the frame for the actual app
        JFrame frame = new JFrame("RecipeManager");
        frame.setContentPane(new RecipeManager().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        System.out.println(meatballs);

    }

    public void setData(Recipe data) {
        
    }

    public void getData(Recipe data) {
    }

    public boolean isModified(Recipe data) {
        return false;
    }
}
