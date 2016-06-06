import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Board {
	private final Cell[][] cells;
	private Player player;
	
	
	public Board() {					//Crée le board, et initialise les joueurs
		Scanner sc  = new Scanner(System.in);
		System.out.println("Quelle taille de tableau désirez-vous?");
		int size = sc.nextInt();
		System.out.println("Combien de joueurs humains veulent jouer?");
		int nbJoueurs = sc.nextInt();
		System.out.println("Combien d'IA désirez-vous?");
		int nbIA = sc.nextInt();
		System.out.println("Merci de patienter le temps que votre plateau de jeu soit prêt.");
		StdDraw.setXscale(0,size);
		StdDraw.setYscale(0,size);
		cells = new Cell[size][size];
		boolean condition = false;
		while(!condition){
			for (int i=0; i<cells.length; i++) {
				for (int j=0; j<cells.length; j++) {
					cells[i][j] = new Cell();
					cells[i][j].setCellType(randomColor());
					cells[i][j].setPlayer(Player.none);
				}
			}
			if(nbJoueurs == 0) {
				if(nbIA == 0 || nbIA == 1) {
					System.out.println("Impossible de jouer seul");
					condition = true;
				}
				else if(nbIA == 2) {
					cells[0][0].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[0][0].getCellType());
					cells[size-1][size-1].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[size-1][size-1].getCellType());
					Player.IA1.game = true;
				}
				else if(nbIA == 3) {
					cells[0][0].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[0][0].getCellType());
					cells[size-1][size-1].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[size-1][size-1].getCellType());
					cells[0][size-1].setPlayer(Player.IA3);
					Player.IA3.setCellType(cells[0][size-1].getCellType());
					Player.IA1.game = true;
				}
				else if(nbIA == 4) {
					cells[0][0].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[0][0].getCellType());
					cells[size-1][size-1].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[size-1][size-1].getCellType());
					cells[0][size-1].setPlayer(Player.IA3);
					Player.IA3.setCellType(cells[0][size-1].getCellType());
					cells[size-1][0].setPlayer(Player.IA4);
					Player.IA4.setCellType(cells[size-1][0].getCellType());
					Player.IA1.game = true;
				}
				display();
				game(Player.IA1, nbJoueurs, nbIA);
			}
			else if(nbJoueurs == 1) {
				if(nbIA == 0 ) {
					System.out.println("Impossible de jouer seul");
					condition = true;
					break;
				}
				cells[0][0].setPlayer(Player.Player1);
				Player.Player1.setCellType(cells[0][0].getCellType());
				if(nbIA == 1) {
					cells[size-1][size-1].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[size-1][size-1].getCellType());
					Player.Player1.game = true;
				}
				else if(nbIA == 2) {
					cells[size-1][size-1].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[size-1][size-1].getCellType());
					cells[0][size-1].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[0][size-1].getCellType());
					Player.Player1.game = true;
				}
				else if(nbIA == 3) {
					cells[size-1][size-1].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[size-1][size-1].getCellType());
					cells[0][size-1].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[0][size-1].getCellType());
					cells[size-1][0].setPlayer(Player.IA3);
					Player.IA3.setCellType(cells[size-1][0].getCellType());
					Player.Player1.game = true;
				}
				display();
				game(Player.Player1, nbJoueurs, nbIA);
			}
			else if(nbJoueurs == 2) {
				cells[0][0].setPlayer(Player.Player1);
				Player.Player1.setCellType(cells[0][0].getCellType());
				cells[size-1][size-1].setPlayer(Player.Player2);
				Player.Player2.setCellType(cells[size-1][size-1].getCellType());
				Player.Player1.game = true;
				if(nbIA == 1) {
					cells[0][size-1].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[0][size-1].getCellType());
				}
				else if(nbIA == 2) {
					cells[0][size-1].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[0][size-1].getCellType());
					cells[size-1][0].setPlayer(Player.IA2);
					Player.IA2.setCellType(cells[size-1][0].getCellType());
				}
				else if(nbIA == 3 || nbIA == 4){
					System.out.println("Impossible de jouer à plus de 4 joueurs");
					condition = true;
					break;
				}
				display();
				game(Player.Player1, nbJoueurs, nbIA);
			}
			else if(nbJoueurs == 3){
				cells[0][0].setPlayer(Player.Player1);
				Player.Player1.setCellType(cells[0][0].getCellType());
				cells[size-1][size-1].setPlayer(Player.Player2);
				Player.Player2.setCellType(cells[size-1][size-1].getCellType());
				cells[0][size-1].setPlayer(Player.Player3);
				Player.Player3.setCellType(cells[0][size-1].getCellType());
				Player.Player1.game = true;
				if(nbIA == 1){
					cells[size-1][0].setPlayer(Player.IA1);
					Player.IA1.setCellType(cells[size-1][0].getCellType());
				}
				else if(nbIA == 2 || nbIA == 3 || nbIA == 4){
					System.out.println("Impossible de jouer à plus de 4 joueurs");
					condition = true;
					break;
				}
				display();
				game(Player.Player1, nbJoueurs, nbIA);
			}
			else if(nbJoueurs == 4) {
				cells[0][0].setPlayer(Player.Player1);
				Player.Player1.setCellType(cells[0][0].getCellType());
				cells[size-1][size-1].setPlayer(Player.Player2);
				Player.Player2.setCellType(cells[size-1][size-1].getCellType());
				cells[0][size-1].setPlayer(Player.Player3);
				Player.Player3.setCellType(cells[0][size-1].getCellType());
				cells[size-1][0].setPlayer(Player.Player4);
				Player.Player4.setCellType(cells[size-1][0].getCellType());
				Player.Player1.game = true;
				if(nbIA == 1 || nbIA == 2 || nbIA == 3 || nbIA == 4){
					System.out.println("Impossible de jouer à plus de 4 joueurs");
					condition = true;
					break;
				}
				display();
				game(Player.Player1, nbJoueurs, nbIA);
			}
			else if(nbJoueurs > 4 || nbIA > 4) {
				System.out.println("Impossible de jouer à plus de 4 joueurs");
				condition = true;
				break;
			}
			for (int i=0; i<cells.length; i++) {
				for (int j=0; j<cells.length; j++) {	
					System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
				}
				System.out.println("|");
			}
			condition = true;
			break;
		}
	}
	

	public int getScore(Player player) {			//Obtiens le score du joueur en cours
		int score = 0;
		Cell[][] cells = this.cells;
		for (int i=0; i<cells.length; i++) {
			for (int j=0; j<cells.length; j++) {
				if(cells[i][j].getPlayer() == player) {
					score++;
				}
			}
		}
		return score;
	}
	
	public void dropColors(Player player) {			//permet de jouer au jeu en sélectionnant une case
		if(player.game == true) {
			boolean sortie = false;
			while(!sortie) {
				if((player == Player.Player1 || player == Player.Player2 || player == Player.Player3 || player == Player.Player4)){
					while(!StdDraw.mousePressed()) { }
					int x = (int) StdDraw.mouseX();
					int y = (int) StdDraw.mouseY();
					Cell Clic = cells[cells.length-1-y][x];
					CellType color = Clic.getCellType();
					if(color != Player.Player1.getCellType() && color != Player.Player2.getCellType() && color != Player.Player3.getCellType() && color != Player.Player4.getCellType() && color != Player.IA1.getCellType() && color != Player.IA2.getCellType() && color != Player.IA3.getCellType() && color != Player.IA4.getCellType()) {
						if(Clic.getPlayer() == player) {
							System.out.println("Vous possédez déjà cette case");
						}
						else if(x == 0) {
							if(y == cells.length-1) {
								if(cells[1][0].getPlayer() == player || cells[0][1].getPlayer() == player) {
									Clic.setPlayer(player);
									for (int i=0; i<cells.length; i++) {
										for (int j=0; j<cells.length; j++) {
											if(cells[i][j].getPlayer() == player){
												cells[i][j].setCellType(color);
												player.setCellType(color);
											}
											getVoisins(player);
										}
									}
									displayCells();
									for (int i=0; i<this.cells.length; i++) {
										for (int j=0; j<this.cells.length; j++) {	
											System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
										}
										System.out.println("|");
									}
								} else {
									System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
								}
							}
							else if(y == 0) {
								if(cells[cells.length-2][0].getPlayer() == player || cells[cells.length-1][1].getPlayer() == player) {
									Clic.setPlayer(player);
									for (int i=0; i<cells.length; i++) {
										for (int j=0; j<cells.length; j++) {
											if(cells[i][j].getPlayer() == player){
												cells[i][j].setCellType(color);
												player.setCellType(color);
											}
											getVoisins(player);
										}
									}
									displayCells();
									for (int i=0; i<this.cells.length; i++) {
										for (int j=0; j<this.cells.length; j++) {	
											System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
										}
										System.out.println("|");
									}
								} else {
									System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
								}
							}
							else if(cells[cells.length-y-2][0].getPlayer() == player || cells[cells.length-y][0].getPlayer() == player || cells[cells.length-y-1][1].getPlayer() == player) {
								Clic.setPlayer(player);
								for (int i=0; i<cells.length; i++) {
									for (int j=0; j<cells.length; j++) {
										if(cells[i][j].getPlayer() == player){
											cells[i][j].setCellType(color);
											player.setCellType(color);
										}
										getVoisins(player);
									}
								}
								displayCells();
								for (int i=0; i<this.cells.length; i++) {
									for (int j=0; j<this.cells.length; j++) {	
										System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
									}
									System.out.println("|");
								}
							} else {
								System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
							}
						}
						else if(x == cells.length-1) {
							if(y == cells.length-1) {
								if(cells[1][cells.length-1].getPlayer() == player || cells[0][cells.length-2].getPlayer() == player) {
									Clic.setPlayer(player);
									for (int i=0; i<cells.length; i++) {
										for (int j=0; j<cells.length; j++) {
											if(cells[i][j].getPlayer() == player){
												cells[i][j].setCellType(color);
												player.setCellType(color);
											}
											getVoisins(player);
										}
									}
									displayCells();
									for (int i=0; i<this.cells.length; i++) {
										for (int j=0; j<this.cells.length; j++) {	
											System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
										}
										System.out.println("|");
									}
								} else {
									System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
								}
							}
							else if(y == 0) {
								if(cells[cells.length-1][cells.length-2].getPlayer() == player || cells[cells.length-2][cells.length-1].getPlayer() == player) {
									Clic.setPlayer(player);
									for (int i=0; i<cells.length; i++) {
										for (int j=0; j<cells.length; j++) {
											if(cells[i][j].getPlayer() == player){
												cells[i][j].setCellType(color);
												player.setCellType(color);
											}
											getVoisins(player);
										}
									}
									displayCells();
									for (int i=0; i<this.cells.length; i++) {
										for (int j=0; j<this.cells.length; j++) {	
											System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
										}
										System.out.println("|");
									}
								} else {
									System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
								}
							}
							else if(cells[cells.length-y][cells.length-1].getPlayer() == player || cells[cells.length-y-2][cells.length-1].getPlayer() == player || cells[cells.length-1-y][cells.length-2].getPlayer() == player) {
								Clic.setPlayer(player);
								for (int i=0; i<cells.length; i++) {
									for (int j=0; j<cells.length; j++) {
										if(cells[i][j].getPlayer() == player){
											cells[i][j].setCellType(color);
											player.setCellType(color);
										}
										getVoisins(player);
									}
								}
								displayCells();
								for (int i=0; i<this.cells.length; i++) {
									for (int j=0; j<this.cells.length; j++) {	
										System.out.print("|" + CellTypeToString(cells[this.cells.length-1-i][j].getCellType(), cells[this.cells.length-1-i][j].getPlayer()));
									}
									System.out.println("|");
								}
							} else {
								System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
							}
						}
						else if(y == 0) {
							if(cells[cells.length-1][x+1].getPlayer() == player || cells[cells.length-1][x-1].getPlayer() == player || cells[cells.length-2][x].getPlayer() == player) {
								Clic.setPlayer(player);
								for (int i=0; i<cells.length; i++) {
									for (int j=0; j<cells.length; j++) {
										if(cells[i][j].getPlayer() == player){
											cells[i][j].setCellType(color);
											player.setCellType(color);
										}
										getVoisins(player);
									}
								}
								displayCells();
								for (int i=0; i<this.cells.length; i++) {
									for (int j=0; j<this.cells.length; j++) {	
										System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
									}
									System.out.println("|");
								}
							} else {
								System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
							}
						}
						else if(y == cells.length-1) {
							if(cells[0][x+1].getPlayer() == player || cells[0][x-1].getPlayer() == player || cells[1][x].getPlayer() == player) {
								Clic.setPlayer(player);
								for (int i=0; i<cells.length; i++) {
									for (int j=0; j<cells.length; j++) {
										if(cells[i][j].getPlayer() == player){
											cells[i][j].setCellType(color);
											player.setCellType(color);
										}
										getVoisins(player);
									}
								}
								displayCells();
								for (int i=0; i<this.cells.length; i++) {
									for (int j=0; j<this.cells.length; j++) {	
										System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
									}
									System.out.println("|");
								}
							} else {
								System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
							}
						}
						else {
							if(cells[cells.length-y-2][x].getPlayer() == player || cells[cells.length-1-y][x+1].getPlayer() == player ||cells[cells.length-y][x].getPlayer() == player || cells[cells.length-1-y][x-1].getPlayer() == player) {
								Clic.setPlayer(player);
								for (int i=0; i<cells.length; i++) {
									for (int j=0; j<cells.length; j++) {
										if(cells[i][j].getPlayer() == player){
											cells[i][j].setCellType(color);
											player.setCellType(color);
										}
										getVoisins(player);
									}
								}
								displayCells();
								for (int i=0; i<this.cells.length; i++) {
									for (int j=0; j<this.cells.length; j++) {	
										System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
									}
									System.out.println("|");
								}
							} else {
								System.out.println("Impossible de sélectionner une couleur non adjacente à la vôtre");
							}
						}
						System.out.println("["+ x + "]" + "[" + y + "] is " + Clic.getCellType());
						while(StdDraw.mousePressed()) { }
						System.out.println("Votre score est de " + getScore(player) + ".");
						sortie = true;	
					}
					else {
						System.out.println("Vous ne pouvez pas choisir la même couleur qu'un adversaire");
					}
					// Jeu de l'IA simple
				} else if (player == Player.IA1 || player == Player.IA2 || player == Player.IA3 || player == Player.IA4){
					ArrayList<CellType> possibleChoice = new ArrayList<CellType>();// Liste où seront stocké les couleurs que les IA pourrons choisir
					ArrayList<Integer> xScale = new ArrayList<Integer>();// Liste des coordonées sur x
					ArrayList<Integer> yScale = new ArrayList<Integer>();// Liste des coordonées sur y
					for (int i = 0; i < cells.length; i++) {
						for (int j = 0; j < cells.length; j++) {
							if (cells[i][j].getPlayer() != player) {//si la cellule visité n'appartient pas au joueur actuel
								if(i!=0 && i!= cells.length-1 && j!=0 && j!= cells.length-1){//cas non litigieux
									//nous allons regarder si les voisins de cette cellule lui appartient afin de savoir s'il peut ou non choisir cette case
									if (cells[i-1][j].getPlayer() == player || cells[i+1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
										possibleChoice.add(cells[i][j].getCellType());
										xScale.add(i);
										yScale.add(j);
									} 
								} else if(i==0){
									if (j==0) {//cas de la première cellule en haut à gauche
										if (cells[i+1][j].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									} else if (j==cells.length-1) {//cas de la cellule en haut à droite
										if (cells[i+1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									} else {// autre cas de cellule appartenant à la première ligne
										if (cells[i+1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									}
								} else if(j==0){
									if (i==0) {//cas de la première cellule en haut à gauche, déjà traitée
										
									} else if (i==cells.length-1) {//cas de la cellule en bas à gauche
										if (cells[i-1][j].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									}  else {// autre cas de cellule appartenant à la première colonne
										if (cells[i-1][j].getPlayer() == player || cells[i+1][j].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									}
								} else if(i==cells.length-1){
									if (j==cells.length-1) {//cas de la cellule en bas à droite
										if (cells[i-1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									} else {// autre cas de cellule appartenant à la dernière ligne
										if (cells[i-1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player || cells[i][j+1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);									
										} 
									}
								} else if(j==cells.length-1){
									if (i==cells.length-1) {
										//cas de la cellule en bas à droite, déjà traitée
									} else {// autre cas de cellule appartenant à la dernière ligne
										if (cells[i-1][j].getPlayer() == player || cells[i+1][j].getPlayer() == player || cells[i][j-1].getPlayer() == player) {
											possibleChoice.add(cells[i][j].getCellType());
											xScale.add(i);
											yScale.add(j);
										} 
									}
								}
								
							}
						}						
					}
					boolean ok = false;//condition d'arret de la boucle qui suit
					int stop = 0;
					while(ok == false && stop <=8){//l'IA va choisit une couleur au hasard parmis ses choix disponibles
						Random choice = new Random();//si la couleur appartient à l'adversaire, elle recommence, d'où le booléen.
						int playIA = choice.nextInt(possibleChoice.size()-1);//si l'IA est entourée de couleurs adverses, elle entre dans une boucle sans fin
						CellType color = possibleChoice.get(playIA);//pour éviter la boucle sans fin, nous avons ajouté un compteur dans les conditions (voir ligne 519)
						if (color != Player.Player1.getCellType() && color != Player.Player2.getCellType() && color != Player.Player3.getCellType() && color != Player.Player4.getCellType() && color != Player.IA1.getCellType() && color != Player.IA2.getCellType() && color != Player.IA3.getCellType() && color != Player.IA4.getCellType()) {
							ok = true;// la couleur est disponible !
							player.setCellType(color);// il faut maintenant recolorier toutes les cases
							cells[xScale.get(playIA)][yScale.get(playIA)].setPlayer(player);
							for (int i=0; i<cells.length; i++) {
								for (int j=0; j<cells.length; j++) {
									if(cells[i][j].getPlayer() == player){
										cells[i][j].setCellType(color);
										player.setCellType(color);
									}
									getVoisins(player);
								}
							}
						}
						stop++;// afin d'éviter la boucle sans fin, noun donnons 10 chances à l'IA de générer une couleur disponible, sinon son tour est sauté
					}
					displayCells();
					for (int i=0; i<this.cells.length; i++) {//afichage du plateau de jeu sur la console
						for (int j=0; j<this.cells.length; j++) {	
							System.out.print("|" + CellTypeToString(cells[i][j].getCellType(), cells[i][j].getPlayer()));
						}
						System.out.println("|");
					}
					System.out.println("Le score de " + player + " est de " + getScore(player) + ".");
					sortie = true;	
				}
			}
		}
	}
	
	public void game(Player player, int nbJoueurs, int nbIA) {
		if(getScore(player) > (this.cells.length * this.cells.length)/(2)) {
			System.out.println(player + " a gagné la partie avec " + getScore(player) + " points !");
		} else {
			dropColors(player);
			Player.nextPlayer(nbJoueurs, nbIA);
			Player[] players = Player.values();
			player.game = false;
			for(int i = 0; i < players.length; i++)
				if(players[i].game == true) {
					System.out.println(players[i]);
					game(players[i], nbJoueurs, nbIA);
				}
		}
	}
	public void getVoisins(Player player) {	// Obtiens tous les voisins du territoire du joueur  et donne l’appartenance au joueur des cellules  de la même couleur que la couleur de la cellule
		Cell[][] cells = this.cells;
		for (int i=0; i<this.cells.length; i++) {
			for (int j=0; j<this.cells.length; j++) {
				if(cells[i][j].getPlayer() == player){
					if(cells[i][j].verif == false){
						cells[i][j].verif = true;
						if(i == 0){
							if(j == 0){
								if(cells[0][1].getCellType() == cells[i][j].getCellType()){
									cells[0][1].setPlayer(player);
								}
								if(cells[1][0].getCellType() == cells[i][j].getCellType()){
									cells[1][0].setPlayer(player);
								}
							} else if(j == cells.length-1) {
								if(cells[0][cells.length-2].getCellType() == cells[i][j].getCellType()){
									cells[0][cells.length-2].setPlayer(player);
								}
								if(cells[1][cells.length-1].getCellType() == cells[i][j].getCellType()){
									cells[1][cells.length-1].setPlayer(player);
								}
							} else {
								if(cells[0][j-1].getCellType() == cells[i][j].getCellType()){
									cells[0][j-1].setPlayer(player);
								}
								if(cells[0][j+1].getCellType() == cells[i][j].getCellType()){
									cells[0][j+1].setPlayer(player);
								}
								if(cells[1][j].getCellType() == cells[i][j].getCellType()){
									cells[1][j].setPlayer(player);
								}
							}
						} else if(i == cells.length-1) {
							if(j == 0) {
								if(cells[cells.length-1][1].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-1][1].setPlayer(player);
								}
								if(cells[cells.length-2][0].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-2][0].setPlayer(player);
								}
							} else if(j == cells.length-1) {
								if(cells[cells.length-1][cells.length-2].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-1][cells.length-2].setPlayer(player);
								}
								if(cells[cells.length-2][cells.length-1].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-2][cells.length-1].setPlayer(player);
								}
							} else {
								if(cells[cells.length-1][j-1].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-1][j-1].setPlayer(player);
								}
								if(cells[cells.length-1][j+1].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-1][j+1].setPlayer(player);
								}
								if(cells[cells.length-2][j].getCellType() == cells[i][j].getCellType()){
									cells[cells.length-2][j].setPlayer(player);
								}
							}
						} else if(j == 0){
							if(cells[i-1][0].getCellType() == cells[i][j].getCellType()){
								cells[i-1][0].setPlayer(player);
							}
							if(cells[i+1][0].getCellType() == cells[i][j].getCellType()){
								cells[i+1][0].setPlayer(player);
							}
							if(cells[i][1].getCellType() == cells[i][j].getCellType()){
								cells[i][1].setPlayer(player);
							}
						} else if(j == cells.length-1) {
							if(cells[i-1][cells.length-1].getCellType() == cells[i][j].getCellType()){
								cells[i-1][cells.length-1].setPlayer(player);
							}
							if(cells[i+1][cells.length-1].getCellType() == cells[i][j].getCellType()){
								cells[i+1][cells.length-1].setPlayer(player);
							}
							if(cells[i][cells.length-2].getCellType() == cells[i][j].getCellType()){
								cells[i][cells.length-2].setPlayer(player);
							}
						} else {
							if(cells[i+1][j].getCellType() == cells[i][j].getCellType()){
								cells[i+1][j].setPlayer(player);
							}
							if(cells[i-1][j].getCellType() == cells[i][j].getCellType()){
								cells[i-1][j].setPlayer(player);
							}
							if(cells[i][j+1].getCellType() == cells[i][j].getCellType()){
								cells[i][j+1].setPlayer(player);
							}
							if(cells[i][j-1].getCellType() == cells[i][j].getCellType()){
								cells[i][j-1].setPlayer(player);
							}
						}
					}
					cells[i][j].verif = false;
				}}}
	}
	
	public CellType randomColor() {			//Crée une mise en forme random des couleurs de la grille
		CellType[] color = CellType.values();
		Random generator = new Random();
		return color[generator.nextInt(color.length)];
	}
	
	public String CellTypeToString(CellType color, Player player) {		//Board sur console
		String result = "not set";
		switch (color) {
		case RED:
			switch (player) {
			case Player1:
				result = "R";
				break;
			case Player2:
				result = "R";
				break;
			case Player3:
				result = "R";
				break;
			case Player4:
				result = "R";
				break;
			case IA1:
				result = "R";
				break;
			case IA2:
				result = "R";
				break;
			case IA3:
				result = "R";
				break;
			case none:
				result = "r";
				break;
			}
			break;
		case GREEN:
			switch (player) {
			case Player1:
				result = "V";
				break;
			case Player2:
				result = "V";
				break;
			case Player3:
				result = "V";
				break;
			case Player4:
				result = "V";
				break;
			case IA1:
				result = "V";
				break;
			case IA2:
				result = "V";
				break;
			case IA3:
				result = "V";
				break;
			case none:
				result = "v";
				break;
			}
			break;
		case BLUE:
			switch (player) {
			case Player1:
				result = "B";
				break;
			case Player2:
				result = "B";
				break;
			case Player3:
				result = "B";
				break;
			case Player4:
				result = "B";
				break;
			case IA1:
				result = "B";
				break;
			case IA2:
				result = "B";
				break;
			case IA3:
				result = "B";
				break;
			case none:
				result = "b";
				break;
			}
			break;
		case YELLOW:
			switch (player) {
			case Player1:
				result = "J";
				break;
			case Player2:
				result = "J";
				break;
			case Player3:
				result = "J";
				break;
			case Player4:
				result = "J";
				break;
			case IA1:
				result = "J";
				break;
			case IA2:
				result = "J";
				break;
			case IA3:
				result = "J";
				break;
			case none:
				result = "j";
				break;
			}
			break;
		case ORANGE:
			switch (player) {
			case Player1:
				result = "O";
				break;
			case Player2:
				result = "O";
				break;
			case Player3:
				result = "O";
				break;
			case Player4:
				result = "O";
				break;
			case IA1:
				result = "O";
				break;
			case IA2:
				result = "O";
				break;
			case IA3:
				result = "O";
				break;
			case none:
				result = "o";
				break;
			}
			break;
		case MAGENTA:
			switch (player) {
			case Player1:
				result = "I";
				break;
			case Player2:
				result = "I";
				break;
			case Player3:
				result = "I";
				break;
			case Player4:
				result = "I";
				break;
			case IA1:
				result = "I";
				break;
			case IA2:
				result = "I";
				break;
			case IA3:
				result = "I";
				break;
			case none:
				result = "i";
				break;
			}
			break;
		}

		return result;

	}
		
	private void displayCells() {			//permet de créer les entitées cells[][] et de les colorer
		for (int i=0; i<cells.length; i++) {
			for (int j=0; j<cells.length; j++) {
				cells[i][j].display(j+0.5,cells.length-1-i+0.5);
			}
		}
	}
	
	void display() {						//Crée la grille
		StdDraw.setPenRadius(0.001);
		for(int i=0; i<cells.length; i++){
			displayCells();
		}

	}

}