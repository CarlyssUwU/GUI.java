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
       // GUI myGUI = new GUI();
       // myGUI.mainGUI();
        Hub hub1=new Hub();
        Hub hub2=new Hub();
        Hub hub3=new Hub();
        int i=1;
        Container container1=new Container(1);
        Container container2= new Container(2);
        Container container3=new Container (3);
        container1.setIdentifier(i);
        hub1.stackContainers(container1.getPriority());
        i++;
        hub1.stackContainers(container1.getPriority());
        container1.setIdentifier(i);
        hub1.stackContainers(container1.getPriority());
        i++;
        container2.setIdentifier(i);
        hub1.stackContainers(container2.getPriority());
      for (int j=0; j<3;j++){
          hub1.stackContainers(container3.getPriority());
      }
        System.out.println(hub1.toString());
    }
}
