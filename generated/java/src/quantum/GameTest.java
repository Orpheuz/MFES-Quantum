package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GameTest extends QuantumTest {
    public GameTest() {
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
        q.startGame();
        super.assertEqual(q.board.getTile(5L, 5L).getPiece() instanceof Square,
            true);
        super.assertEqual(q.movePieceTo(5L, 5L, 4L, 5L), true);
        q.endTurn();
        q.endTurn();
        super.assertEqual(q.movePieceTo(4L, 5L, 3L, 5L), true);
        q.endTurn();
        q.endTurn();
        super.assertEqual(q.movePieceTo(3L, 5L, 2L, 5L), true);
        super.assertEqual(true,
            q.board.getTile(5L, 2L).getPiece() instanceof Tower);
        q.endTurn();
        q.endTurn();
        super.assertEqual(q.movePieceTo(2L, 5L, 1L, 5L), true);
    }

    public void testAll() {
        GameCicleTest();
    }

    public String toString() {
        return "GameTest{}";
    }
}
