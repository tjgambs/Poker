
package pokergame;
public class PokerHand 
{
    public final int NUM_PLAYERS = 2;
    
    DeckOfCards b = new DeckOfCards(NUM_PLAYERS,5);

    int firstTwoKind = 0;
    int secondTwoKind = 0;
    int threeKind = 0;
    int largestHand = 0;
    
    int[] calculatedScores;
    String[] hands;
    
    int[][] suitsCount;
    int[][] ranksCount;
    
    public void count(int numPlayers, int numCardsToDeal) 
    {
        suitsCount = new int[numPlayers][4];
        ranksCount = new int[numPlayers][13];
        for(int row = 0; row<numPlayers; row++)
        {
            int countHearts = 0;
            int countClubs = 0;
            int countSpades = 0;
            int countDiamonds = 0;
            
            int countOnes = 0;
            int countTwos = 0;
            int countThrees = 0;
            int countFours = 0;
            int countFives = 0;
            int countSixes = 0;
            int countSevens = 0;
            int countEights = 0;
            int countNines = 0;
            int countTens = 0;
            int countJacks = 0;
            int countQueens = 0;
            int countKings = 0;

            for(int col = 0; col<numCardsToDeal; col++)
            {
                if(b.dealtCards[row][col].contains("Hearts")) countHearts++;
                if(b.dealtCards[row][col].contains("Clubs")) countClubs++;
                if(b.dealtCards[row][col].contains("Spades")) countSpades++;
                if(b.dealtCards[row][col].contains("Diamonds")) countDiamonds++;
                
                if(b.dealtCards[row][col].contains("Ace")) countOnes++;
                if(b.dealtCards[row][col].contains("Two")) countTwos++;
                if(b.dealtCards[row][col].contains("Three")) countThrees++;
                if(b.dealtCards[row][col].contains("Four")) countFours++;
                if(b.dealtCards[row][col].contains("Five")) countFives++;
                if(b.dealtCards[row][col].contains("Six")) countSixes++;
                if(b.dealtCards[row][col].contains("Seven")) countSevens++;
                if(b.dealtCards[row][col].contains("Eight")) countEights++;
                if(b.dealtCards[row][col].contains("Nine")) countNines++;
                if(b.dealtCards[row][col].contains("Ten")) countTens++;
                if(b.dealtCards[row][col].contains("Jack")) countJacks++;
                if(b.dealtCards[row][col].contains("Queen")) countQueens++;
                if(b.dealtCards[row][col].contains("King")) countKings++;            
            }
            suitsCount[row][0] = countHearts;
            suitsCount[row][1] = countClubs;
            suitsCount[row][2] = countSpades;
            suitsCount[row][3] = countDiamonds;
            
            ranksCount[row][0] = countOnes;
            ranksCount[row][1] = countTwos;
            ranksCount[row][2] = countThrees;
            ranksCount[row][3] = countFours;
            ranksCount[row][4] = countFives;
            ranksCount[row][5] = countSixes;
            ranksCount[row][6] = countSevens;
            ranksCount[row][7] = countEights;
            ranksCount[row][8] = countNines;
            ranksCount[row][9] = countTens;
            ranksCount[row][10] = countJacks;
            ranksCount[row][11] = countQueens;
            ranksCount[row][12] = countKings;
        }
    }
    public boolean checkIfAllSameSuit(int playerWhat)
    {
        for(int i = 0; i<4; i++)
        {
            if(suitsCount[playerWhat][i] == 5) return true;
        }
        return false;
    }
    public boolean checkStraightFlush(int playerWhat)
    {
        if(checkIfAllSameSuit(playerWhat))
        {
            return checkStraight(playerWhat);
        }
        return false;
    }
    public boolean checkFourOfAKind(int playerWhat)
    {
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 4)
            {
                return true;
            }
        }
        return false;
    }
    public int countFourOfAKind(int playerWhat)
    {
        int sumOfFourOfAKind = 0; 
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 4)
            {
                sumOfFourOfAKind = (i+1)*4;
            }
        }
        return sumOfFourOfAKind;
    }
    public boolean checkFullHouse(int playerWhat)
    {
        return checkThree(playerWhat) == 1 && checkPair(playerWhat) == 1;
    }
    public int countFullHouse(int playerWhat)
    {
        int first = 0;
        int second = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 3)
            {
                first = (i+1)*3;
            }
            if(ranksCount[playerWhat][i] == 2)
            {
                second = (i+1)*2;
            }
        }
        return first+second;
    }
    public boolean checkFlush(int playerWhat)
    {
        return checkIfAllSameSuit(playerWhat);
    }
    public int countFlush(int playerWhat)
    {
        int sumOfFlush = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 1) sumOfFlush += (i+1);
        }
        return sumOfFlush;
    }
    public boolean checkStraight(int playerWhat)
    {
        for(int i = 0; i<8; i++)
        {
            int count = 0;
            for(int j = i; j<13; j++)
            {
                if(ranksCount[playerWhat][j] > 0) count++;
                else break;
            }
            if(count == 5) return true;
        }
        return false;
    }
    public int countStraight(int playerWhat)
    {
        int sumOfStraight = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 1) sumOfStraight += (i+1);
        }
        return sumOfStraight;
    }
    public boolean checkThreeOfAKind(int playerWhat)
    {
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] >= 3) return true;
        }
        return false;
    }
    public int countThreeOfAKind(int playerWhat)
    {
        int sumOfThreeOfAKind = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 3) sumOfThreeOfAKind = (i+1)*3;
        }
        return sumOfThreeOfAKind;
    }
    public boolean checkTwoPair(int playerWhat)
    {
        return checkPair(playerWhat) == 1; 
    }
    public int countTwoPair(int playerWhat)
    {
        int sumOfTwoPairs = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 2) sumOfTwoPairs += (i+1)*2;
        }
        return sumOfTwoPairs;
    }
    public boolean checkOnePair(int playerWhat)
    {
        return checkPair(playerWhat) == 0;
    }
    public int countOnePair(int playerWhat)
    {
        int sumOfOnePair = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] == 2) sumOfOnePair = (i+1)*2;
        }
        return sumOfOnePair;
    }
    public int checkHighest(int playerWhat)
    {
        int highestCardValue = 0;
        for(int i = 12; i>0; i--)
        {
            if(ranksCount[playerWhat][i] != 0)
            {
                highestCardValue = i+1;
                break;
            }
        }
        return highestCardValue;
    }
    public int countHighest(int playerWhat)
    {
        int highestCard = 0;
        for(int i = 12; i>-1; i--)
        {
            if(ranksCount[playerWhat][i] == 1)
            {
                highestCard = (i+1);
                break;
            }
        }
        return highestCard;
    }
    public int countSecondHighest(int playerWhat)
    {
        int secondHighestCard = 0;
        for(int i = 12; i>0; i--)
        {
            if(ranksCount[playerWhat][i] == 1)
            {
                if(ranksCount[playerWhat][i-1] == 1)
                {
                    secondHighestCard = (i+1);
                    break;
                }
            }
        }
        return secondHighestCard;
    }
    public int checkPair(int playerWhat)
    {
        firstTwoKind = 0;
        secondTwoKind = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] >= 2)
            {
                if(firstTwoKind == 0) firstTwoKind = ranksCount[playerWhat][i];
                else secondTwoKind = ranksCount[playerWhat][i];
            }
        }
        if(secondTwoKind != 0 && firstTwoKind != 0) return 1;
        if(firstTwoKind != 0) return 0;
        return -1;
    }
    public int checkThree(int playerWhat)
    {
        threeKind = 0;
        for(int i = 0; i<13; i++)
        {
            if(ranksCount[playerWhat][i] >= 3) threeKind = ranksCount[playerWhat][i];
        }
        if(threeKind != 0) return 1;
        return -1;
    }
    public boolean checkHighest()
    {
        return true;
    }
    public void finalTotals(int numPlayers) 
    {
        calculatedScores = new int[numPlayers];
        hands = new String[numPlayers];
        
        for(int row = 0; row<numPlayers; row++)
        {
            if(checkHighest())
            {
                calculatedScores[row] = 1;
                hands[row] = "Highest Card";
            }
            if(checkOnePair(row))
            {
                calculatedScores[row] = 2;
                hands[row] = "One Pair";
            }
            if(checkTwoPair(row))
            {
                calculatedScores[row] = 3;
                hands[row] = "Two Pairs";
            }
            if(checkThreeOfAKind(row))
            {
                calculatedScores[row] = 4;
                hands[row] = "Three of a Kind";
            }
            if(checkStraight(row))
            {
                calculatedScores[row] = 5;
                hands[row] = "Straight";
            }
            if(checkFlush(row))
            {
                calculatedScores[row] = 6;
                hands[row] = "Flush";
            }
            if(checkFullHouse(row))
            {
                calculatedScores[row] = 7;
                hands[row] = "Full House";
            }
            if(checkFourOfAKind(row))
            {
                calculatedScores[row] = 8;
                hands[row] = "Four of a Kind";
            }
            if(checkStraightFlush(row))
            {
                calculatedScores[row] = 9;
                hands[row] = "Straight Flush";
            }    
        }
    }
    public String ifCalculatedScores1(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countHighest(j) == highestScore)
            {
                for(int k = 12; k>-1; k--)
                {
                    if(ranksCount[winner][k] < ranksCount[j][k])
                    {
                        winner = j;
                        break;
                    }
                    if(ranksCount[winner][k] > ranksCount[j][k]) break;
                }
            }
            if(countHighest(j)>highestScore)
            {
                winner = j;
                highestScore = countHighest(j);
            }
        }
        return "Player " + (winner+1) + " is the winner with the Highest Card!";
    }
    public String ifCalculatedScores2(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        String win = "";
        for(int j = 0; j<numPlayers; j++)
        {
            if(countOnePair(j) == highestScore)
            {
                win = "Tie.";
            }
            if(countOnePair(j)>highestScore)
            {
                winner = j;
                highestScore = countOnePair(j);
                win = "Player " + (winner+1) + " is the winner with One Pair!";
            }
        }
        return win;
    }
    public String ifCalculatedScores3(int numPlayers)
    {
        String win = "";
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countTwoPair(j) == highestScore)
            {
                win = "Tie.";
            }
            if(countTwoPair(j)>highestScore)
            {
                winner = j;
                highestScore = countTwoPair(j);
                win = "Player " + (winner+1) + " is the winner with Two Pairs!";
            }
        }
        return win;
    }
    public String ifCalculatedScores4(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countThreeOfAKind(j)>highestScore)
            {
            winner = j;
            highestScore = countThreeOfAKind(j);
            }
        }
        return "Player " + (winner+1) + " is the winner with Three of a Kind!";
    }
    public String ifCalculatedScores5(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countStraight(j)>highestScore)
            {
                winner = j;
                highestScore = countStraight(j);
            }
        }           
        return "Player " + (winner+1) + " is the winner with a Straight!";
    }
    public String ifCalculatedScores6(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countFlush(j)>highestScore)
            {
                winner = j;
                highestScore = countFlush(j);
            }
        }
        return "Player " + (winner+1) + " is the winner with a Flush!";
    }
    public String ifCalculatedScores7(int numPlayers)
    {
        String win = "";
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countFullHouse(j) == highestScore)
            {
                win = "Tie.";
            }
            if(countFullHouse(j)>highestScore)
            {
                winner = j;
                highestScore = countFullHouse(j);
                win = "Player " + (winner+1) + " is the winner with a Full House!";
            }
        }
        return win;
    }
    public String ifCalculatedScores8(int numPlayers)
    {
        int winner = 0;
        int highestScore = 0;
        for(int j = 0; j<numPlayers; j++)
        {
            if(countFlush(j)>highestScore)
            {
                winner = j;
                highestScore = countFlush(j);
            }
        }
        return "Player " + (winner+1) + " is the winner with a Straight Flush!";
    }
    public String whoWins(int numPlayers)
    {
        count(NUM_PLAYERS,5); 
        finalTotals(numPlayers);
        int winningPlayer;
        largestHand = 0;
        String winningPlayersHand;
        String win = "";
        for(int i = 0; i<numPlayers; i++)
        {
            if(calculatedScores[i] == largestHand)
            {
                if(calculatedScores[i] == 1) win = ifCalculatedScores1(numPlayers);
                if(calculatedScores[i] == 2) win = ifCalculatedScores2(numPlayers);
                if(calculatedScores[i] == 3) win = ifCalculatedScores3(numPlayers);
                if(calculatedScores[i] == 4) win = ifCalculatedScores4(numPlayers);
                if(calculatedScores[i] == 5) win = ifCalculatedScores5(numPlayers);
                if(calculatedScores[i] == 6) win = ifCalculatedScores6(numPlayers);
                if(calculatedScores[i] == 7) win = ifCalculatedScores7(numPlayers);
                if(calculatedScores[i] == 8) win = ifCalculatedScores8(numPlayers);
            }
            if(calculatedScores[i] > largestHand)
            {
                largestHand = calculatedScores[i];
                winningPlayer = i;
                winningPlayersHand = hands[i];
                win = ("Player " + (winningPlayer+1) + " is the winner with " + winningPlayersHand + "!");
            }
        }
        return win;
    }
}
