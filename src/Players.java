
public class Players {

	//attributes
		private String playerName;
		private int amountOfCards;
		private int points;
		//private int winsOfGames;
		
		
		//constructor
		public Players(String playerName, int points) {
			super();
			this.playerName = playerName;
			this.points = points;
		}
		
			
		@Override
		public String toString() {
			return playerName + " hat " + points + " Punkte auf der Hand";
		}


		//getter & setter
		public String getPlayerName() {
			return playerName;
		}


		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}


		public int getAmountOfCards() {
			return amountOfCards;
		}


		public void setAmountOfCards(int amountOfCards) {
			this.amountOfCards = amountOfCards;
		}


		public int getPoints() {
			return points;
		}


		public void setPoints(int points) {
			this.points = points;
		}
			
		
		
		
		
		
	
	
	
	
}
