package myProject;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for apply Geek Out Masters rules.
 * @autor Sheilly Ortega, sheilly.ortega@correounivalle.edu.co
 *        Juan Mazuera, juan.yunda@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class ModelGeekOutMasters
{
    private Dados dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int dadosActivos, puntos, puntaje, flag, ronda;
    private int[] caras;
    private boolean terminar;

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
        caras = new int[7];

        dadosActivos = 0;
        ronda=0;
        puntaje=0;
        flag=0;
        terminar = false;
    }

    /**
     * Establish a number that represents the face of each dice in the game
     */

    public void calculateShot()
    {
        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        caras[2] = dado3.getCara();
        caras[3] = dado4.getCara();
        caras[4] = dado5.getCara();
        caras[5] = dado6.getCara();
        caras[6] = dado7.getCara();
    }

    /**
     * Count the amount of 42 that were obtained in the round
     * @return
     */

    public int calculatePoints()
    {
        for(flag=0;flag<dadosActivos;flag++)
        {
            if(caras[flag]==6)//If the dice face is 42 at end of a round incremed one point.
            {
                puntos=puntos+1;
                return 1;
            }
            else if(caras[flag]==0)
            {
                puntos=puntos;
                return 1;
            }
            else if(caras[flag]==0)
            {

            }
            else
            {
                return 0;
            }
        }
        flag=0;
        if(dadosActivos==1)
        {
            for(flag=0;flag<dadosActivos;flag++)
            {
                if (caras[flag] == 5)
                {
                    puntos = 0;
                    return 1;
                }
            }
        }
        return 1;
    }

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

    public void nextRound()
    {
        if(ronda==5)
        {
            puntaje=0;
            ronda=1;
        }
        else
        {
            ronda++;
        }
    }

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

    public void meeple()
    {

    }
    public void spaceship()
    {

    }
    public void superhero()
    {

    }
    public void heart()
    {

    }
    public void dragon()
    {

    }

    public int getPuntaje()
    {
        return puntaje;
    }
    public int getRonda()
    {
        return ronda;
    }
    public int[] getCaras()
    {
        return caras;
    }
    public int getDadosActivos()
    {
        return dadosActivos;
    }
}
