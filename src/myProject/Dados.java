package myProject;

import java.util.Random;

public class Dados
{
    /**
     * Method that generate a random number to cara.
     * @return number between [1,6].
     * #1 = The Meeple: It allows you to re-roll another die in play, i.e. from the active dice section.
     * #2 = The Spaceship: It sends an unused die (from the active dice section) to the inactive dice section.
     * #3 = The Superhero: it allows any unused dice (active dice section) to be flipped over and placed on their opposite side.
     * #4 = The Heart: It allows you to take a die from the inactive dice section and roll it to be a new active die new active die.
     * #5 = The Dragon: It is the face to avoid, because if at the end of the round it is the last active die remaining, all points earned and accumulated will be lost.
     * #6 = 42: It is the face that allows points to be scored at the end of the round.
     */
    private int cara;

    public int getCara()
    {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
