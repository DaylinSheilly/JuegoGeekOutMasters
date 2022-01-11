package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for to show game on screen and allow to play.
 * @autor Sheilly Ortega, sheilly.ortega@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */
public class GUIGeekOutMasters extends JFrame {

    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private ImageIcon imageDado;
    private Image imagenOtroTamanho;
    private ImageIcon imagenNuevoTamanho;
    private JButton ayuda, salir, lanzar, nuevaRonda;
    private JPanel panelDadosUtilizados, panelDadosInactivos, panelDadosActivos;
    private JTextArea numeroRonda, puntaje;
    public static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters \n";
    private Escucha escucha;

    /**
     * Constructor of GUI class
     */
    public GUIGeekOutMasters(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("GeekOutMasterGame");
        this.setSize(200,100);
        //this.pack();
        //this.setUndecorated(true);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     *
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints); //Change this line if you change JFrame Container's Layout

        ayuda = new JButton(" ? ");
        ayuda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        ayuda.setForeground(Color.white);
        ayuda.addActionListener(escucha);
        ayuda.setBackground(new Color(0, 102, 255));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(ayuda, constraints);

        numeroRonda = new JTextArea(1, 5);
        numeroRonda.setText("Ronda: ");
        numeroRonda.setBackground(Color.WHITE);
        numeroRonda.setEditable(false);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(numeroRonda, constraints);

        puntaje = new JTextArea(1, 5);
        puntaje.setText("Puntaje: ");
        puntaje.setBackground(Color.WHITE);
        puntaje.setEditable(false);

        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;
        add(puntaje, constraints);

        salir = new JButton("Salir");
        salir.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        salir.setForeground(Color.WHITE);
        salir.addActionListener(escucha);
        salir.setBackground(new Color(255, 81, 51));
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(salir, constraints);

        /*imageDado = new ImageIcon(getClass().getResource("/resources/dado.png"));
        imagenOtroTamanho = imageDado.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        dado1 = new JLabel(imagenNuevoTamanho);
        dado2 = new JLabel(imagenNuevoTamanho);
        dado3 = new JLabel(imagenNuevoTamanho);
        dado4 = new JLabel(imagenNuevoTamanho);
        dado5 = new JLabel(imagenNuevoTamanho);
        dado6 = new JLabel(imagenNuevoTamanho);
        dado7 = new JLabel(imagenNuevoTamanho);
        dado8 = new JLabel(imagenNuevoTamanho);
        dado9 = new JLabel(imagenNuevoTamanho);
        dado10 = new JLabel(imagenNuevoTamanho);*/

        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(450, 250));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados"));
        panelDadosUtilizados.setBackground(Color.WHITE);
        //panelDadosUtilizados.add(dado1);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(panelDadosUtilizados, constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(450, 250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos"));
        panelDadosInactivos.setBackground(Color.WHITE);
        //panelDadosInactivos.add(dado1);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(panelDadosInactivos, constraints);

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(450, 250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados activos"));
        panelDadosActivos.setBackground(Color.WHITE);
        /*panelDadosUtilizados.add(dado1);
        panelDadosUtilizados.add(dado2);
        panelDadosUtilizados.add(dado3);
        panelDadosUtilizados.add(dado4);
        panelDadosUtilizados.add(dado5);
        panelDadosUtilizados.add(dado6);
        panelDadosUtilizados.add(dado7);
        panelDadosUtilizados.add(dado8);
        panelDadosUtilizados.add(dado9);
        panelDadosUtilizados.add(dado10);*/

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(panelDadosActivos, constraints);

        lanzar = new JButton("Lanzar");
        lanzar.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        lanzar.setForeground(Color.WHITE);
        lanzar.addActionListener(escucha);
        lanzar.setBackground(new Color(63, 255, 51));

        this.add(lanzar, constraints);
        panelDadosActivos.add(lanzar);

        nuevaRonda = new JButton("Nueva ronda");
        nuevaRonda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        nuevaRonda.setForeground(Color.WHITE);
        //nuevaRonda.addMouseListener(escucha);
        nuevaRonda.setBackground(new Color(63, 255, 51));

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(nuevaRonda, constraints);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGeekOutMasters miProjectGUIGeekOutMasters = new GUIGeekOutMasters();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==lanzar){
            }
            else if(e.getSource()==ayuda){
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }else{
                System.exit(0);
            }
        }
    }
}
