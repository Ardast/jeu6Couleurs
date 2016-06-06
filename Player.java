public enum Player {
		Player1, Player2, Player3, Player4, IA1, IA2, IA3, IA4, none;

		private CellType cellType;
		public boolean game = false;
		
		public CellType getCellType() {
			return cellType;
		}

		public void setCellType(CellType cellType) {
			this.cellType = cellType;			
		}

		public static void nextPlayer(int nbPlayer, int nbIA) {
			if(nbPlayer == 0) {
				if(nbIA == 2) {
					if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.IA2.game = false;
						Player.IA1.game = true;
					}
				}
				else if(nbIA == 3) {
					if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.IA3.game = true;
						Player.IA2.game = false;
					}
					else if(Player.IA3.game == true) {
						Player.IA1.game = true;
						Player.IA3.game = false;
					}
				}
				else if(nbIA == 4) {
					if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.IA3.game = true;
						Player.IA2.game = false;
					}
					else if(Player.IA3.game == true) {
						Player.IA4.game = true;
						Player.IA3.game = false;
					}
					else if(Player.IA4.game == true) {
						Player.IA1.game = true;
						Player.IA4.game = false;
					}
				}
			}
			else if(nbPlayer == 1){
				if(nbIA == 1) {
					if(Player.Player1.game == true) {
						Player.IA1.game = true;
						Player.Player1.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.Player1.game = true;
						Player.IA1.game = false;
					}
				}
				else if(nbIA ==2) {
					if(Player.Player1.game == true) {
						Player.IA1.game = true;
						Player.Player1.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.Player1.game = true;
						Player.IA2.game = false;
					}
				}
				else if (nbIA == 3) {
					if(Player.Player1.game == true) {
						Player.IA1.game = true;
						Player.Player1.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.IA3.game = true;
						Player.IA2.game = false;
					}
					else if(Player.IA3.game == true) {
						Player.Player1.game = true;
						Player.IA3.game = false;
					}
				}
			}
			else if(nbPlayer == 2) {
				if(nbIA == 0){
					if(Player.Player1.game == true) {
						Player.Player2.game = true;
						Player.Player1.game = false;
					}
					else if(Player.Player2.game == true) {
						Player.Player1.game = true;
						Player.Player2.game = false;
					}
				}
				else if(nbIA == 1) {
					if(Player.Player1.game == true) {
						Player.Player2.game = true;
						Player.Player1.game = false;
					}
					else if(Player.Player2.game == true) {
						Player.IA1.game = true;
						Player.Player2.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.Player1.game = true;
						Player.IA1.game = false;
					}
				}
				else if(nbIA == 2) {
					if(Player.Player1.game == true) {
						Player.Player2.game = true;
						Player.Player1.game = false;
					}
					else if(Player.Player2.game == true) {
						Player.IA1.game = true;
						Player.Player2.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.IA2.game = true;
						Player.IA1.game = false;
					}
					else if(Player.IA2.game == true) {
						Player.Player1.game = true;
						Player.IA2.game = false;
					}
				}
			}
			else if(nbPlayer == 3) {
				if(nbIA == 0) {
					if(Player.Player1.game == true) {
						Player.Player2.game = true;
						Player.Player1.game = false;
					}
					else if(Player.Player2.game == true) {
						Player.Player3.game = true;
						Player.Player2.game = false;
					}
					else if(Player.Player3.game == true) {
						Player.Player1.game = true;
						Player.Player3.game = false;
					}
				}
				else if(nbIA == 1) {
					if(Player.Player1.game == true) {
						Player.Player2.game = true;
						Player.Player1.game = false;
					}
					else if(Player.Player2.game == true) {
						Player.Player3.game = true;
						Player.Player2.game = false;
					}
					else if(Player.Player3.game == true) {
						Player.IA1.game = true;
						Player.Player3.game = false;
					}
					else if(Player.IA1.game == true) {
						Player.Player1.game = true;
						Player.IA1.game = false;
					}
				}
			}
			else if(nbPlayer == 4) {
				if(Player.Player1.game == true) {
					Player.Player2.game = true;
					Player.Player1.game = false;
				}
				else if(Player.Player2.game == true) {
					Player.Player3.game = true;
					Player.Player2.game = false;
				}
				else if(Player.Player3.game == true) {
					Player.Player4.game = true;
					Player.Player3.game = false;
				}
				else if(Player.Player4.game == true) {
					Player.Player1.game = true;
					Player.Player4.game = false;
				}
			}
		}
}