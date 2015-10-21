

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class tictactoe extends JFrame implements ActionListener {

    /**
     * declaratie van globale variabelen en button array
     */
    private static JButton[][] button;  //declaratie van de array in array (geneste list in Python)
    private static final int XAS = 3, YAS = 3;  // Grootte van de array
    private JPanel panel, panelInfo, panelHeader; // Panels
    private static final String TITEL = "Tic Tac Toe 4 BioInformatics";  //Titel
    private static String imagePath, seperator = "/"; // Seperator forward slash zowel voor Unix als Windows geschikt
    private static ImageIcon leeg, kruisje, rondje, vraagteken;  //images
    private static JLabel messageLabel, headerLabel;  //labels met informatieve teksten
    private static int turn = 1;

    /**
     * Applicatie: main method, instantiering van frame (deze class) en
     * initialisering van GUI
     */
    public static void main(String[] args) {
        tictactoe frame = new tictactoe();
        setImages();
        frame.setTitle(TITEL);
        frame.setSize(350, 350);
        frame.createGUI();
        frame.setVisible(true);
        // Zet icon voor programma
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/richard/IdeaProjects/Java-afvink4/afvink4/output/production/Java-afvink4/icon.jpg"));

    }

    /**
     * Zoeken en laden van images Pas hier je pad aan naar de images als de
     * images niet worden gevonden of als je andere images wilt gebruiken.
     */
    private static void setImages() {
        leeg = new ImageIcon("/home/richard/IdeaProjects/Java-afvink4/afvink4/output/production/Java-afvink4/leeg.jpg");
        kruisje = new ImageIcon("/home/richard/IdeaProjects/Java-afvink4/afvink4/output/production/Java-afvink4/kruisje.jpg");
        rondje = new ImageIcon("/home/richard/IdeaProjects/Java-afvink4/afvink4/output/production/Java-afvink4/rondje.jpg");
        vraagteken = new ImageIcon("/home/richard/IdeaProjects/Java-afvink4/afvink4/output/production/Java-afvink4/question.jpg");

    }

    /**
     * Geef een bericht over de status van het spel Merk op dat deze methode
     * overloaded is
     *
     * @param message String die een bericht weergeeft in de status console
     * @param tooltip Mouse over bericht
     */
    private static void message(String message, String tooltip) {
        messageLabel.setText(message);
        messageLabel.setToolTipText(tooltip);
    }

    private static void message(String message) {
        message(message, message);
    }

    /**
     * Creatie van de Graphical User Interface
     */
    private void createGUI() {
        button = new JButton[XAS][YAS]; // Declareer de button array
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Zorg dat het window gesloten wordt
        Container window = getContentPane(); // Creatie van een Window waarin twee JPanels worden geplaatst
        window.setLayout(new FlowLayout()); // Zet flowLayout in het Window

        panel = new JPanel();
        panel.setLayout(new GridLayout(XAS, YAS, 5, 5));// GridLayout om in een matrix van 3 bij 3 de velden te plaatsen
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.BLACK);
        panelInfo = new JPanel();
        panelInfo.setMaximumSize(new Dimension(200, 100));
        panelInfo.setLayout(new FlowLayout());
        panelInfo.setBackground(Color.GRAY);
        panelHeader = new JPanel();
        panelHeader.setMaximumSize(new Dimension(250, 20));
        panelHeader.setPreferredSize(new Dimension(250, 20));
        panelHeader.setLayout(new FlowLayout());
        panelHeader.setBackground(Color.lightGray);
        messageLabel = new JLabel("");
        headerLabel = new JLabel("Bioinformatica Tic Tac Toe");
        panelInfo.add(messageLabel);
        panelHeader.add(headerLabel);

        // Voeg aan het window de twee panels toe
        window.add(panelHeader);
        window.add(panel);
        window.add(panelInfo);

        //Geneste for-loop om de buttons te vullen en te tekenen
        for (int x = 0; x < XAS; x++) {
            for (int y = 0; y < YAS; y++) {
                button[x][y] = new JButton();
                button[x][y].addActionListener(this);
                button[x][y].setIcon(leeg);
                button[x][y].setRolloverIcon(vraagteken);
                panel.add(button[x][y]);
            }
        }
        message("Rondje mag beginnen");
    }

    /*
     * Actie indien de button geklikt is Hier vindt de afhandeling van het
     * klikken van een button plaats. Er zijn 9 buttons die op basis van de
     * source onderscheiden kunnen worden. Zorg dat indien een button wordt
     * geklikt deze een rondje of kruisje krijgt afhankelijk van wie er aan zet
     * is. Controleer na het plaatsten van het rondje of kruisje of iemand 3 op
     * een rij heeft of wanneer het laatste vakje is ingevuld of er iemand
     * gewonnen heeft.
     */
    public void actionPerformed(ActionEvent event) {

        Object buttonPressed = event.getSource();
        JButton b = (JButton) buttonPressed;
        if ((turn % 2) == 0)
            b.setIcon(kruisje);
        else
            b.setIcon(rondje);
        b.setEnabled(false);


        /*
         * Als voorbeeld is hier opgenomen de boolean expressie
         * om te achterhalen of het vakje linksboven is aangeklikt
         * Bouw hieromheen een loop (of geneste loop?) met daarin
         * een if structuur om een kruisje danwel een rondje op de
         * button te plaatsen
         */
        //System.out.println(buttonPressed == button[0][0]);
        turn++;
        if (turn == 10) {
            JOptionPane.showMessageDialog(panel, "Balen, beiden waren jullie matig");
        }
        check();
        if ((turn % 2) == 0)
            message("Kruisje is aan de beurt");
        else
            message("Rondje is aan de beurt");
    }

    public void check() {
        if (button[0][0].getIcon() == button[0][1].getIcon() && button[0][1].getIcon() == button[0][2].getIcon() && button[0][0].getIcon() != leeg ||
                button[1][0].getIcon() == button[1][1].getIcon() && button[1][1].getIcon() == button[1][2].getIcon() && button[1][0].getIcon() != leeg ||
                button[2][0].getIcon() == button[2][1].getIcon() && button[2][1].getIcon() == button[2][2].getIcon() && button[2][0].getIcon() != leeg ||
                button[0][0].getIcon() == button[1][0].getIcon() && button[1][0].getIcon() == button[2][0].getIcon() && button[0][0].getIcon() != leeg ||
                button[0][1].getIcon() == button[1][1].getIcon() && button[1][1].getIcon() == button[2][1].getIcon() && button[0][1].getIcon() != leeg ||
                button[0][2].getIcon() == button[1][2].getIcon() && button[1][2].getIcon() == button[2][2].getIcon() && button[0][2].getIcon() != leeg ||
                button[0][0].getIcon() == button[1][1].getIcon() && button[1][1].getIcon() == button[2][2].getIcon() && button[0][0].getIcon() != leeg ||
                button[0][2].getIcon() == button[1][1].getIcon() && button[1][1].getIcon() == button[2][0].getIcon() && button[1][1].getIcon() != leeg) {
            System.out.println("ERMAGHERRRD ITS WORKINGG");
            if ((turn % 2) == 0)
                JOptionPane.showMessageDialog(panel, "Rondje heeft gewonnen");
            else
                JOptionPane.showMessageDialog(panel, "Kruisje heeft gewonnen");
        }
    }
}
