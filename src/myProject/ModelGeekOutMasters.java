package myProject;

public class ModelGeekOutMasters
{
    private Dados dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int dadosActivos, puntos, puntaje, flag, ronda;
    private int[] caras;
    private String mensajeFinal;

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
        mensajeFinal="";
    }

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
        ronda++;
    }

    public String endGame()
    {
        if(ronda==5)
        {
            if(puntaje >= 30)
            {
                mensajeFinal="";//ganó
            }
            else
            {
                mensajeFinal="";//perdió
            }
        }
        return mensajeFinal;
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
