package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class MovementTest extends QuantumTest {
    public MovementTest() {
    }

    public void testCanMoveto_Circle() {
        Piece p = new Circle();
        Tile t = new Tile(3L, 3L, p, false);
        Tile t2 = new Tile(2L, 2L, false);
        Tile t3 = new Tile(4L, 2L, false);
        Tile t4 = new Tile(5L, 5L, false);
        Tile t5 = new Tile(3L, 4L, false);
        Tile t6 = new Tile(2L, 3L, false);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(false, p.canMoveTo(t, t6));
        super.assertEqual(false, p.canMoveTo(t, t5));
        super.assertEqual(false, p.canMoveTo(t, t4));
    }

    public void testCanMoveto_Square() {
        Piece p = new Square();
        Tile t = new Tile(2L, 2L, p, false);
        Tile t2 = new Tile(1L, 2L, false);
        Tile t3 = new Tile(2L, 3L, false);
        Tile t4 = new Tile(2L, 6L, false);
        Tile t5 = new Tile(3L, 3L, false);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(false, p.canMoveTo(t, t5));
        super.assertEqual(false, p.canMoveTo(t, t4));
    }

    public void testCanMoveto_Cross() {
        Piece p = new Cross();
        Tile t = new Tile(2L, 2L, p, false);
        Tile t2 = new Tile(1L, 2L, false);
        Tile t3 = new Tile(2L, 3L, false);
        Tile t4 = new Tile(3L, 1L, false);
        Tile t5 = new Tile(1L, 1L, false);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(true, p.canMoveTo(t, t4));
        super.assertEqual(true, p.canMoveTo(t, t5));
    }

    public void testCanMoveto_TowerCircle() {
        Board board = Board.getInstance();
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.BlackQuote.getInstance(), p,
                SeqUtil.seq(p2));
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Tile tl1 = new Tile(4L, 4L, t, false);
        Tile tl2 = new Tile(4L, 3L, false);
        Tile tl3 = new Tile(4L, 2L, false);
        Tile tl4 = new Tile(3L, 3L, false);
        Tile tl5 = new Tile(2L, 2L, false);
        Tile tl6 = new Tile(1L, 1L, false);
        super.assertEqual(false, t.checkPiecesMiddle(tl1, tl2));
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        t.capturePiece(p3);
        super.assertEqual(3L, t.getSize());
        super.assertEqual(false, t.canMoveTo(tl1, tl2));
        super.assertEqual(false, t.canMoveTo(tl1, tl3));
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
    }

    public void testCanMoveto_TowerSquare() {
        Board board = Board.getInstance();
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p3,
                SeqUtil.seq(p));
        Tile tl1 = new Tile(4L, 4L, false);
        Tile tl2 = new Tile(4L, 3L, false);
        Tile tl3 = new Tile(4L, 2L, false);
        Tile tl4 = new Tile(3L, 3L, false);
        Tile tl5 = new Tile(2L, 2L, false);
        board.setBoardType(false);
        super.assertEqual(false, t.canMoveTo(tl1, tl4));
    }

    public void testCanMoveto_TowerCross() {
        Board board = Board.getInstance();
        Piece p = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Piece p3 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.BlackQuote.getInstance(), p3,
                SeqUtil.seq(p));
        Tile tl1 = new Tile(4L, 4L, false);
        Tile tl2 = new Tile(4L, 3L, false);
        Tile tl3 = new Tile(4L, 2L, false);
        Tile tl4 = new Tile(3L, 3L, false);
        Tile tl5 = new Tile(2L, 2L, false);
        Tile tl6 = new Tile(7L, 2L, false);
        Tile tl7 = new Tile(1L, 1L, false);
        Tile tl8 = new Tile(5L, 5L, false);
        board.setBoardType(false);
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
        t.capturePiece(p2);
        super.assertEqual(true, t.canMoveTo(tl1, tl3));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        super.assertEqual(false, t.canMoveTo(tl1, tl6));
        super.assertEqual(false, t.canMoveTo(tl8, tl7));
        t.capturePiece(p2);
        t.capturePiece(p2);
        super.assertEqual(true, t.canMoveTo(tl8, tl7));
    }

    public void testPowerTile() {
        Board board = Board.getInstance();
        Piece ps = new Square();
        Piece pc = new Circle();
        Piece pcr = new Cross();
        board.setBoardType(false);
        super.assertEqual(true, board.getInstance().getTile(1L, 1L).isSpecial());
        board.getInstance().getTile(1L, 1L).setPiece(ps);
        board.getInstance().getTile(4L, 1L).setPiece(null);
        super.assertEqual(false,
            board.getInstance().getTile(1L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 1L),
                board.getInstance().getTile(2L, 2L)));
        board.getInstance().getTile(2L, 1L).setPiece(null);
        board.getInstance().getTile(3L, 1L).setPiece(null);
        super.assertEqual(true,
            board.getInstance().getTile(1L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 1L),
                board.getInstance().getTile(4L, 1L)));
        board.getInstance().getTile(1L, 1L).setPiece(pc);
        board.getInstance().getTile(2L, 2L).setPiece(null);
        board.getInstance().getTile(3L, 3L).setPiece(null);
        super.assertEqual(true,
            board.getInstance().getTile(1L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 1L),
                board.getInstance().getTile(3L, 3L)));
        board.getInstance().getTile(4L, 4L).setPiece(pc);
        board.getInstance().getTile(3L, 3L).setPiece(null);
        board.getInstance().getTile(2L, 2L).setPiece(null);
        board.getInstance().getTile(1L, 1L).setPiece(pcr);
        board.getInstance().getTile(1L, 2L).setPiece(null);
        board.getInstance().getTile(1L, 3L).setPiece(null);
        super.assertEqual(true,
            board.getInstance().getTile(1L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 1L),
                board.getInstance().getTile(1L, 3L)));
        board.getInstance().getTile(2L, 1L).setPiece(null);
        board.getInstance().getTile(3L, 1L).setPiece(null);
        super.assertEqual(true,
            board.getInstance().getTile(1L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 1L),
                board.getInstance().getTile(3L, 1L)));
        board.getInstance().getTile(1L, 3L).setPiece(pcr);
        board.getInstance().getTile(1L, 2L).setPiece(new Circle());
        board.getInstance().getTile(1L, 1L).setPiece(null);
        super.assertEqual(false,
            board.getInstance().getTile(1L, 3L).getPiece()
                 .canMoveTo(board.getInstance().getTile(1L, 3L),
                board.getInstance().getTile(1L, 1L)));
        board.getInstance().getTile(3L, 1L).setPiece(pcr);
        board.getInstance().getTile(2L, 1L).setPiece(new Square());
        board.getInstance().getTile(1L, 1L).setPiece(null);
        super.assertEqual(false,
            board.getInstance().getTile(3L, 1L).getPiece()
                 .canMoveTo(board.getInstance().getTile(3L, 1L),
                board.getInstance().getTile(1L, 1L)));
    }

    public void testMove() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Tile tl1 = new Tile(1L, 1L, p, false);
        Tile tl2 = new Tile(2L, 2L, false);
        Piece p2 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Tile tl3 = new Tile(1L, 1L, p2, false);
        Tile tl4 = new Tile(2L, 1L, false);
        Piece p3 = new Cross();
        Tile tl5 = new Tile(1L, 1L, p3, false);
        Tile tl6 = new Tile(2L, 3L, false);
        Tile tl7 = new Tile(1L, 2L, false);
        super.assertEqual(true, p.moveTo(tl1, tl2));
        super.assertEqual(false, Utils.equals(tl2.getPiece(), null));
        super.assertEqual(null, tl1.getPiece());
        super.assertEqual(true, p2.moveTo(tl3, tl4));
        super.assertEqual(false, Utils.equals(tl4.getPiece(), null));
        super.assertEqual(null, tl3.getPiece());
        super.assertEqual(true, p3.moveTo(tl5, tl7));
        super.assertEqual(false, Utils.equals(tl7.getPiece(), null));
        super.assertEqual(null, tl5.getPiece());
        super.assertEqual(true, p3.moveTo(tl7, tl6));
        super.assertEqual(false, Utils.equals(tl6.getPiece(), null));
        super.assertEqual(null, tl7.getPiece());
    }

    public void testTowerCapture() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Cross(quantum.quotes.WhiteQuote.getInstance());
        Piece p4 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p2,
                SeqUtil.seq(p));
        super.assertEqual(t.getSize(), 2L);
        t.capturePiece(p4);
        super.assertEqual(3L, t.getSize());
        t.capturePiece(p3);
        super.assertEqual(4L, t.getSize());
    }

    public void testCanMoveto_Tower_AfterCapture() {
        Piece p = new Square(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Cross(quantum.quotes.WhiteQuote.getInstance());
        Tower t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p2,
                SeqUtil.seq(p));
        Piece p3 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p4 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece p5 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p6 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Tile tl1 = new Tile(1L, 2L, false);
        Tile tl2 = new Tile(1L, 1L, false);
        t.capturePiece(p3);
        t.capturePiece(p4);
        super.assertEqual(true, t.canMoveTo(tl2, tl1));
        t.capturePiece(p5);
        t.capturePiece(p6);
        super.assertEqual(6L, t.getSize());
    }

    public void testTowerCaptureTower() {
        Piece p = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece p2 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Square(quantum.quotes.BlackQuote.getInstance());
        Piece p4 = new Cross(quantum.quotes.WhiteQuote.getInstance());
        Piece p5 = new Cross(quantum.quotes.WhiteQuote.getInstance());
        Piece p6 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece p7 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p,
                SeqUtil.seq(p2));
        Piece t2 = new Tower(quantum.quotes.BlackQuote.getInstance(), p3,
                SeqUtil.seq(p4));
        t2.capturePiece(p5);
        t2.capturePiece(p7);
        t.capturePiece(p6);
        super.assertEqual(3L, t.getSize());
        super.assertEqual(4L, t2.getSize());
        t.capturePiece(t2);
        super.assertEqual(7L, t.getSize());
    }

    public void testPieceMoveandCapture() {
        Piece p2 = new Square(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Tile tl11 = new Tile(1L, 1L, p2, false);
        Tile tl21 = new Tile(2L, 1L, false);
        Tile tl31 = new Tile(3L, 1L, p3, false);
        super.assertEqual(Utils.equals(tl11.getPiece(), null), false);
        super.assertEqual(Utils.equals(tl21.getPiece(), null), true);
        super.assertEqual(true, p2.moveTo(tl11, tl21));
        super.assertEqual(Utils.equals(tl11.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl21.getPiece(), null), false);
        super.assertEqual(true, p2.moveTo(tl21, tl31));
        super.assertEqual(Utils.equals(tl21.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl31.getPiece(), null), false);
        super.assertEqual(tl31.getPiece().getSize(), 2L);
    }

    public void testTowerMoveandCapture() {
        Piece p = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece t = new Tower(quantum.quotes.BlackQuote.getInstance(), p2,
                SeqUtil.seq(p));
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece p4 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Tile tl11 = new Tile(1L, 1L, t, false);
        Tile tl22 = new Tile(2L, 2L, false);
        Tile tl33 = new Tile(3L, 3L, p3, false);
        Tile tl31 = new Tile(3L, 1L, false);
        Tile tl32 = new Tile(3L, 2L, p4, false);
        super.assertEqual(Utils.equals(tl11.getPiece(), null), false);
        super.assertEqual(Utils.equals(tl22.getPiece(), null), true);
        super.assertEqual(true, t.canMoveTo(tl11, tl22));
        super.assertEqual(true, t.moveTo(tl11, tl22));
        super.assertEqual(true, t.canMoveTo(tl22, tl33));
        super.assertEqual(true, t.moveTo(tl22, tl33));
        super.assertEqual(Utils.equals(tl22.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl33.getPiece(), null), false);
        super.assertEqual(3L, tl33.getPiece().getSize());
        super.assertEqual(!(Utils.equals(tl32.getPiece(), null)), true);
    }

    public void GameCicleTest() {
        Boolean n = false;
        Quantum q = new Quantum(n);
        super.assertEqual(Utils.equals(q.getGameState(),
                quantum.quotes.NotStartedQuote.getInstance()), true);
        q.startGame();
        super.assertEqual(Utils.equals(q.getGameState(),
                quantum.quotes.PlayingQuote.getInstance()), true);
        super.assertEqual(((Object) q.getActualPlayer()),
            quantum.quotes.Player1Quote.getInstance());
        q.endTurn();
        super.assertEqual(((Object) q.getActualPlayer()),
            quantum.quotes.Player2Quote.getInstance());
        q.endTurn();
        super.assertEqual(((Object) q.getActualPlayer()),
            quantum.quotes.Player1Quote.getInstance());
    }

    public void GameOverTest() {
        Quantum q = new Quantum(false);
        Piece p = new Circle();
        q.startGame();
        super.assertEqual(q.board.getTile(5L, 5L).getPiece() instanceof Square,
            true);
        super.assertEqual(q.movePieceTo(5L, 5L, 4L, 5L), true);
        q.endTurn();
        q.endTurn();
        super.assertEqual(q.movePieceTo(4L, 5L, 3L, 5L), true);
        q.endTurn();
        q.endTurn();
        super.assertEqual(1L, q.board.getTile(3L, 5L).getPiece().getSize());
        super.assertEqual(quantum.quotes.BlackQuote.getInstance(),
            ((Object) q.board.getTile(2L, 5L).getPiece().getPlayer()));
        super.assertEqual(q.movePieceTo(3L, 5L, 2L, 5L), true);
        super.assertEqual(2L, q.board.getTile(2L, 5L).getPiece().getSize());
        q.endTurn();
        q.endTurn();
        super.assertEqual(true,
            !(Utils.equals(q.board.getTile(1L, 5L).getPiece(), null)));
    }

    public void testAll() {
        testCanMoveto_Circle();
        testCanMoveto_Square();
        testCanMoveto_Cross();
        testCanMoveto_TowerCircle();
        testCanMoveto_TowerSquare();
        testCanMoveto_TowerCross();
        testTowerCapture();
        testCanMoveto_Tower_AfterCapture();
        testTowerCaptureTower();
        testMove();
        testPowerTile();
        testPieceMoveandCapture();
        testTowerMoveandCapture();
        GameCicleTest();
        GameOverTest();
    }

    public String toString() {
        return "MovementTest{}";
    }
}
