import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayGround {

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

		Players bank = new Players("Dealer", 0, 0);
		Players player1 = new Players(name, 0, 0);

		System.out.println(bank);
		System.out.println(player1);

		// Start des Spiels
		// Mische Karten:
		Collections.shuffle(cards);
		// System.out.println(cards);

		// System.out.println(cards.get(51));

		// Karten austeilen

		// Karten zeigen
		System.out.println("Karten von Spieler 1:");
		cards.get(0).showCards();
		cards.get(2).showCards();

		System.out.println("Karten von Bank:");
		cards.get(1);
		cards.get(3).showCards();

		// addieren der Werte
		int punktePlayer1 = player1.getPoints() + cards.get(0).getValue();
		player1.setPoints(punktePlayer1);
		punktePlayer1 = player1.getPoints() + cards.get(2).getValue();
		player1.setPoints(punktePlayer1);
		System.out.println(player1);

		// addiere Bank-Werte
		int punkteBank = bank.getPoints() + cards.get(1).getValue();
		bank.setPoints(punkteBank);
		punkteBank = bank.getPoints() + cards.get(3).getValue();
		bank.setPoints(punkteBank);

		// Abfrage, ob Spieler noch eine Karte will?
		while (true) {
			System.out.printf("%s, wollen Sie noch eine Karte? ", player1.getPlayerName());
			String jaNein = scanner.nextLine();
			if (!jaNein.equals("Ja")) {
				System.out.println("Hier kommt die Bank...");
				cards.get(1).showCards();
				if (cards.get(1).getCardName().equals("ace") || cards.get(3).getCardName().equals("ace")) {
					do {
						if ((bank.getPoints()) >= 17 && (bank.getPoints() <= 21)) {
							System.out.println("Bank hat " + bank.getPoints() + " Punkte!");
						} else {
							cards.get(deckCounter);
							punkteBank = bank.getPoints() + cards.get(deckCounter).getValue();
							bank.setPoints(punkteBank);
							System.out.println("Bank hat " + bank.getPoints() + " Punkte!");
						}
					} while (bank.getPoints() < 17);
				} else {
					do {
					if ((bank.getPoints()) >= 17 && (bank.getPoints() <= 21)) {
						System.out.println("Bank (ohne Ass) " + bank.getPoints() );
						break;
					}
					else {
						cards.get(deckCounter);
						punkteBank = bank.getPoints() + cards.get(deckCounter).getValue();
						bank.setPoints(punkteBank);
						System.out.println("Bank hat " + bank.getPoints() + " Punkte!");
					}
					}while(bank.getPoints() < 17);
				}

				break;
			}
			System.out.println("+ eine Karte!");
			deckCounter++;
			cards.get(deckCounter).showCards();
			punktePlayer1 = player1.getPoints() + cards.get(deckCounter).getValue();
			player1.setPoints(punktePlayer1);
			if (player1.getPoints() > 21) {
				System.out.println("Sie haben verloren mit " + player1.getPoints() + " Punkten.");
				break;
			}
			System.out.println(player1);
		}

	}

}

//		
//int points = cards.
//player1.setPoints(points);
