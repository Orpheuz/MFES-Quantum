package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class MovementTest extends QuantumTest {
    private Board bd = new Board();

    public MovementTest() {
    }

    public void testCanMoveto_Circle() {
        Piece p = new Circle();
        Tile t = new Tile(3L, 3L, p);
        Tile t2 = new Tile(2L, 2L);
        Tile t3 = new Tile(4L, 2L);
        Tile t4 = new Tile(5L, 5L);
        Tile t5 = new Tile(3L, 4L);
        Tile t6 = new Tile(2L, 3L);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(false, p.canMoveTo(t, t6));
        super.assertEqual(false, p.canMoveTo(t, t5));
        super.assertEqual(false, p.canMoveTo(t, t4));
    }

    public void testCanMoveto_Square() {
        Piece p = new Square();
        Tile t = new Tile(2L, 2L, p);
        Tile t2 = new Tile(1L, 2L);
        Tile t3 = new Tile(2L, 3L);
        Tile t4 = new Tile(2L, 6L);
        Tile t5 = new Tile(3L, 3L);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(false, p.canMoveTo(t, t5));
        super.assertEqual(false, p.canMoveTo(t, t4));
    }

    public void testCanMoveto_Cross() {
        Piece p = new Cross();
        Tile t = new Tile(2L, 2L, p);
        Tile t2 = new Tile(1L, 2L);
        Tile t3 = new Tile(2L, 3L);
        Tile t4 = new Tile(3L, 1L);
        Tile t5 = new Tile(1L, 1L);
        Tile t6 = new Tile(3L, 3L);
        Tile t7 = new Tile(2L, 4L);
        super.assertEqual(true, p.canMoveTo(t, t2));
        super.assertEqual(true, p.canMoveTo(t, t3));
        super.assertEqual(true, p.canMoveTo(t, t4));
        super.assertEqual(true, p.canMoveTo(t, t5));
    }

    public void testCanMoveto_TowerSquare() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.BlackQuote.getInstance(), p, p2);
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Tile tl1 = new Tile(4L, 4L, t);
        Tile tl2 = new Tile(4L, 3L);
        Tile tl3 = new Tile(4L, 2L);
        Tile tl4 = new Tile(3L, 3L, p3);
        Tile tl5 = new Tile(2L, 2L);
        Tile tl6 = new Tile(1L, 1L);
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
        super.assertEqual(false, t.canMoveTo(tl1, tl6));
        super.assertEqual(false, p.canMoveTo(tl1, tl2));
        super.assertEqual(false, t.canMoveTo(tl1, tl2));
        t.capturePiece(p3);
        super.assertEqual(3L, t.getSize());
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
        super.assertEqual(true, t.canMoveTo(tl1, tl3));
        super.assertEqual(false, t.canMoveTo(tl1, tl4));
    }

    public void testCanMoveto_TowerCircle() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p3, p);
        Tile tl1 = new Tile(4L, 4L);
        Tile tl2 = new Tile(4L, 3L);
        Tile tl3 = new Tile(4L, 2L);
        Tile tl4 = new Tile(3L, 3L);
        Tile tl5 = new Tile(2L, 2L);
        super.assertEqual(false, t.canMoveTo(tl1, tl4));
        super.assertEqual(false, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
        t.capturePiece(p2);
        super.assertEqual(false, t.canMoveTo(tl1, tl2));
        super.assertEqual(false, t.canMoveTo(tl1, tl3));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
    }

    public void testCanMoveto_TowerCross() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Piece p2 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p2, p);
        Tile tl1 = new Tile(4L, 4L);
        Tile tl2 = new Tile(4L, 3L);
        Tile tl3 = new Tile(4L, 2L);
        Tile tl4 = new Tile(3L, 3L);
        Tile tl5 = new Tile(2L, 2L);
        Tile tl6 = new Tile(4L, 7L);
        Tile tl7 = new Tile(1L, 1L);
        Tile tl8 = new Tile(5L, 5L);
        super.assertEqual(false, t.canMoveTo(tl1, tl4));
        super.assertEqual(false, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
        t.capturePiece(p3);
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
        super.assertEqual(true, t.canMoveTo(tl1, tl3));
        super.assertEqual(true, t.canMoveTo(tl1, tl5));
        super.assertEqual(true, t.canMoveTo(tl1, tl4));
        super.assertEqual(true, t.canMoveTo(tl1, tl6));
        super.assertEqual(false, t.canMoveTo(tl8, tl7));
    }

    public void testPowerTile() {
        Piece ps = new Square();
        Piece pc = new Circle();
        Tile tl1 = new Tile(1L, 1L, ps);
        Tile tl2 = new Tile(1L, 1L, pc);
        Tile tl3 = new Tile(2L, 2L);
        Tile tl4 = new Tile(2L, 1L);
        super.assertEqual(true, ps.canMoveTo(tl1, tl3));
        super.assertEqual(true, pc.canMoveTo(tl2, tl4));
    }

    public void testMove() {
        Piece p = new Circle(quantum.quotes.BlackQuote.getInstance());
        Tile tl1 = new Tile(1L, 1L, p);
        Tile tl2 = new Tile(2L, 2L);
        Piece p2 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Tile tl3 = new Tile(1L, 1L, p2);
        Tile tl4 = new Tile(2L, 1L);
        Piece p3 = new Cross();
        Tile tl5 = new Tile(1L, 1L, p3);
        Tile tl6 = new Tile(2L, 3L);
        Tile tl7 = new Tile(1L, 2L);
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
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p2, p);
        super.assertEqual(t.getSize(), 2L);
        t.capturePiece(p4);
        super.assertEqual(3L, t.getSize());
        t.capturePiece(p3);
        super.assertEqual(4L, t.getSize());
    }

    public void testCanMoveto_Tower_AfterCapture() {
        Piece p = new Square();
        Piece p2 = new Cross();
        Tower t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p, p2);
        Piece p3 = new Circle();
        Piece p4 = new Square();
        Piece p5 = new Circle();
        Piece p6 = new Square();
        Tile tl1 = new Tile(1L, 2L);
        Tile tl2 = new Tile(1L, 1L);
        t.capturePiece(p3);
        t.capturePiece(p4);
        super.assertEqual(true, t.canMoveTo(tl1, tl2));
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
        Piece p8 = new Cross(quantum.quotes.WhiteQuote.getInstance());
        Piece t = new Tower(quantum.quotes.WhiteQuote.getInstance(), p, p2);
        Piece t2 = new Tower(quantum.quotes.BlackQuote.getInstance(), p3, p4);
        t2.capturePiece(p5);
        t2.capturePiece(p7);
        t.capturePiece(p6);
        super.assertEqual(3L, t.getSize());
        super.assertEqual(4L, t2.getSize());
        t.capturePiece(p8);
        t.capturePiece(t2);
        super.assertEqual(7L, t.getSize());
    }

    public void testPieceMoveandCapture() {
        Piece p2 = new Square(quantum.quotes.BlackQuote.getInstance());
        Piece p3 = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Tile tl11 = new Tile(1L, 1L, p2);
        Tile tl21 = new Tile(2L, 1L);
        Tile tl31 = new Tile(3L, 1L, p3);
        super.assertEqual(Utils.equals(tl11.getPiece(), null), false);
        super.assertEqual(Utils.equals(tl21.getPiece(), null), true);
        super.assertEqual(true, p2.moveTo(tl11, tl21));
        super.assertEqual(Utils.equals(tl11.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl21.getPiece(), null), false);
        super.assertEqual(true, p2.moveTo(tl21, tl31));
        super.assertEqual(Utils.equals(tl21.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl31.getPiece(), null), false);
        super.assertEqual(tl31.getPiece() instanceof Tower, true);
        super.assertEqual(tl31.getPiece().getSize(), 2L);
    }

    public void testTowerMoveandCapture() {
        Piece p = new Circle(quantum.quotes.WhiteQuote.getInstance());
        Piece p2 = new Circle(quantum.quotes.BlackQuote.getInstance());
        Piece t = new Tower(quantum.quotes.BlackQuote.getInstance(), p2, p);
        Piece p3 = new Square(quantum.quotes.WhiteQuote.getInstance());
        Piece p4 = new Cross(quantum.quotes.BlackQuote.getInstance());
        Tile tl11 = new Tile(1L, 1L, t);
        Tile tl22 = new Tile(2L, 2L);
        Tile tl33 = new Tile(3L, 3L, p3);
        Tile tl31 = new Tile(3L, 1L);
        Tile tl32 = new Tile(3L, 2L, p4);
        super.assertEqual(Utils.equals(tl11.getPiece(), null), false);
        super.assertEqual(Utils.equals(tl22.getPiece(), null), true);
        super.assertEqual(true, t.canMoveTo(tl11, tl22));
        super.assertEqual(true, t.moveTo(tl11, tl22));
        super.assertEqual(true, t.canMoveTo(tl22, tl33));
        super.assertEqual(true, t.moveTo(tl22, tl33));
        super.assertEqual(Utils.equals(tl22.getPiece(), null), true);
        super.assertEqual(Utils.equals(tl33.getPiece(), null), false);
        super.assertEqual(!(Utils.equals(tl32.getPiece(), null)), true);
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
    }

    public String toString() {
        return "MovementTest{" + "bd := " + Utils.toString(bd) + "}";
    }
}
