import javax.naming.ldap.SortResponseControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.jar.JarEntry;

public class Frame extends JFrame {
    JTextField textFieldSelezionato;
    public Frame(){
        setTitle("Convertitore");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.GRAY);

        //Label
        JLabel decimaleLabel = new JLabel("Decimale");
        decimaleLabel.setForeground(Color.WHITE);
        decimaleLabel.setBounds(1, 30, decimaleLabel.getPreferredSize().width, decimaleLabel.getPreferredSize().height);
        panel.add(decimaleLabel);

        JLabel binarioLabel = new JLabel("Binario");
        binarioLabel.setForeground(Color.WHITE);
        binarioLabel.setBounds(1, 70, binarioLabel.getPreferredSize().width, binarioLabel.getPreferredSize().height);
        panel.add(binarioLabel);

        JLabel ottaleLabel = new JLabel("Ottale");
        ottaleLabel.setForeground(Color.WHITE);
        ottaleLabel.setBounds(1, 110, ottaleLabel.getPreferredSize().width, ottaleLabel.getPreferredSize().height);
        panel.add(ottaleLabel);

        JLabel esaLabel = new JLabel("Esa");
        esaLabel.setForeground(Color.WHITE);
        esaLabel.setBounds(1, 150, esaLabel.getPreferredSize().width, esaLabel.getPreferredSize().height);
        panel.add(esaLabel);

        //TextField
        JTextField binario = new JTextField();
        binario.setBounds(65, 65, 535, 30);
        panel.add(binario);

        JTextField decimale = new JTextField();
        decimale.setBounds(65, 25, 535, 30);
        panel.add(decimale);
        textFieldSelezionato = decimale;

        JTextField ottale = new JTextField();
        ottale.setBounds(65, 105, 535, 30);
        panel.add(ottale);

        JTextField esa = new JTextField();
        esa.setBounds(65, 145, 535, 30);
        panel.add(esa);


        //Bottoni
        JButton conversione = new JButton("Conversione");
        conversione.setBounds(450, 500, conversione.getPreferredSize().width, conversione.getPreferredSize().height);
        conversione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //In base al textfield selezionato svolge una conversione
                if (textFieldSelezionato.equals(binario)){

                    int x = Integer.parseInt(binario.getText(), 2);
                    decimale.setText("" + x);
                    esa.setText("" + Integer.toHexString(x));
                    ottale.setText("" + Integer.toOctalString(x));

                } else if (textFieldSelezionato.equals(decimale)){

                    int x = Integer.parseInt(decimale.getText());
                    binario.setText("" + Integer.toBinaryString(x));
                    ottale.setText("" + Integer.toOctalString(x));
                    esa.setText("" + Integer.toHexString(x));

                } else if (textFieldSelezionato.equals(ottale)){
                    int x = Integer.parseInt(ottale.getText(), 8);
                    binario.setText("" + Integer.toBinaryString(x));
                    decimale.setText("" + x);
                    esa.setText("" + Integer.toHexString(x));

                } else if (textFieldSelezionato.equals(esa)){

                    int x = Integer.parseInt(esa.getText(), 16);
                    binario.setText("" + Integer.toBinaryString(x));
                    decimale.setText("" + x);
                    ottale.setText("" + Integer.toOctalString(x));
                }
            }
        });
        panel.add(conversione);

        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("" + i);
            //Se il bottono è > di 9, vuol dire che si usano le lettere ABCDEF
            switch (i){
                case 10:
                    button.setText("A");
                    break;
                case 11:
                    button.setText("B");
                    break;
                case 12:
                    button.setText("C");
                    break;
                case 13:
                    button.setText("D");
                    break;
                case 14:
                    button.setText("E");
                    break;
                case 15:
                    button.setText("F");
            }

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = textFieldSelezionato.getText();
                    textFieldSelezionato.setText(str + button.getText());
                }
            });
            button.setFont(new Font("Calibri", Font.PLAIN, 38));
            buttons.add(button);
            panel.add(button);
            //Rendo invisibili i bottoni ABCDEF
            if (i > 9){
                button.setVisible(false);
            }
        }

        buttons.get(0).setBounds(65, esa.getY() + 50, 75,75);
        buttons.get(1).setBounds(buttons.get(0).getX() + 95, buttons.get(0).getY(), 75,75);
        buttons.get(2).setBounds(buttons.get(1).getX() + 95, buttons.get(0).getY(), 75,75);
        buttons.get(3).setBounds(buttons.get(2).getX() + 95, buttons.get(0).getY(), 75,75);
        buttons.get(4).setBounds(buttons.get(3).getX() + 95, buttons.get(0).getY(), 75,75);

        buttons.get(5).setBounds(buttons.get(0).getX(), buttons.get(0).getY() + 95, 75,75);
        buttons.get(6).setBounds(buttons.get(1).getX(), buttons.get(1).getY() + 95, 75,75);
        buttons.get(7).setBounds(buttons.get(2).getX(), buttons.get(2).getY() + 95, 75,75);
        buttons.get(8).setBounds(buttons.get(3).getX(), buttons.get(3).getY() + 95, 75,75);
        buttons.get(9).setBounds(buttons.get(4).getX(), buttons.get(4).getY() + 95, 75,75);

        buttons.get(10).setBounds(buttons.get(0).getX(), buttons.get(5).getY() + 95, 75,75);
        buttons.get(11).setBounds(buttons.get(1).getX(), buttons.get(6).getY() + 95, 75,75);
        buttons.get(12).setBounds(buttons.get(2).getX(), buttons.get(7).getY() + 95, 75,75);
        buttons.get(13).setBounds(buttons.get(3).getX(), buttons.get(8).getY() + 95, 75,75);
        buttons.get(14).setBounds(buttons.get(4).getX(), buttons.get(9).getY() + 95, 75,75);

        buttons.get(15).setBounds(buttons.get(0).getX(), buttons.get(10).getY() + 95, 75,75);


        //Action listener textfield
        //Rende visibile/invisibile i bottoni in base alla conversione
        binario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Invisibili i numeri da 2 a ABCDEF
                for (int i = 2; i < 16; i++) {
                    buttons.get(i).setVisible(false);
                }
                //Imposta textfield
                textFieldSelezionato = binario;
            }
        });

        decimale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Rendo invisibili i numeri da 10 a ABCDEF
                for (int i = 10; i < 16; i++){
                    buttons.get(i).setVisible(false);
                }
                //Rendo visibili i numeri da 0 a 9
                for (int i = 0; i < 10; i++) {
                    buttons.get(i).setVisible(true);
                }
                textFieldSelezionato = decimale;
            }
        });

        ottale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //rendo visibili i numeri da 0 a 7
                for (int i = 0; i < 8; i++) {
                    buttons.get(i).setVisible(true);

                }
                //Rendo invisibili i numeri da 8 a ABCDEF
                for (int i = 8; i < 16; i++) {
                    buttons.get(i).setVisible(false);
                }
                textFieldSelezionato = ottale;
            }
        });

        esa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Rendo visibili tutti i bottoni
                for (int i = 0; i < 16; i++) {
                    buttons.get(i).setVisible(true);
                }

                textFieldSelezionato = esa;
            }
        });

        //Aggiungo pannello al Frame
        add(panel);
        //Rendo il Frame visibile
        setVisible(true);
    }
}
