import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PlayGround extends Cards implements aceAmount {

	public PlayGround(String cardName, String color, int value) {
		super(cardName, color, value);
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int deckCounter = 4;
		int aceCounterPlayer = 0;
		int aceCounterBank = 0;
		boolean sCardDraw = true;



		// Generiere Spieler
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geben Sie Ihren Namen ein: ");
		String name = scanner.nextLine();



		Players bank = new Players("Dealer", 0);
		Players player1 = new Players(name, 0);

		// Kartendeklaration
		String[] nameValue = new String[]{"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"jack", "queen", "king", "ace"};
		String[] playColors = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
		int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

		// Kartengenerator
		ArrayList<Cards> cards = new ArrayList<>();
		for (int i = 0; i < playColors.length; i++) {
			for (int j = 0; j < nameValue.length; j++) {
				cards.add(new Cards(nameValue[j], playColors[i], values[j]));
			}
		}

		// Mische Karten:
		Collections.shuffle(cards);

		// Karten austeilen

		// Karten zeigen
		System.out.println("Karten von Spieler 1:");
		cards.get(0).showCards();
		if (cards.get(0).getCardName().equals("ace")) {
			aceCounterPlayer++;
			aceAmount.aceAmountPlayer(aceCounterPlayer, player1);
		}
		cards.get(2).showCards();
		if (cards.get(2).getCardName().equals("ace")) {
			aceCounterPlayer++;
			aceAmount.aceAmountPlayer(aceCounterPlayer, player1);
		}

		System.out.println("Karten von Bank:");
		cards.get(1);
		if (cards.get(1).getCardName().equals("ace"))
			aceCounterBank++;
		cards.get(3).showCards();
		if (cards.get(3).getCardName().equals("ace"))
			aceCounterBank++;

		// addieren der Werte
		evaluatePointsPlayer(cards, player1, 0, 2);

		// addiere Bank-Werte
		evaluatePointsBank(cards, bank, 1, 3);

		// Abfrage, ob ein BlackJack vorliegt
		if (player1.getPoints() == 21 && bank.getPoints() != 21) {
			System.out.println("BlackJack " + player1.getPlayerName());
		} else if (bank.getPoints() == 21) {
			System.out.println("BlackJack " + bank.getPlayerName());
		} else {

			while (sCardDraw) {
				System.out.printf("%s, wollen Sie noch eine Karte? ", player1.getPlayerName());
				String jaNein = scanner.nextLine();
				if (jaNein.equals("Ja") || jaNein.equals("ja")) {
					System.out.println("+ eine Karte!");
					deckCounter++;
					cards.get(deckCounter).showCards();
					if (cards.get(deckCounter).getCardName().equals("ace"))
						aceCounterPlayer++;
					int punktePlayer1 = player1.getPoints() + cards.get(deckCounter).getValue();
					player1.setPoints(punktePlayer1);
					aceAmount.aceAmountPlayer(aceCounterPlayer, player1);
					if (player1.getPoints() > 21) {
						System.out.println("Sie haben mit " + player1.getPoints() + " Punkten verloren.");
						System.out.println("Die Bank gewinnt!");
						return;
					}
					System.out.println(player1);

				} else {
					sCardDraw = false;
				}

			}
			// Bank am Zug inkl Berechnung
			System.out.println("Hier kommt die Bank...");
			cards.get(1).showCards();
			if (cards.get(1).getCardName().equals("ace") || cards.get(3).getCardName().equals("ace")) {
				drawCards(deckCounter, cards, bank, aceCounterBank);

			} else {
				drawCards(deckCounter, cards, bank, aceCounterBank);
				if (bank.getPoints() > 21) {
					System.out.println("Die Bank hat mit " + bank.getPoints() + " Punkten verloren!");
					System.out.println(player1.getPlayerName() + " gewinnt!");

				}

			}

			// Auswertung
			if ((player1.getPoints() > bank.getPoints()) && player1.getPoints() <= 21) {
				System.out.println(player1.getPlayerName() + " wins!");
			} else if ((bank.getPoints() > player1.getPoints()) && bank.getPoints() <= 21) {
				System.out.println(bank.getPlayerName() + " wins!");
			} else if (bank.getPoints() == player1.getPoints())
				System.out.println("Draw!");

		}
		//restartGame aktuell Fehlfunktion
		/*
			System.out.println("Neustart? ja/nein");
			Scanner restart = new Scanner(System.in);
			String answer = restart.nextLine();
			if(!answer.equals("ja"))
				newGame = false;
			 */
		scanner.close();
	}

}

