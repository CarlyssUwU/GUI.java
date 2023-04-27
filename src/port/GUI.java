package port;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JTextField tfIDNumber;
    private JTextField tfWeight;
    private JTextArea taDescription;
    private JTextField tfRemintent;
    private JTextField tfReceiver;
    private JButton pileButton;
    private JButton unpileButton;
    private JComboBox cbCountry;
    private JTextField tfColumn;
    private JTextArea textArea1;
    private JCheckBox cbInspection;
    private JTextArea taShowDesc;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JButton showDescription;
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
    private JRadioButton hub1button;
    private JRadioButton hub2button;
    private JRadioButton hub3button;
    private JButton emptyAllHub;
    private JTextField showContainersOf;
    private JComboBox country2;
    Hub hub=new Hub();
    Hub hub2=new Hub();
    Hub hub3=new Hub();
    Container container = new Container();
    public void mainGUI() {
        setTitle("GUI");
        setSize(1375, 730);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainGUI);
        emptyAllHub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hub.clearHub();
                hub2.clearHub();
                hub3.clearHub();

                textArea1.setText("");
                tfWeight.setText("");
                tfIDNumber.setText("");
                taDescription.setText("Write the description of your container");
            }
        });
        showDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taDescription.getText();
                taShowDesc.setText(description+"\n which ID is: "+container.getIdentifier()+"\n has a weight of: "+container.getWeight()+"\n is from: "+cbCountry.getSelectedItem()+"\n with priority: "+container.getPriority()+"\n The sender company is: "+container.getSendingCompany()+"\n the receiver company will be: "+container.getReceiverCompany()+"\n Was this container checked? "+container.getInspected());
            }
        });
        hub1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub1button.isSelected()) {
                    textArea1.setText(hub.showHub());
                }
            }
        });
        hub2button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub2button.isSelected()) textArea1.setText(hub2.showHub());
            }
        });
        hub3button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hub3button.isSelected()) textArea1.setText(hub3.showHub());
            }
        });
        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    container.setIdentifier(Integer.parseInt(tfIDNumber.getText()));

                } catch (NumberFormatException nfe) {
                    tfIDNumber.setText("Introduce a number");
                }
                try {
                    container.setWeight(Integer.parseInt(tfWeight.getText()));
                } catch (NumberFormatException nfe) {
                    tfWeight.setText("Introduce a number, please");
                }
                container.setDescription(taDescription.getText());
                container.setCountryOfOrigin((String) cbCountry.getSelectedItem());
                if (a1RadioButton.isSelected()) container.setPriority(1);
                if (a2RadioButton.isSelected()) container.setPriority(2);
                if (a3RadioButton.isSelected()) container.setPriority(3);
                if (cbInspection.isSelected()) container.setInspected(true);
                container.setSendingCompany(tfRemintent.getText());
                container.setReceiverCompany(tfReceiver.getText());
                stack(container);
            }
        });
        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(tfColumn.getText()) > 12) {
                        tfColumn.setText("Please write a number between 1 and 12");
                    }
                    if (hub1button.isSelected()) {
                        hub.unstackContainers(Integer.parseInt(tfColumn.getText()) - 1);
                        textArea1.setText(hub.showHub());
                    }
                    if (hub2button.isSelected()) {
                        hub2.unstackContainers(Integer.parseInt(tfColumn.getText()) - 1);
                        textArea1.setText(hub2.showHub());
                    }
                    if (hub3button.isSelected()) {
                        hub3.unstackContainers(Integer.parseInt(tfColumn.getText()) - 1);
                        textArea1.setText(hub3.showHub());
                    }
                } catch (NumberFormatException nfe) {
                    tfColumn.setText("Please write a number between 1 and 12");
                }
            }
        });
        cbInspection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.setInspected(cbInspection.isSelected());
            }
        });
    }
    public void stack(Container container) {
        if(!hub.isFulled(container)) {
            hub.stackContainers(container);
            hub1button.setSelected(true);
            textArea1.setText(hub.showHub());
       }else if(!hub2.isFulled(container)){
            hub2.stackContainers(container);
            hub2button.setSelected(true);
            textArea1.setText(hub2.showHub());
       }else if (!hub3.isFulled(container)){
            hub3.stackContainers(container);
            hub3button.setSelected(true);
            textArea1.setText(hub3.showHub());
        }
        else if (hub3.isFulled(container) ){
            textArea1.setText("Please, this priority is fulled in all hubs, please select another priority, or wait until it is free");
        }
    }
    public static void main(String[] args) {
       GUI myGUI = new GUI();
       myGUI.mainGUI();
    }
}
