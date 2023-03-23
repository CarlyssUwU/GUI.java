package port;
import javax.swing.*;
public class GUI extends JFrame {
    private JTextField tfIDNumber;
    private JTextField tfWeight;
    private JTextArea taDescription;
    private JTextField tfRemintent;
    private JTextField tfReceiver;
    private JButton pileButton;
    private JButton unpileButton;
    private JComboBox cbCountry;
    private JButton showContainerDescriptionButton;
    private JButton numberOfContainersButton;
    private JTextField tfColumn;
    private JTextArea textArea1;
    private JCheckBox cbInspection;
    private JTextArea taShowDesc;
    private JComboBox cbProcedenceCountry;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JTextField tfNumberOf;
    private JPanel mainGUI;
    private JLabel icon;
    private JLabel Country;
    private JLabel weight;
    private JLabel priority;
    private JLabel description;
    private JLabel IDNumber;
    private JLabel remitent;
    private JLabel receiver;
    private JLabel inspection;
    private JLabel operations;
    private JLabel stateHubPlanLabel;

    public void mainGUI() {
        setTitle("GUI");
        setSize(420, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainGUI);
    }

    public static void main(String[] args) {
        GUI myGUI = new GUI();
        myGUI.mainGUI();
    }
}
