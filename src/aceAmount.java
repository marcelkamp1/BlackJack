import java.util.ArrayList;

public interface aceAmount {
	
	public static void aceAmountBank(int aceCounterBank, Players bank) {
				
		if (bank.getPoints() <= 11 && aceCounterBank > 0) {
			System.out.println("Bank-Wert 11 oder kleiner und ein Ass");
			bank.setPoints(bank.getPoints() + 10);
		}
		else if (bank.getPoints() > 21 && aceCounterBank > 0) {
			bank.setPoints(bank.getPoints() - 10);
		}
		else {
			bank.setPoints(bank.getPoints());
		}

	}
		
	public static void aceAmountPlayer(int aceCounterPlayer, Players player1) {
		if (player1.getPoints() <= 11 && aceCounterPlayer > 0) {
			System.out.println("Player1 Wert 11 oder kleiner und ein Ass");
			player1.setPoints(player1.getPoints() + 10);
		} 
		if (player1.getPoints() > 21 && aceCounterPlayer > 0) {
			player1.setPoints(player1.getPoints() - 10);
		}
		/*
		 * Info für Marcel ;-)
		 * 
		 * 
		 * 1. Wir bewerten die Asse erst einmal NUR mit dem Wert 1 (eins)
		 * 2. Dann ermitteln wir die Gesamtsumme
		 * 3. Ist die Gesamtsumme > 21 geben wir die Summe zurück (als den Wert über 21) und einer hat verloren...k
		 * 4. ist die Gesamtsumme <=11 (mit mit einem Ass), dann addiere 10
		 * 
		 * 
		 */
			
	
	}
}
