package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class is used for apply Geek Out Masters rules.
 * @autor Sheilly Ortega, sheilly.ortega@correounivalle.edu.co
 *        Juan Mazuera, juan.yunda@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class ModelGeekOutMasters
{
    private Dados dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int puntos, puntaje, flag, ronda, caraPoder, unDado, dados42, dadosDragon;
    private boolean terminar;
    public ArrayList<Dados> dadosUtilizadosArray, dadosInactivosArray, dadosActivosArray;

    /**
     * Class Constructor
     */

    public ModelGeekOutMasters()
    {
        dado1 = new Dados();
        dado2 = new Dados();
        dado3 = new Dados();
        dado4 = new Dados();
        dado5 = new Dados();
        dado6 = new Dados();
        dado7 = new Dados();
        dado8 = new Dados();
        dado9 = new Dados();
        dado10 = new Dados();

        ronda=0;
        puntaje=0;
        flag=0;
        puntos=0;

        dadosActivosArray = new ArrayList<Dados>();
        dadosInactivosArray = new ArrayList<Dados>();
        dadosUtilizadosArray = new ArrayList<Dados>();

        determinateDadosActivos();
        determinateDadosInactivos();
    }

    public void determinateDadosActivos()
    {
        dadosActivosArray.add(dado1);
        dadosActivosArray.add(dado2);
        dadosActivosArray.add(dado3);
        dadosActivosArray.add(dado4);
        dadosActivosArray.add(dado5);
        dadosActivosArray.add(dado6);
        dadosActivosArray.add(dado7);
    }

    public void determinateDadosInactivos()
    {
        dadosInactivosArray.add(dado8);
        dadosInactivosArray.add(dado9);
        dadosInactivosArray.add(dado10);
    }

    public ArrayList<Dados> getDadosUtilizadosArray() {
        return dadosUtilizadosArray;
    }

    public ArrayList<Dados> getDadosInactivosArray() {
        return dadosInactivosArray;
    }

    public ArrayList<Dados> getDadosActivosArray() {
        return dadosActivosArray;
    }

    public void removeDiceFromArray(int posicionDado, ArrayList<Dados> array)
    {
        array.remove(posicionDado);
    }

    public void addDiceFromArray(ArrayList<Dados> array, Dados dado, int posicion)
    {
        array.add(posicion, dado);
        if(array==dadosUtilizadosArray)
        {
            flag++;
        }
    }

    public void addDiceFromArray(ArrayList<Dados> array, Dados dado)
    {
        array.add(dado);
        if(array==dadosUtilizadosArray)
        {
            flag++;
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------

    public void determinateScore()
    {
        if(puntos==0)
        {
            puntaje=0;
        }
        else if(puntos==1)
        {
            puntaje=1;
        }
        else if(puntos==2)
        {
            puntaje=3;
        }
        else if(puntos==3)
        {
            puntaje=6;
        }
        else if(puntos==4)
        {
            puntaje=10;
        }
        else if(puntos==5)
        {
            puntaje=15;
        }
        else if(puntos==6)
        {
            puntaje=21;
        }
        else if(puntos==7)
        {
            puntaje=28;
        }
        else if(puntos==8)
        {
            puntaje=36;
        }
        else if(puntos==9)
        {
            puntaje=45;
        }
        else if(puntos==10)
        {
            puntaje=55;
        }
        else
        {
            puntaje=puntaje;
        }
    }

    public void roundPoints()
    {
        dados42 = 0;
        for(unDado=0;unDado<10;unDado++)
        {
            if (dadosActivosArray.get(unDado) != null)
            {
                if (dadosActivosArray.get(unDado).getCara() == 6)
                {
                    dados42++;
                }
            }
        }
        puntos = puntos+dados42;
    }

    public void drakeDices()
    {
        dadosDragon = 0;
        for(unDado=0;unDado<10;unDado++)
        {
            if (dadosActivosArray.get(unDado) != null)
            {
                if (dadosActivosArray.get(unDado).getCara() == 6)
                {
                    puntos = 0;
                    puntaje = 0;
                }
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void nextRound()
    {
        if(ronda==5)
        {
            flag=0;
            puntaje=0;
            ronda=1;
        }
        else
        {
            flag=0;
            if(dadosActivosArray.size()!=0)
            {
                dadosActivosArray.clear();
            }
            if(dadosInactivosArray.size()!=0)
            {
                dadosInactivosArray.clear();
            }
            if(dadosUtilizadosArray.size()!=0)
            {
                dadosUtilizadosArray.clear();
            }
            determinateDadosActivos();
            determinateDadosInactivos();

            ronda++;
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public boolean endGame()
    {
        if(ronda==5)
        {
            if(puntaje >= 30)
            {
                terminar=true;//ganó
            }
            else
            {
                terminar=false;//perdió
            }
        }
        return terminar;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public void powers(int posicionDadoActivo)
    {
        caraPoder=dadosActivosArray.get(posicionDadoActivo).getCara();

        JOptionPane.showMessageDialog(null, "antes");
        for(int i=0;i<dadosActivosArray.size();i++)
        {
            JOptionPane.showMessageDialog(null, dadosActivosArray.get(i).getCara());
        }
        addDiceFromArray(dadosUtilizadosArray,dadosActivosArray.get(posicionDadoActivo));
        removeDiceFromArray(posicionDadoActivo,dadosActivosArray);
        JOptionPane.showMessageDialog(null, "despues");
        for(int i=0;i<dadosActivosArray.size();i++)
        {
            JOptionPane.showMessageDialog(null, dadosActivosArray.get(i).getCara());
        }
        JOptionPane.showMessageDialog(null, "listo");
    }

    public void meeple(int posicionDadoActivo)
    {
        JOptionPane.showMessageDialog(null,"meeple acción");
    }
    public void spaceship(int posicionDadoActivo)
    {
        addDiceFromArray(dadosInactivosArray,dadosActivosArray.get(posicionDadoActivo));
        removeDiceFromArray(posicionDadoActivo,dadosActivosArray);
        JOptionPane.showMessageDialog(null,"cohete acción");
    }
    public void superhero(int posicionDadoActivo)
    {
        JOptionPane.showMessageDialog(null,"superheroe acción");
    }
    public void heart(int posicionDadoActivo)
    {
        addDiceFromArray(dadosActivosArray,dadosInactivosArray.get(flag),posicionDadoActivo);
        removeDiceFromArray(flag,dadosInactivosArray);
        JOptionPane.showMessageDialog(null,"corazón acción");
    }

    //------------------------------------------------------------------------------------------------------------------------------------------

    public int getPuntaje()
    {
        return puntaje;
    }
    public int getRonda()
    {
        return ronda;
    }
}
