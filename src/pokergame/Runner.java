
package pokergame;

public class Runner 
{
    public static void main(String[] args) 
    {
        PokerHand b = new PokerHand();
        System.out.println(b.whoWins(b.NUM_PLAYERS));
    }
}
