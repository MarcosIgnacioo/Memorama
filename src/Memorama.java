

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Memorama extends JFrame {

    private JPanel contentPane;
    private String cartaAnterior;
    private String cartaActual;
    private int posActual;
    private int posAnterior;
    private String[] cartasArregloId = {"A","B","C","D","A2","B2","C2","D2"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Memorama frame = new Memorama();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Memorama() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel reiniciarP = new JPanel();
        reiniciarP.setBackground(new Color(142, 205, 54));
        contentPane.add(reiniciarP, BorderLayout.SOUTH);

        JPanel cartasP = new JPanel();
        cartasP.setLayout(new GridLayout(2,4));
        contentPane.add(cartasP, BorderLayout.CENTER);

        setContentPane(contentPane);

        JButton cartasBotones[] = new JButton[8];
        randomizarArreglo(cartasArregloId);
        for (int i = 0; i<cartasBotones.length; i++){
            cartasBotones[i] = new JButton(cartasArregloId[i]);
            cartasBotones[i].setVisible(true);
            int finalI = i;
            cartasBotones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    posAnterior = posActual;
                    posActual = finalI;
                    cartaAnterior = cartaActual;
                    cartaActual = cartasArregloId[finalI];
                    if ((cartaActual+"2").equals(cartaAnterior) || cartaActual.equals((cartaAnterior+"2"))){
                        cartasBotones[posActual].setEnabled(false);
                        cartasBotones[posAnterior].setEnabled(false);
                    }
                    else{
                        cartaAnterior = "";
                    }
                }
            });
            cartasP.add(cartasBotones[i]);
            repaint();
            revalidate();
        }
    }
    public String[] randomizarArreglo(String[] arreglo){
        Random rnd = new Random();
        for (int i=0; i<arreglo.length; i++){
            int random = rnd.nextInt(arreglo.length);
            String tmp = arreglo[i];
            arreglo[i] = arreglo[random];
            arreglo[random] = tmp;
        }
        return arreglo;
    }
}
