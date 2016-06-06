
public class Cell {
	private CellType cellType;
	private Player player;
	public boolean verif = false;
	
	public CellType getCellType() {
		return cellType;
	}

	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}
	void display(double i, double j) {
		switch (cellType) {
		case MAGENTA:
			StdDraw.setPenColor(StdDraw.MAGENTA);
			StdDraw.filledSquare(i,j,0.5);
			break;
		case BLUE:
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledSquare(i,j,0.5);
			break;
		case RED:
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledSquare(i,j,0.5);
			break;
		case YELLOW:
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledSquare(i,j,0.5);
			break;
		case ORANGE:
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledSquare(i,j,0.5);
			break;
		case GREEN:
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledSquare(i,j,0.5);
			break;
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

}