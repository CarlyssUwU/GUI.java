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
    private JTextField containersNumbertf;
    private JButton showCountry;
    private JTextField tfshowCountry;
    private JButton showSender;
    private JButton showReceiver;
    private JTextField tfShowSender;
    private JTextField tfShowReceiver;
    private JRadioButton hub1button;
    private JRadioButton hub2button;
    private JRadioButton hub3button;
    Hub hub=new Hub();
    Hub hub2=new Hub();
    Hub hub3=new Hub();
    public void mainGUI() {
        setTitle("GUI");
        setSize(1375, 730);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        add(mainGUI);
        showDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description=taDescription.getText();
                taShowDesc.setText(description);
            }
        });
        hub1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hub1button.isSelected()){
                    textArea1.setText(hub.showHub());
                }
            }
        });
        hub2button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hub2button.isSelected())textArea1.setText(hub2.showHub());
            }
        });
        hub3button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hub3button.isSelected())textArea1.setText(hub3.showHub());
            }
        });
        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container container = new Container();
                try {
                    container.setIdentifier(Integer.parseInt(tfIDNumber.getText()));

                }catch (NumberFormatException nfe){
                    tfIDNumber.setText("Introduce a number");
                }
                try{
                    container.setWeight(Integer.parseInt(tfWeight.getText()));
                }catch (NumberFormatException nfe){
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
            public void actionPerformed(ActionEvent e){
                if (hub1button.isSelected())
                    for (int i=1; i<=Integer.parseInt(containersNumbertf.getText());i++) {
                        hub.unstackContainers(Integer.parseInt(tfColumn.getText())-1);
                        textArea1.setText(hub.showHub());
                    }
                if (hub2button.isSelected())
                    for (int i=1; i<=Integer.parseInt(containersNumbertf.getText());i++) {
                        hub2.unstackContainers(Integer.parseInt(tfColumn.getText())-1);
                        textArea1.setText(hub2.showHub());
                    }
                if (hub3button.isSelected())
                    for (int i=1; i<=Integer.parseInt(containersNumbertf.getText());i++) {
                        hub3.unstackContainers(Integer.parseInt(tfColumn.getText())-1);
                        textArea1.setText(hub3.showHub());
                    }
            }
        });
        showCountry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfshowCountry.setText((String)cbCountry.getSelectedItem());
            }
        });
        showSender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfShowSender.setText(tfRemintent.getText());
            }
        });
        showReceiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfShowReceiver.setText(tfReceiver.getText());
            }
        });
    }
    public void stack(Container container) {
        int numberOf=Integer.parseInt(containersNumbertf.getText());
        if(!hub.isFulled(container)) {
            checkN(container,numberOf);
            textArea1.setText(hub.showHub());
       }else if(!hub2.isFulled(container)){
           for (int j=1;j<=numberOf;j++){
              checkN2(container,numberOf);
               textArea1.setText(hub2.showHub());
           }
       }else if (!hub3.isFulled(container)){
               for (int k=1; k<=numberOf;k++){
                   hub3.stackContainers(container);
                   textArea1.setText(hub3.showHub());
               }
        }
        else if (hub3.isFulled(container) ){
            textArea1.setText("Please, this priority is fulled in all hubs, please select another priority, or wait until it is free");
        }
    }
    public void checkN(Container container, int numberOf){
    int aux=10;
    if (container.getPriority()!=3){
        if (numberOf>2*aux){
            aux=numberOf-2*aux;
            for (int i=1;i<=10;i++){
                hub.stackContainers(container);
                hub2.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub3.stackContainers(container);
            }
        }else if (numberOf>aux){
            aux=numberOf-aux;
            for (int i=1;i<=10; i++){
                hub.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub2.stackContainers(container);
            }
        }else for (int i=1;i<=numberOf; i++) {
            hub.stackContainers(container);
        }
    }else if(container.getPriority()==3){
        aux =100;
        if (numberOf>2*aux){
            aux=numberOf-2*aux;
            for (int i=1;i<=100;i++){
                hub.stackContainers(container);
                hub2.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub3.stackContainers(container);
            }
        }else if (numberOf>aux){
            aux=numberOf-aux;
            for (int i=1;i<=100; i++){
                hub.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub2.stackContainers(container);
            }
        }else {
            for (int i=1;i<=numberOf; i++) {
                hub.stackContainers(container);
            }
        }
    }

}
    public void checkN2(Container container, int numberOf){
    int aux=10;
    if (container.getPriority()!=3){
        if (numberOf>aux){
            aux=numberOf-aux;
            for (int i=1;i<=10; i++){
                hub2.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub3.stackContainers(container);
            }
        }
        else checkN(container,numberOf);
    }else if(container.getPriority()==3){
        aux =100;
        if (numberOf>aux){
            aux=numberOf-aux;
            for (int i=1;i<=10; i++){
                hub2.stackContainers(container);
            }
            for (int j=1;j<=aux;j++){
                hub3.stackContainers(container);
            }
        }else checkN(container,numberOf);
    }
}
    public static void main(String[] args) {
       GUI myGUI = new GUI();
       myGUI.mainGUI();
    }
}
