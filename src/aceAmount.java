import java.util.Scanner;

public interface aceAmount {
	
	public static void aceAmountBank(int aceCounterBank, Players bank) {

		switch(aceCounterBank){
			case 1:
				if((bank.getPoints()-10)>=17 && (bank.getPoints()-10)<=21)
					bank.setPoints(bank.getPoints()-10);
				else
					bank.setPoints(bank.getPoints());

			case 2:
				if((bank.getPoints()-10)>=17 && (bank.getPoints()-10)<=21)
					bank.setPoints(bank.getPoints()-10);
				else
					bank.setPoints(bank.getPoints());

			case 3:
				if((bank.getPoints()-20)>=17 && (bank.getPoints()-10)<=21)
					bank.setPoints(bank.getPoints()-20);
				else
					bank.setPoints(bank.getPoints());

			case 4:
				if((bank.getPoints()-30)>=17 && (bank.getPoints()-10)<=21)
					bank.setPoints(bank.getPoints()-30);
				else
					bank.setPoints(bank.getPoints());
		}

	}
		
	public static void aceAmountPlayer(int aceCounterPlayer, Players player1) {
		if(aceCounterPlayer > 0){
			System.out.println("Ace count 1 or 11?");
			Scanner choice = new Scanner(System.in);
			int aceValue = choice.nextInt();
			if(aceValue == 1) {
				player1.setPoints(player1.getPoints() - 10);
				aceCounterPlayer--;
			}
			else {
				player1.setPoints(player1.getPoints());
				aceCounterPlayer--;
			}
		}

	}

	}

