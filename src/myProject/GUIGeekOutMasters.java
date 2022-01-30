package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
            panelEspacioEnBlanco2, panelEspacioEnBlanco3, panelEspacioEnBlanco4, panelInstrucciones, panelAccionesDados;
    private JTextArea numeroRonda, puntaje, instrucciones;
    private String mensajeFinal = "";
    private int ronda, puntos, seleccionDado, boton, unDado;
    private ArrayList<JButton> botonesEnDadosUtilizados, botonesEnDadosInactivos, botonesEnDadosActivos;
    private static final String MENSAJE_INICIO =
                    "¡¡Bienvenido a Geek Out Masters!! \n"
                    +"\nPresiona \"Nueva ronda\" para comenzar a jugar.\n"
                    + "\nRecuerda leer las instrucciones, en el botón azul, para entender cómo jugar.";
    private  static final String INSTRUCCIONES =
                    "Lo primero que debes saber es que los dados aparecen aleatoriamente"
                    + " después de presionar \"Nueva ronda.\"\n"
                    + "\nDe los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados\""
                    + "Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\".\n"
                    + "\nSe van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan"
                    + " al sector de \"Dados Utilizados\".\n"
                    + "\nSi como último dado activo queda un Dragón, se perderán todos los puntos acumulados.\n"
                    + "\nEste juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas"
                    + " consecutivas de juego.\n"
                    + "\nTienes disponibles los siguientes dados:\n"
                    + "\n 1. El Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos.\n"
                    + "\n 2. La Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de"
                    + "  dados inactivos.\n"
                    + "\n 3. El Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado"
                    + "  y colocado en su cara opuesta.\n"
                    + "\n 4. El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que"
                    + "  sea un nuevo dado activo.\n"
                    + "\n 5. El Dragón es la cara que se quiere evitar, ya que, si al final de la ronda es el último"
                    + "  dado activo que queda se habrán perdido todos los puntos ganados y acumulados.\n"
                    + "\n 6. 42 es la cara que permite sumar puntos al final de la ronda.\n"
                    + "\nEs importante que sepas que las caras contrarias del dado corresponden a sus colores, es"
                    + " decir, la cara contraria al Corazón es el 42, ya que, tienen el mismo color (rojo); la cara"
                    + " contraria del Meeple es la Nave Espacial y la cara contraria del Superhéroe es el Dragón.\n"
                    + "\nPara activar el poder de un dado, debes presionar el dado que vas a activar y luego presionar"
                    + " el dado al que le vas a aplicar el poder.\n"
                    + "\nAl finalizar cada turno o ronda se cuenta la cantidad de dados con cara 42 en el área de dados"
                    + " puntuados teniendo en cuenta las reglas de la siguiente imagen. Se debe tener presente que, en"
                    + " cualquier ronda, existe el riesgo de quedar con un dragón en la zona de dados activos, en cuyo"
                    + " caso, los puntos dela ronda como los puntos acumulados (si se han jugado varias rondas) son"
                    + " eliminados, quedando con cero puntos.\n"
                    + "\nA continuación se listan las reglas para la asignación de puntos:\n"
                    + "\n1 Dado 42 -> 1 Punto       6 Dados 42 -> 21 Puntos\n"
                    + "\n2 Dados 42 -> 3 Puntos     7 Dados 42 -> 28 Puntos\n"
                    + "\n3 Dados 42 -> 6 Puntos     8 Dados 42 -> 36 Puntos\n"
                    + "\n4 Dados 42 -> 10 Puntos    9 Dados 42 -> 45 Puntos\n"
                    + "\n5 Dados 42 -> 15 Puntos    10 Dados 42 -> 55 Puntos\n";

    private Escucha escucha;
    private ModelGeekOutMasters game;

    /**
     * Constructor of GUI class
     */
    public GUIGeekOutMasters() {
        initGUI();

        //Default JFrame configuration
        this.setTitle("GeekOutMasterGame");
        this.setSize(1202, 580);
        //this.pack();
        //this.setSize(2000,2000);
        this.setUndecorated(true);
        this.setResizable(false);
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

        botonesEnDadosActivos = new ArrayList<JButton>();
        botonesEnDadosInactivos = new ArrayList<JButton>();
        botonesEnDadosUtilizados = new ArrayList<JButton>();

        seleccionDado = 1;

        imageDado =new ImageIcon(getClass().getResource("/resources/7.png"));
        imagenOtroTamanho =imageDado.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        imagenNuevoTamanho =new ImageIcon(imagenOtroTamanho);

        dado1 =new JButton(imagenNuevoTamanho);
        dado1.setBackground(Color.WHITE);
        dado2 =new JButton(imagenNuevoTamanho);
        dado2.setBackground(Color.WHITE);
        dado3 =new JButton(imagenNuevoTamanho);
        dado3.setBackground(Color.WHITE);
        dado4 =new JButton(imagenNuevoTamanho);
        dado4.setBackground(Color.WHITE);
        dado5 =new JButton(imagenNuevoTamanho);
        dado5.setBackground(Color.WHITE);
        dado6 =new JButton(imagenNuevoTamanho);
        dado6.setBackground(Color.WHITE);
        dado7 =new JButton(imagenNuevoTamanho);
        dado7.setBackground(Color.WHITE);
        dado8 =new JButton(imagenNuevoTamanho);
        dado8.setBackground(Color.WHITE);
        dado9 =new JButton(imagenNuevoTamanho);
        dado9.setBackground(Color.WHITE);
        dado10 =new JButton(imagenNuevoTamanho);
        dado10.setBackground(Color.WHITE);

        createHeader(constraints);
        createSpace1(constraints);
        createHelpButton(constraints);
        createRoundCount(constraints);
        createPointCounter(constraints);
        createExitButton(constraints);
        createSpace2(constraints);
        createDadosUtilizadosPane(constraints);
        createDadosInactivosPane(constraints);
        createSpace3(constraints);
        createDadosActivosPane(constraints);
        createSpace4(constraints);
        createNewRoundButton(constraints);
    }

    public void createHeader(GridBagConstraints constraints) {
        headerProject = new Header("Geek Out Masters", Color.GRAY);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(headerProject, constraints); //Change this line if you change JFrame Container's Layout
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createSpace1(GridBagConstraints constraints) {
        panelEspacioEnBlanco1 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco1, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createHelpButton(GridBagConstraints constraints) {
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
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createRoundCount(GridBagConstraints constraints) {
        ronda = 0;

        numeroRonda = new JTextArea(4, 8);
        numeroRonda.setMinimumSize(new Dimension(100, 40));
        numeroRonda.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        numeroRonda.setText("Ronda: " + ronda);
        numeroRonda.setBackground(new Color(254, 228, 64));
        numeroRonda.setEditable(false);
        numeroRonda.setBorder(BorderFactory.createRaisedBevelBorder());

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(numeroRonda, constraints);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createPointCounter(GridBagConstraints constraints) {
        puntos = 0;

        puntaje = new JTextArea(4, 8);
        puntaje.setMinimumSize(new Dimension(100, 40));
        puntaje.setFont(new Font("SansSerif", Font.BOLD + Font.PLAIN, 14));
        puntaje.setText("Puntaje: " + puntos);
        puntaje.setBackground(Color.WHITE);
        puntaje.setEditable(false);
        puntaje.setBorder(BorderFactory.createRaisedBevelBorder());

        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        add(puntaje, constraints);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createExitButton(GridBagConstraints constraints) {
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
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createSpace2(GridBagConstraints constraints) {
        panelEspacioEnBlanco2 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco2, constraints);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createDadosUtilizadosPane(GridBagConstraints constraints) {
        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setMinimumSize(new Dimension(600, 200));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados utilizados"));
        panelDadosUtilizados.setBackground(Color.WHITE);
        rePaintDadosUtilizados();

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(panelDadosUtilizados, constraints);
    }


    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createDadosInactivosPane(GridBagConstraints constraints) {
        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setMinimumSize(new Dimension(600, 200));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados inactivos"));
        panelDadosInactivos.setBackground(Color.WHITE);

        botonesEnDadosInactivos.add(dado8);
        botonesEnDadosInactivos.add(dado9);
        botonesEnDadosInactivos.add(dado10);

        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(panelDadosInactivos, constraints);

        determinateDadosInactivos();
    }

    public void determinateDadosInactivos()
    {
        imageDado = new ImageIcon(getClass().getResource("/resources/7.png"));
        imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
        for(boton=0;boton<botonesEnDadosInactivos.size();boton++)
        {
            botonesEnDadosInactivos.get(boton).setIcon(imagenNuevoTamanho);
            botonesEnDadosInactivos.get(boton).setBackground(Color.WHITE);
        }
        rePaintDadosInactivos();
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createSpace3(GridBagConstraints constraints)
    {
        panelEspacioEnBlanco3 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco3, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createAccionesDadosPane(GridBagConstraints constraints)
    {
        panelAccionesDados = new JPanel();
        panelAccionesDados.setBorder(BorderFactory.createTitledBorder("Acciones que está realizando"));
        panelAccionesDados.setMinimumSize(new Dimension(500, 200));
        panelAccionesDados.setBackground(Color.WHITE);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;

        this.add(panelAccionesDados, constraints);
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createDadosActivosPane(GridBagConstraints constraints)
    {
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(800, 600));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados activos"));
        panelDadosActivos.setBackground(Color.WHITE);

        botonesEnDadosActivos.add(dado1);
        botonesEnDadosActivos.add(dado2);
        botonesEnDadosActivos.add(dado3);
        botonesEnDadosActivos.add(dado4);
        botonesEnDadosActivos.add(dado5);
        botonesEnDadosActivos.add(dado6);
        botonesEnDadosActivos.add(dado7);

        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;

        this.add(panelDadosActivos, constraints);

        determinateDadosActivos();
    }

    public void determinateDadosActivos()
    {
        for(boton=0;boton<botonesEnDadosActivos.size();boton++)
        {
            if(ronda==0)
            {
                imageDado = new ImageIcon(getClass().getResource("/resources/7.png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
            }
            else
            {
                imageDado = new ImageIcon(getClass().getResource("/resources/" + game.dadosActivosArray.get(boton).newCara() + ".png"));
                imagenOtroTamanho = imageDado.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imagenNuevoTamanho = new ImageIcon(imagenOtroTamanho);
            }
            botonesEnDadosActivos.get(boton).setIcon(imagenNuevoTamanho);
            botonesEnDadosActivos.get(boton).setBackground(Color.WHITE);
        }
        rePaintDadosActivos();
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createSpace4(GridBagConstraints constraints)
    {
        panelEspacioEnBlanco4 = new JPanel();

        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 7;
        constraints.gridheight = 1;

        this.add(panelEspacioEnBlanco4, constraints);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void createNewRoundButton(GridBagConstraints constraints)
    {
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

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void rePaintDadosActivos()
    {
        panelDadosActivos.removeAll();

        panelDadosActivos.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelActivos = new GridBagConstraints();
        for(boton=0;boton<botonesEnDadosActivos.size();boton++)
        {
            switch (boton)
            {
                case 0:
                constraintsPanelActivos.gridx = 1;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(0), constraintsPanelActivos);
                break;
                case 1:
                constraintsPanelActivos.gridx = 2;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(1), constraintsPanelActivos);
                break;
                case 2:
                constraintsPanelActivos.gridx = 3;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(2), constraintsPanelActivos);
                break;
                case 3:
                constraintsPanelActivos.gridx = 4;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(3), constraintsPanelActivos);
                break;
                case 4:
                constraintsPanelActivos.gridx = 5;
                constraintsPanelActivos.gridy = 8;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_END;

                panelDadosActivos.add(botonesEnDadosActivos.get(4), constraintsPanelActivos);
                break;
                case 5:
                constraintsPanelActivos.gridx = 2;
                constraintsPanelActivos.gridy = 9;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(5), constraintsPanelActivos);
                break;
                case 6:
                constraintsPanelActivos.gridx = 4;
                constraintsPanelActivos.gridy = 9;
                constraintsPanelActivos.gridwidth = 1;
                constraintsPanelActivos.fill = GridBagConstraints.NONE;
                constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                panelDadosActivos.add(botonesEnDadosActivos.get(6), constraintsPanelActivos);
                break;
                case 7:
                    constraintsPanelActivos.gridx = 3;
                    constraintsPanelActivos.gridy = 9;
                    constraintsPanelActivos.gridwidth = 1;
                    constraintsPanelActivos.fill = GridBagConstraints.NONE;
                    constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                    panelDadosActivos.add(botonesEnDadosActivos.get(7), constraintsPanelActivos);
                    break;
                case 8:
                    constraintsPanelActivos.gridx = 1;
                    constraintsPanelActivos.gridy = 9;
                    constraintsPanelActivos.gridwidth = 1;
                    constraintsPanelActivos.fill = GridBagConstraints.NONE;
                    constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                    panelDadosActivos.add(botonesEnDadosActivos.get(8), constraintsPanelActivos);
                    break;
                case 9:
                    constraintsPanelActivos.gridx = 5;
                    constraintsPanelActivos.gridy = 9;
                    constraintsPanelActivos.gridwidth = 1;
                    constraintsPanelActivos.fill = GridBagConstraints.NONE;
                    constraintsPanelActivos.anchor = GridBagConstraints.LINE_START;

                    panelDadosActivos.add(botonesEnDadosActivos.get(9), constraintsPanelActivos);
                    break;
            }
        }
        revalidate();
        repaint();
    }

    private void rePaintDadosInactivos()
    {
        panelDadosInactivos.removeAll();

        panelDadosInactivos.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelInactivos = new GridBagConstraints();

        for(boton=0;boton<botonesEnDadosInactivos.size();boton++)
        {
            switch (boton)
            {
                case 0:
                constraintsPanelInactivos.gridx = 4;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(botonesEnDadosInactivos.get(0), constraintsPanelInactivos);
                break;
                case 1:
                constraintsPanelInactivos.gridx = 5;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(botonesEnDadosInactivos.get(1), constraintsPanelInactivos);
                break;
                case 2:
                constraintsPanelInactivos.gridx = 6;
                constraintsPanelInactivos.gridy = 4;
                constraintsPanelInactivos.gridwidth = 1;
                constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                panelDadosInactivos.add(botonesEnDadosInactivos.get(2), constraintsPanelInactivos);
                break;
                case 3:
                    constraintsPanelInactivos.gridx = 4;
                    constraintsPanelInactivos.gridy = 5;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(3), constraintsPanelInactivos);
                    break;
                case 4:
                    constraintsPanelInactivos.gridx = 5;
                    constraintsPanelInactivos.gridy = 5;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(4), constraintsPanelInactivos);
                    break;
                case 5:
                    constraintsPanelInactivos.gridx = 6;
                    constraintsPanelInactivos.gridy = 5;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(5), constraintsPanelInactivos);
                    break;
                case 6:
                    constraintsPanelInactivos.gridx = 4;
                    constraintsPanelInactivos.gridy = 6;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(6), constraintsPanelInactivos);
                    break;
                case 7:
                    constraintsPanelInactivos.gridx = 5;
                    constraintsPanelInactivos.gridy = 6;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(7), constraintsPanelInactivos);
                    break;
                case 8:
                    constraintsPanelInactivos.gridx = 6;
                    constraintsPanelInactivos.gridy = 6;
                    constraintsPanelInactivos.gridwidth = 1;
                    constraintsPanelInactivos.fill = GridBagConstraints.NONE;
                    constraintsPanelInactivos.anchor = GridBagConstraints.CENTER;

                    panelDadosInactivos.add(botonesEnDadosInactivos.get(8), constraintsPanelInactivos);
                    break;
            }
        }
        revalidate();
        panelDadosInactivos.updateUI();
    }

    private void rePaintDadosUtilizados()
    {
        panelDadosUtilizados.removeAll();

        panelDadosUtilizados.setLayout(new GridBagLayout());
        GridBagConstraints constraintsPanelUtilizados = new GridBagConstraints();

        for(boton=0;boton<botonesEnDadosUtilizados.size();boton++)
        {
            switch(boton)
            {
                case 0:
                    constraintsPanelUtilizados.gridx = 0;
                    constraintsPanelUtilizados.gridy = 4;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(0), constraintsPanelUtilizados);
                    break;
                case 1:
                    constraintsPanelUtilizados.gridx = 1;
                    constraintsPanelUtilizados.gridy = 4;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(1), constraintsPanelUtilizados);
                    break;
                case 2:
                    constraintsPanelUtilizados.gridx = 2;
                    constraintsPanelUtilizados.gridy = 4;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(2), constraintsPanelUtilizados);
                    break;
                case 3:
                    constraintsPanelUtilizados.gridx = 0;
                    constraintsPanelUtilizados.gridy = 5;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(3), constraintsPanelUtilizados);
                    break;
                case 4:
                    constraintsPanelUtilizados.gridx = 1;
                    constraintsPanelUtilizados.gridy = 5;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(4), constraintsPanelUtilizados);
                    break;
                case 5:
                    constraintsPanelUtilizados.gridx = 2;
                    constraintsPanelUtilizados.gridy = 5;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(5), constraintsPanelUtilizados);
                    break;
                case 6:
                    constraintsPanelUtilizados.gridx = 0;
                    constraintsPanelUtilizados.gridy = 6;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(6), constraintsPanelUtilizados);
                    break;
                case 7:
                    constraintsPanelUtilizados.gridx = 1;
                    constraintsPanelUtilizados.gridy = 6;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(7), constraintsPanelUtilizados);
                    break;
                case 8:
                    constraintsPanelUtilizados.gridx = 2;
                    constraintsPanelUtilizados.gridy = 6;
                    constraintsPanelUtilizados.gridwidth = 1;
                    constraintsPanelUtilizados.fill = GridBagConstraints.NONE;
                    constraintsPanelUtilizados.anchor = GridBagConstraints.CENTER;

                    panelDadosUtilizados.add(botonesEnDadosUtilizados.get(8), constraintsPanelUtilizados);
                    break;
            }
        }
        revalidate();
        panelDadosUtilizados.updateUI();
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

            //------------------------------------------------------------------------------------------------------------------------------------------

            JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
        });
    }



    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha extends MouseAdapter 
    {
        public void mouseClicked(MouseEvent e) 
        {
            if (e.getSource() == nuevaRonda)
            {
                if(ronda==5)
                {
                    if(game.endGame())
                    {
                        mensajeFinal="¡¡Felicidades!! Has ganado.\nPuedes volver a jugar empezando una nueva ronda.";
                    }
                    else
                    {
                        mensajeFinal="Has perdido.\nPuedes volver a jugar empezando una nueva ronda.";
                    }
                    JOptionPane.showMessageDialog(null, mensajeFinal);
                }
                else
                {
                    game.nextRound();

                    ronda = game.getRonda();
                    numeroRonda.setText("Ronda: " + ronda);

                    puntos = game.getPuntaje();
                    puntaje.setText("Puntaje: " + puntos);

                    GridBagConstraints constraints = new GridBagConstraints();

                    //------------------------------------------------------------------------------------------------------------------------------------------

                    if(botonesEnDadosUtilizados.size()!=0)
                    {
                        botonesEnDadosUtilizados.clear();
                    }
                    createDadosUtilizadosPane(constraints);

                    //------------------------------------------------------------------------------------------------------------------------------------------

                    game.determinateDadosInactivos();

                    if(botonesEnDadosInactivos.size()!=0)
                    {
                        botonesEnDadosInactivos.clear();
                    }
                    createDadosInactivosPane(constraints);

                    //------------------------------------------------------------------------------------------------------------------------------------------

                    game.determinateDadosActivos();

                    if(botonesEnDadosActivos.size()!=0)
                    {
                        botonesEnDadosActivos.clear();
                    }
                    createDadosActivosPane(constraints);

                    //------------------------------------------------------------------------------------------------------------------------------------------

                    revalidate();
                    repaint();
                }
            }
            else if (e.getSource() == ayuda)
            {
                panelInstrucciones = new JPanel();
                panelInstrucciones.setBackground(Color.WHITE);
                panelInstrucciones.setBorder(BorderFactory.createTitledBorder("Instrucciones del juego."));
                panelInstrucciones.setLayout(new BorderLayout());

                instrucciones = new JTextArea();
                instrucciones.setText(INSTRUCCIONES);
                instrucciones.setLineWrap(true);
                instrucciones.setPreferredSize(new Dimension(408, 1000));
                instrucciones.setWrapStyleWord(true);
                instrucciones.setLineWrap(true);
                instrucciones.setEditable(false);

                panelInstrucciones.add(instrucciones, BorderLayout.LINE_START);

                JScrollPane scroll = new JScrollPane(panelInstrucciones);
                scroll.setPreferredSize(new Dimension(435, 400));

                JOptionPane.showMessageDialog(null, scroll, "Instrucciones del juego", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(e.getSource() == salir)
            {
                System.exit(0);
            }
            else
            {
                switch(seleccionDado) //dice choice
                {
                    case 1:
                        for(boton=0;boton<botonesEnDadosActivos.size();boton++)
                        {
                            if (e.getSource() == botonesEnDadosActivos.get(boton))
                            {
                                if ((game.dadosActivosArray.get(0).getCara()) != 4 & (game.dadosActivosArray.get(0).getCara()) != 5 & (game.dadosActivosArray.get(0).getCara()) != 6)
                                {
                                    botonesEnDadosActivos.get(boton).removeMouseListener(escucha);
                                }
                                else if((game.dadosActivosArray.get(0).getCara()) == 4)
                                {
                                    game.powers(boton);
                                }
                                else if(((game.dadosActivosArray.get(0).getCara()) == 5))
                                {
                                    for(unDado=0;unDado<botonesEnDadosActivos.size();unDado++)
                                    {
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        break;
                }
            }
        }
    }
}



