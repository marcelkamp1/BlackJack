
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

		System.out.println(this.getValue() + " of " + this.getColor());
	}
	

	// Ass-Funktion
	public int aceFunction(int aceCounter) {
		
		return 0;
	}
	
	
	
	
}


	