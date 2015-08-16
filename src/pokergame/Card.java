package pokergame;

public class Card 
{
    private String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
    private String[] ranks  = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
        "Ten", "Jack", "Queen", "King" };
    
    private String suitString = "";
    private String rankString = "";
    
    public Card(int suit, int rank)
    {
        if(suit == 0) suitString = "Hearts";
        if(suit == 1) suitString = "Spades";
        if(suit == 2) suitString = "Diamonds";
        if(suit == 3) suitString = "Clubs";
        
        if(rank == 0) rankString = "Ace";
        if(rank == 1) rankString = "Two";
        if(rank == 2) rankString = "Three";
        if(rank == 3) rankString = "Four";
        if(rank == 4) rankString = "Five";
        if(rank == 5) rankString = "Six";
        if(rank == 6) rankString = "Seven";
        if(rank == 7) rankString = "Eight";
        if(rank == 8) rankString = "Nine";
        if(rank == 9) rankString = "Ten";
        if(rank == 10) rankString = "Jack";
        if(rank == 11) rankString = "Queen";
        if(rank == 12) rankString = "King";    
    }
    @Override
    public String toString()
    {
        return rankString + " of " + suitString;
    }
}
