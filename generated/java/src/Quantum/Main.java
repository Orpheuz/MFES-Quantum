package quantum;

public class Main {

	public static void main(String[] args) {
		Quantum game = new Quantum(false);
		
		for(int i = 1; i < Board.smallSizeY + 1 ; i++) {
			for(int j = 1; j < Board.smallSizeX + 1 ; j++) {
				if(Board.getInstance().getTile(i, j).getPiece() != null)
					System.out.print(" P ");
				else System.out.print
				(" - ");
			}
			System.out.println("");
		}
	}
	
	private String getPieceString(Piece p) {
		return "";
	}

}