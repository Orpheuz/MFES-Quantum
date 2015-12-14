package quantum;

import quantum.quotes.Player1Quote;

public class Main {

	public static void main(String[] args) {
		Quantum game = new Quantum(false);
		printBoard();
	}
	
	private static void printBoard() {
		for(int i = 1; i < Board.smallSizeY + 1; i++) {
			for(int j = 1; j < Board.smallSizeX + 1; j++) {
				if(Board.getInstance().getTile(i, j).getPiece() != null)
					System.out.print(getPieceString(Board.getInstance().getTile(i, j).getPiece()));
				else System.out.print
				("| -- |");
			}
			System.out.println("");
		}
	}
	
	private static String getPieceString(Piece p) {
		if(p instanceof Circle) {
			if(p.pieceOfPlayer.equals(Player1Quote.getInstance()))
				return "| WO |";
			else return "| BO |";
		}
		if(p instanceof Cross) {
			if(p.pieceOfPlayer.equals(Player1Quote.getInstance()))
				return "| W+ |";
			else return "| B+ |";
		}
		if(p instanceof Square) {
			if(p.pieceOfPlayer.equals(Player1Quote.getInstance()))
				return "| WC |";
			else return "| BC |";
		}
		if(p instanceof Tower) {
			return "|T" + getPieceString(((Tower) p).getPieceTower());
		}
		return "";
	}

}