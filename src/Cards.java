import java.util.ArrayList;

public class Cards {

	//attributes
	private String cardName;
	private String color; // hearts (Herz), diamonds (Caro), clubs (Kreuz), spades (Pik)
	private int value;


	//constructor
	public Cards(String cardName, String color, int value) {
		super();
		this.cardName = cardName;
		this.color = color;
		this.value = value;
	}

	//getter & setter
	public String getCardName() {
		return cardName;
	}


	public String getColor() {
		return color;
	}


	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Cards [cardName=" + cardName + ", color=" + color + ", value=" + value + "]";
	}




	// Show cards
	public void showCards() {
		
		System.out.println(this.getValue() +":" +this.getCardName() + " of " + this.getColor());
		//System.out.println(this.getValue() + " of " + this.getColor());
	}


	// Ass-Funktion
	public int aceFunction(int aceCounter) {

		return 0;
	}

	

	public static void evaluatePointsPlayer(ArrayList<Cards> cards, Players player1, int i0, int i2) {
		int punktePlayer1 = player1.getPoints() + cards.get(i0).getValue();
		player1.setPoints(punktePlayer1);
		punktePlayer1 = player1.getPoints() + cards.get(i2).getValue();
		player1.setPoints(punktePlayer1);
		System.out.println(player1);
	}

	public static void evaluatePointsBank(ArrayList<Cards> cards, Players bank, int i1, int i3) {
		int punkteBank = bank.getPoints() + cards.get(i1).getValue();
		bank.setPoints(punkteBank);
		punkteBank = bank.getPoints() + cards.get(i3).getValue();
		bank.setPoints(punkteBank);
	}


}


	