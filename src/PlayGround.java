import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayGround extends Cards {

	public PlayGround(String cardName, String color, int value) {
		super(cardName, color, value);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int deckCounter = 4;
		int aceCounter = 0;

		// Kartendeklaration
		String[] nameValue = new String[] { "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"jack", "queen", "king", "ace" };
		String[] playColors = new String[] { "Hearts", "Diamonds", "Clubs", "Spades" };
		int[] values = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

		// Kartengenerator
		ArrayList<Cards> cards = new ArrayList<>();
		for (int i = 0; i < playColors.length; i++) {
			for (int j = 0; j < nameValue.length; j++) {
				cards.add(new Cards(nameValue[j], playColors[i], values[j]));
			}
		}

		// Generiere Spieler
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geben Sie Ihren Namen ein: ");
		String name = scanner.nextLine();

		Players bank = new Players("Dealer",  0);
		Players player1 = new Players(name,  0);

		// Mische Karten:
		Collections.shuffle(cards);

		// Karten austeilen

		// Karten zeigen
		System.out.println("Karten von Spieler 1:");
		cards.get(0).showCards();
		cards.get(2).showCards();

		System.out.println("Karten von Bank:");
		cards.get(1);
		cards.get(3).showCards();

		// addieren der Werte
		evaluatePointsPlayer(cards, player1, 0, 2);

		// addiere Bank-Werte
		evaluatePointsBank(cards, bank, 1, 3);

		// Abfrage, ob ein BlackJack vorliegt
		if(player1.getPoints() == 21 && bank.getPoints() != 21){
			System.out.println("BlackJack " + player1.getPlayerName());
		} else if (bank.getPoints() == 21){
			System.out.println("BlackJack " + bank.getPlayerName());
		} else {
			while (true) {
				System.out.printf("%s, wollen Sie noch eine Karte? ", player1.getPlayerName());
				String jaNein = scanner.nextLine();
				if (jaNein.equals("Ja") || jaNein.equals("ja")) {
					System.out.println("+ eine Karte!");
					deckCounter++;
					cards.get(deckCounter).showCards();
					int punktePlayer1 = player1.getPoints() + cards.get(deckCounter).getValue();
					player1.setPoints(punktePlayer1);
					if (player1.getPoints() > 21) {
						System.out.println("Sie haben mit " + player1.getPoints() + " Punkten verloren.");
						break;
					}
					System.out.println(player1);
				}
				System.out.println("Hier kommt die Bank...");
				cards.get(1).showCards();
				if (cards.get(1).getCardName().equals("ace") || cards.get(3).getCardName().equals("ace")) {
					drawCards(deckCounter, cards, bank);
				} else {
					drawCards(deckCounter, cards, bank);
				}
				break;
			}
		}
		if((bank.getPoints()>player1.getPoints())&&bank.getPoints()<=21){
			System.out.println("Bank wins!");
		}
		else if((player1.getPoints()>bank.getPoints())&&player1.getPoints()<=21){
			System.out.println(player1.getPlayerName() + " wins!");
		}
		else{
			System.out.println("Push! - It's a draw!");
		}
	}
}


