
package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for to show game on screen and allow to play.
 * @autor Sheilly Ortega, sheilly.ortega@correounivalle.edu.co
 *        Juan Mazuera, juan.yunda@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */
public class GUIGeekOutMasters extends JFrame {

    private Header headerProject;
    private JButton dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private ImageIcon imageDado, imagenNuevoTamanho;
    private Image imagenOtroTamanho;
    private JButton ayuda, salir, lanzar, nuevaRonda;
    private JPanel panelDadosUtilizados, panelDadosInactivos, panelDadosActivos, panelEspacioEnBlanco1,
            panelEspacioEnBlanco2, panelEspacioEnBlanco3, panelEspacioEnBlanco4;
    private JTextArea numeroRonda, puntaje;
    private int ronda, puntos;
    private int[] caras;
    public static final String MENSAJE_INICIO = "Bienvenido a Geek Out Masters \n"
                                                + "El juego inicia cuando presiones Nueva ronda\n";
    private Escucha escucha;
    private ModelGeekOutMasters game;

    /**
     * Constructor of GUI class
     */
    public GUIGeekOutMasters() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("GeekOutMasterGame");
        //this.setSize(200,100);
        this.pack();
        //th/is.setUndecorated(true);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        game = new ModelGeekOutMasters();
        //Set up JComponents

        headerProject = new Header("Geek Out Masters", Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints); //Change this line if you change JFrame Container's Layout

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelEspacioEnBlanco1 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco1, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        ayuda = new JButton(" ? ");
        ayuda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        ayuda.setForeground(Color.white);
        ayuda.addMouseListener(escucha);
        ayuda.setBackground(new Color(0, 102, 255));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.WEST;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(ayuda, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        ronda = 0;
        numeroRonda = new JTextArea(1, 5);
        numeroRonda.setText("Ronda: " + ronda);
        numeroRonda.setBackground(Color.WHITE);
        numeroRonda.setEditable(false);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.WEST;
        constraints.anchor = GridBagConstraints.WEST;
        add(numeroRonda, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        puntos = 0;
        puntaje = new JTextArea(1, 5);
        puntaje.setText("Puntaje: " + puntos);
        puntaje.setBackground(Color.WHITE);
        puntaje.setEditable(false);

        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.CENTER;
        constraints.anchor = GridBagConstraints.CENTER;
        add(puntaje, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        salir = new JButton("Salir");
        salir.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        salir.setForeground(Color.WHITE);
        salir.addMouseListener(escucha);
        salir.setBackground(new Color(255, 81, 51));
        constraints.gridx = 6;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(salir, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelEspacioEnBlanco2 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco2, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        game.calculateShot();
        caras = game.getCaras();

        imageDado = new ImageIcon(getClass().getResource("/resources/7.png"));
        imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        dado1 = new JButton(imagenNuevoTamanho);
        dado1.setBackground(Color.WHITE);
        dado2 = new JButton(imagenNuevoTamanho);
        dado2.setBackground(Color.WHITE);
        dado3 = new JButton(imagenNuevoTamanho);
        dado3.setBackground(Color.WHITE);
        dado4 = new JButton(imagenNuevoTamanho);
        dado4.setBackground(Color.WHITE);
        dado5 = new JButton(imagenNuevoTamanho);
        dado5.setBackground(Color.WHITE);
        dado6 = new JButton(imagenNuevoTamanho);
        dado6.setBackground(Color.WHITE);
        dado7 = new JButton(imagenNuevoTamanho);
        dado7.setBackground(Color.WHITE);
        dado8 = new JButton(imagenNuevoTamanho);
        dado8.setBackground(Color.WHITE);
        dado9 = new JButton(imagenNuevoTamanho);
        dado9.setBackground(Color.WHITE);
        dado10 = new JButton(imagenNuevoTamanho);
        dado10.setBackground(Color.WHITE);

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setMinimumSize(new Dimension(600, 200));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados"));
        panelDadosUtilizados.setBackground(Color.WHITE);
        panelDadosUtilizados.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelUtilizados = new GridBagConstraints();
        /*panelDadosUtilizados.add(dado1);
        panelDadosUtilizados.add(dado2);
        panelDadosUtilizados.add(dado3);
        panelDadosUtilizados.add(dado4);
        panelDadosUtilizados.add(dado5);
        panelDadosUtilizados.add(dado6);
        panelDadosUtilizados.add(dado7);
        panelDadosUtilizados.add(dado8);
        panelDadosUtilizados.add(dado9);

        constraintsPanelUtilizados.gridx = 0;
        constraintsPanelUtilizados.gridy = 4;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado1, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 1;
        constraintsPanelUtilizados.gridy = 4;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado2, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 2;
        constraintsPanelUtilizados.gridy = 4;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado3, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 0;
        constraintsPanelUtilizados.gridy = 5;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado4, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 1;
        constraintsPanelUtilizados.gridy = 5;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado5, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 2;
        constraintsPanelUtilizados.gridy = 5;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado6, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 0;
        constraintsPanelUtilizados.gridy = 6;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado7, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 1;
        constraintsPanelUtilizados.gridy = 6;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

        panelDadosUtilizados.add(dado8, constraintsPanelUtilizados);

        constraintsPanelUtilizados.gridx = 2;
        constraintsPanelUtilizados.gridy = 6;
        constraintsPanelUtilizados.gridwidth = 1;
        constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
        constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

         */
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(panelDadosUtilizados, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setMinimumSize(new Dimension(600, 200));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos"));
        panelDadosInactivos.setBackground(Color.WHITE);
        panelDadosInactivos.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelInactivos = new GridBagConstraints();
        panelDadosInactivos.add(dado8);
        panelDadosInactivos.add(dado9);
        panelDadosInactivos.add(dado10);

        constraintsPanelInactivos.gridx = 4;
        constraintsPanelInactivos.gridy = 4;
        constraintsPanelInactivos.gridwidth = 1;
        constraintsPanelInactivos.fill = GridBagConstraints.NONE;
        constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

        panelDadosInactivos.add(dado8, constraintsPanelInactivos);

        constraintsPanelInactivos.gridx = 5;
        constraintsPanelInactivos.gridy = 4;
        constraintsPanelInactivos.gridwidth = 1;
        constraintsPanelInactivos.fill = GridBagConstraints.NONE;
        constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

        panelDadosInactivos.add(dado9, constraintsPanelInactivos);

        constraintsPanelInactivos.gridx = 6;
        constraintsPanelInactivos.gridy = 4;
        constraintsPanelInactivos.gridwidth = 1;
        constraintsPanelInactivos.fill = GridBagConstraints.NONE;
        constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

        panelDadosInactivos.add(dado10, constraintsPanelInactivos);

        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(panelDadosInactivos, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelEspacioEnBlanco3 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco3, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(800, 600));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados activos"));
        panelDadosActivos.setBackground(Color.WHITE);
        panelDadosActivos.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelActivos = new GridBagConstraints();

        constraintsPanelActivos.gridx = 1;
        constraintsPanelActivos.gridy = 8;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado1, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 2;
        constraintsPanelActivos.gridy = 8;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado2, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 3;
        constraintsPanelActivos.gridy = 8;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado3, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 4;
        constraintsPanelActivos.gridy = 8;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado4, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 5;
        constraintsPanelActivos.gridy = 8;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_END;

        panelDadosActivos.add(dado5, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 2;
        constraintsPanelActivos.gridy = 9;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado6, constraintsPanelActivos);

        constraintsPanelActivos.gridx = 4;
        constraintsPanelActivos.gridy = 9;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

        panelDadosActivos.add(dado7, constraintsPanelActivos);



        //------------------------------------------------------------------------------------------------------------------------------------------

        /*lanzar = new JButton("Lanzar");
        lanzar.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        lanzar.setForeground(Color.WHITE);
        lanzar.addMouseListener(escucha);
        lanzar.setBackground(new Color(63, 255, 51));
        lanzar.addMouseMotionListener((MouseMotionListener) escucha);

        constraintsPanelActivos.gridx = 3;
        constraintsPanelActivos.gridy = 10;
        constraintsPanelActivos.gridwidth = 1;
        constraintsPanelActivos.fill = GridBagConstraints.NONE;
        constraintsPanelActivos.anchor = GridBagConstraints.CENTER;

        panelDadosActivos.add(lanzar, constraintsPanelActivos);

        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(panelDadosActivos, constraints);*/

        //------------------------------------------------------------------------------------------------------------------------------------------

        panelEspacioEnBlanco4 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco4, constraints);

        //------------------------------------------------------------------------------------------------------------------------------------------

        nuevaRonda = new JButton("Nueva ronda");
        nuevaRonda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        nuevaRonda.setForeground(Color.WHITE);
        nuevaRonda.addMouseListener(escucha);
        nuevaRonda.setBackground(new Color(63, 255, 51));
        nuevaRonda.setFocusable(true);

        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(nuevaRonda, constraints);

    }

    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUIGeekOutMasters miProjectGUIGeekOutMasters = new GUIGeekOutMasters();
        });
    }



    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == nuevaRonda) {
                game.nextRound();

                game.calculateShot();
                caras = game.getCaras();

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[0] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado1.setIcon(imagenNuevoTamanho);
                dado1.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[1] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado2.setIcon(imagenNuevoTamanho);
                dado2.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[2] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado3.setIcon(imagenNuevoTamanho);
                dado3.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[3] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado4.setIcon(imagenNuevoTamanho);
                dado4.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[4] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado5.setIcon(imagenNuevoTamanho);
                dado5.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[5] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado6.setIcon(imagenNuevoTamanho);
                dado6.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/" + caras[6] + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado7.setIcon(imagenNuevoTamanho);
                dado7.setBackground(Color.WHITE);

                imageDado = new ImageIcon(getClass().getResource("/resources/7.png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
                dado8.setIcon(imagenNuevoTamanho);
                dado8.setBackground(Color.WHITE);
                dado9.setIcon(imagenNuevoTamanho);
                dado9.setBackground(Color.WHITE);
                dado10.setIcon(imagenNuevoTamanho);
                dado10.setBackground(Color.WHITE);

                GridBagConstraints constraints = new GridBagConstraints();



                panelDadosUtilizados.removeAll();



                constraints.gridx = 0;
                constraints.gridy = 4;
                constraints.gridwidth = 3;
                constraints.gridheight = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.LINE_START;

                add(panelDadosUtilizados, constraints);


                panelDadosInactivos.setLayout(new GridBagLayout());
                GridBagConstraints constraintsPanelInactivos = new GridBagConstraints();
                panelDadosInactivos.add(dado8);
                panelDadosInactivos.add(dado9);
                panelDadosInactivos.add(dado10);

                constraintsPanelInactivos.gridx = 4;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(dado8, constraintsPanelInactivos);

                constraintsPanelInactivos.gridx = 5;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(dado9, constraintsPanelInactivos);

                constraintsPanelInactivos.gridx = 6;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(dado10, constraintsPanelInactivos);

                constraints.gridx = 4;
                constraints.gridy = 4;
                constraints.gridwidth = 3;
                constraints.gridheight = 1;
                constraints.fill = GridBagConstraints.NONE;
                constraints.anchor = GridBagConstraints.LINE_END;

                add(panelDadosInactivos, constraints);


                panelDadosActivos = new JPanel();
                panelDadosActivos.setPreferredSize(new Dimension(800, 600));
                panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados activos"));
                panelDadosActivos.setBackground(Color.WHITE);
                panelDadosActivos.setLayout(new GridBagLayout());
                GridBagConstraints constraintsPanelActivos = new GridBagConstraints();

                constraintsPanelActivos.gridx = 1;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado1, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 2;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado2, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 3;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado3, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 4;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado4, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 5;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_END;

                panelDadosActivos.add(dado5, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 2;
                constraintsPanelActivos.gridy = 9;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado6, constraintsPanelActivos);

                constraintsPanelActivos.gridx = 4;
                constraintsPanelActivos.gridy = 9;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(dado7, constraintsPanelActivos);


                ronda = game.getRonda();
                numeroRonda.setText("Ronda: "+ ronda);

                puntos=game.getPuntaje();
                puntaje.setText("Puntaje: " + puntos);

            } else if (e.getSource() == ayuda) {
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            } else {
                System.exit(0);
            }
        }
    }
}



