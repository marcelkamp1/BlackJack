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

		// Kartendeklaration
		String[] nameValue = new String[] { "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"jack", "queen", "king", "ace" };
		String[] playColors = new String[] { "Hearts", "Diamonds", "Clubs", "Spades" };
		int[] values = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1 };

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

		Players bank = new Players("Dealer", 0);
		Players player1 = new Players(name, 0);

		// Mische Karten:
		Collections.shuffle(cards);

		// Karten austeilen und Karten zeigen
		System.out.println("Karten von Spieler 1:");
		cards.get(0).showCards();
		if(cards.get(0).getCardName().equals("ace"))
			aceCounterPlayer++;
		cards.get(2).showCards();
		if(cards.get(2).getCardName().equals("ace"))
			aceCounterPlayer++;

		System.out.println();
		System.out.print("Karte der Bank: ");
		cards.get(1);
		if(cards.get(1).getCardName().equals("ace"))
			aceCounterBank++;
		cards.get(3).showCards();
		if(cards.get(3).getCardName().equals("ace"))
			aceCounterBank++;

		// addieren der Werte
		aceAmount.aceAmountPlayer(aceCounterPlayer, player1);
		evaluatePointsPlayer(cards, player1, 0, 2);

		// addiere Bank-Werte
		evaluatePointsBank(cards, bank, 1, 3);

		// Abfrage, ob ein BlackJack vorliegt
		if (player1.getPoints() == 21 && bank.getPoints() != 21) {
			System.out.println("BlackJack " + player1.getPlayerName());
		} else if (bank.getPoints() == 21) {
			System.out.println("BlackJack " + bank.getPlayerName());
		} else {
			// Will Spieler Karte?
			//System.out.println("Ace counter Bank: " + aceCounterBank);
			//System.out.println("Ace counter Player: " + aceCounterPlayer);
						
			while (sCardDraw) {
				System.out.printf("%s, wollen Sie noch eine Karte? ", player1.getPlayerName());
				String jaNein = scanner.nextLine();
				if (jaNein.equals("Ja") || jaNein.equals("ja")) {
					System.out.print("+ eine Karte -->   ");
					deckCounter++;
					cards.get(deckCounter).showCards();
					if(cards.get(deckCounter).getCardName().equals("ace"))
						aceCounterPlayer++;;
					int punktePlayer1 = player1.getPoints() + cards.get(deckCounter).getValue();
					player1.setPoints(punktePlayer1);
					
					System.out.println("-------------------------------------------");
					
					aceAmount.aceAmountPlayer(aceCounterPlayer, player1);
					if (player1.getPoints() > 21) {
						System.out.println("Sie haben mit " + player1.getPoints() + " Punkten verloren.");
						return;
					}
					System.out.println(player1);

				} else {
					sCardDraw = false;
				}

			}
			// Bank am Zug inkl Berechnung
			System.out.println("Hier kommt die Bank...");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("Dies ist die zweite Karte der Bank: ");
			
			cards.get(1).showCards();
			//aceAmount.aceAmountBank(aceCounterBank, bank);
			System.out.println("Die Bank hat im Augenblick folgende Punkte: " +bank.getPoints());
				
			do {
				if ((bank.getPoints()) >= 17 && (bank.getPoints() <= 21)) {
					System.out.println("Bank hat " + bank.getPoints() + " Punkte und stoppt!");
				} else {
					cards.get(deckCounter).showCards();
					
					if(cards.get(deckCounter).getCardName().equals("ace"))
						aceCounterBank++;
					
					bank.setPoints(bank.getPoints() + cards.get(deckCounter).getValue());
					aceAmount.aceAmountBank(aceCounterBank, bank);
					
					deckCounter++;
					
					//System.out.println(deckCounter + " DeckCounter");
					System.out.println("Neuer Wert der Karten: " + bank.getPoints());
					
					System.out.println("Bank hat " + bank.getPoints() + " Punkte!");
				}
				
			} while (bank.getPoints() < 17);
		
		
			
			
			// Auswertung
			if ((bank.getPoints())>21 || (player1.getPoints() > bank.getPoints()) && player1.getPoints() <= 21) {
				System.out.println(player1.getPlayerName() + " wins!");
			} else if ((bank.getPoints() > player1.getPoints()) && bank.getPoints() <= 21) {
				System.out.println(bank.getPlayerName() + " wins with: " + bank.getPoints() + " points!");
			} else {
				System.out.println("Gleichstand: Keiner gewinnt!");}
		}
	}


}
