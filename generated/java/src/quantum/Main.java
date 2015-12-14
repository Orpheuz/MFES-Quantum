package quantum;

import java.util.Scanner;

import quantum.quotes.Player1WonQuote;
import quantum.quotes.PlayingQuote;
import quantum.quotes.WhiteQuote;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = initialMenu(input);
		Quantum game = null;
		switch(choice) {
		case 1:
			game = new Quantum(false);
			break;
		case 2:
			game = new Quantum(true);
			break;
		case 3:
			return;
		default:
			game = new Quantum(false);
		}
		game.startGame();
		boolean bigBoard = Board.getInstance().isBigBoard();
		printBoard(bigBoard);
		while(game.getGameState() == PlayingQuote.getInstance()) {
			String[] coordI = getCoordinates(true, input);
			String[] coordF = getCoordinates(false, input);
			if(!game.movePieceTo(Integer.parseInt(coordI[1]), Integer.parseInt(coordI[0]), 
					Integer.parseInt(coordF[1]), Integer.parseInt(coordF[0])))
				System.out.println("Movimento inválido");
			game.endTurn();
			game.updateGameState();
			printBoard(bigBoard);
		}

		if(game.getGameState() == Player1WonQuote.getInstance())
			gameOverMessage("Player 1");
		else gameOverMessage("Player 2");
	}
	
	private static int initialMenu(Scanner input) {
		System.out.println("1 - Start game with 10x6 board");
		System.out.println("2 - Start game with 12x8 board");
		System.out.println("3 - Exit game");
		return Integer.parseInt(input.nextLine());
	}
	
	private static void gameOverMessage(String winner) {
		System.out.println("");
		System.out.println("#########################################");
		System.out.println("#########################################");
		System.out.println("#########################################");
		System.out.println("###########                 #############");
		System.out.println("###########  " + winner + " WON!  #############");
		System.out.println("###########                 #############");
		System.out.println("#########################################");
		System.out.println("#########################################");
		System.out.println("#########################################");
		System.out.println("");
	}
	
	private static void printBoard(boolean bigBoard) {
		double x = 0, y = 0;
		if(bigBoard) {
			x = Board.bigSizeX;
			y = Board.bigSizeY;
		}
		else {
			x = Board.smallSizeX;
			y = Board.smallSizeY;
		}
		
		System.out.println("");
		for(int i = 1; i < y + 1; i++) {
			for(int j = 1; j < x + 1; j++) {
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
			if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
				return "| WO |";
			else return "| BO |";
		}
		if(p instanceof Cross) {
			if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
				return "| W+ |";
			else return "| B+ |";
		}
		if(p instanceof Square) {
			if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
				return "| WS |";
			else return "| BS |";
		}
		if(p instanceof Tower) {
			Piece tPiece = p.getTopPiece();
			if(tPiece instanceof Circle) {
				if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
					return "|TWO" + p.getSize() + "|";
				else return "|TBO" + p.getSize() + "|";
			}
			if(tPiece instanceof Cross) {
				if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
					return "|TW+" + p.getSize() + "|";
				else return "|TB+" + p.getSize() + "|";
			}
			if(tPiece instanceof Square) {
				if(p.pieceOfPlayer.equals(WhiteQuote.getInstance()))
					return "|TWS" + p.getSize() + "|";
				else return "|TBS" + p.getSize() + "|";
			}
		}
		return "0";
	}
	
	private static String[] getCoordinates(boolean init, Scanner input) {
		String[] result = new String[2];
		if(init)
			System.out.println("Introduzir coordenada X da peça: ");
		else System.out.println("Introduzir coordenada X final: ");
		
		result[0] = input.nextLine();
		if(init)
			System.out.println("Introduzir coordenada Y da peça: ");
		else System.out.println("Introduzir coordenada Y final: ");
		result[1] = input.nextLine();
		return result;
	}

}