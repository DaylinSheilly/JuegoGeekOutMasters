package myProject;

import java.util.Random;

/**
 * Class Dados generate a Random value between 1 and 6
 * @autor Sheilly Ortega, sheilly.ortega@correounivalle.edu.co
 *        Juan Mazuera, juan.yunda@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class Dados
{
    /**
     * Method that generate a random number to cara.
     * @return number between [1,6].
     * #1 = The Meeple: It allows you to re-roll another dice in play, i.e. from the active dice section.
     * #2 = The Spaceship: It sends an unused die (from the active dice section) to the inactive dice section.
     * #3 = The Superhero: it allows any unused dice (active dice section) to be flipped over and placed on their opposite side.
     * #4 = The Heart: It allows you to take a die from the inactive dice section and roll it to be a new active die new active die.
     * #5 = The Dragon: It is the face to avoid, because if at the end of the round it is the last active die remaining, all points earned and accumulated will be lost.
     * #6 = 42: It is the face that allows points to be scored at the end of the round.
     */
    private int cara;
    private int caraOpuesta;

    public int getCara() {
        return cara;
    }

    public void setCara(int newCara)
    {
        this.cara = newCara;
    }

    public int newCara()
    {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        setCara(cara);
        return cara;
    }

    public int getCaraOpuesta()
    {
        switch (cara)
        {
            case 1: caraOpuesta = 2;
                break;
            case 2: caraOpuesta = 1;
                break;
            case 3: caraOpuesta = 5;
                break;
            case 4: caraOpuesta = 6;
                break;
            case 5: caraOpuesta = 3;
                break;
            case 6: caraOpuesta = 4;
        }
        setCara(caraOpuesta);
        return caraOpuesta;
    }
}
