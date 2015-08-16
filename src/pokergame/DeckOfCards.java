package pokergame;
import java.util.ArrayList;
public final class DeckOfCards 
{
    ArrayList<String> deck = new ArrayList();
    String[][] dealtCards;
    
    public DeckOfCards(int numPlayers, int numCardsToDeal)
    {
        int maxPlayers = 52/numCardsToDeal;
        if(numPlayers>maxPlayers) numPlayers = maxPlayers;
        makeDeck();
        shuffleDeck();
        dealCards(numPlayers,numCardsToDeal);
    }
    public void makeDeck()
    {
        for(int i = 0; i<4; i++)
        {
            for(int j = 0; j<13; j++) 
            {
                deck.add(new Card(i,j).toString());
            }
        }
    }
    public void shuffleDeck()
    {
        for(int j = 0; j<100; j++)
        {
            for(int i = 0; i<deck.size(); i++)
            {
                int random = (int)(Math.random()*52);
                String temp = deck.get(i);
                deck.set(i, deck.get(random));
                deck.set(random, temp);
            }
        }
    }
    public void dealCards(int numPlayers, int numCardsToDeal)
    {
        dealtCards = new String[numPlayers][numCardsToDeal];
        int count = 0;
        for(int row = 0; row<numPlayers; row++)
        {
            System.out.println("Player " + (row+1));
            for(int col = 0; col<numCardsToDeal; col++)
            {
                dealtCards[row][col] = deck.get(0);
                deck.remove(0);
                System.out.println(dealtCards[row][col]);
                count++;
            }
            System.out.println();
        }
    }
}