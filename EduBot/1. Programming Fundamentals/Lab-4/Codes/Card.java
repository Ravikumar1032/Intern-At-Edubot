import java.util.Random;

public class Card {
    private int suit;
    private int faceValue;

    public Card(int suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String toString() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faceValues = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        return faceValues[faceValue] + " of " + suits[suit];
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomSuit = random.nextInt(4);
            int randomFaceValue = random.nextInt(13);
            Card card = new Card(randomSuit, randomFaceValue);
            System.out.println("Card " + (i + 1) + ": " + card);
        }
    }
}