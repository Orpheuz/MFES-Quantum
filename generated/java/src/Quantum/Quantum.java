package Quantum;

import java.util.Iterator;

import org.overture.codegen.runtime.MapUtil;
import org.overture.codegen.runtime.Maplet;
import org.overture.codegen.runtime.SetUtil;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMMap;
import org.overture.codegen.runtime.VDMSet;

import Quantum.quotes.NotStartedQuote;
import Quantum.quotes.Player1Quote;
import Quantum.quotes.Player1WonQuote;
import Quantum.quotes.Player2Quote;
import Quantum.quotes.Player2WonQuote;
import Quantum.quotes.PlayingQuote;
import Quantum.quotes.WhiteQuote;


@SuppressWarnings("all")
public class Quantum {
    private Boolean boardType;
    public Board board;
    private Object playerTurn;
    private Object actualState;
    private VDMMap score = MapUtil.map(new Maplet(
                Player1Quote.getInstance(), 0L),
            new Maplet(Player2Quote.getInstance(), 0L));

    public Quantum(final Boolean n) {
        cg_init_Quantum_1(n);
    }

    public Quantum() {
    }

    public void cg_init_Quantum_1(final Boolean n) {
        boardType = n;
        board = Board.getInstance();
        board.setBoardType(boardType);
        playerTurn = Player1Quote.getInstance();
        actualState = NotStartedQuote.getInstance();
    }

    public void isGameOver() {
        Number countW = 0L;
        Number countB = 0L;
        VDMSet setCompResult_1 = SetUtil.set();
        VDMSet set_5 = SetUtil.range(0L, Board.smallSizeX);

        for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext();) {
            Number x = ((Number) iterator_5.next());
            VDMSet set_6 = SetUtil.range(0L, Board.smallSizeY);

            for (Iterator iterator_6 = set_6.iterator(); iterator_6.hasNext();) {
                Number y = ((Number) iterator_6.next());
                setCompResult_1 = SetUtil.union(Utils.copy(setCompResult_1),
                        SetUtil.set(board.getTile(x, y)));
            }
        }

        for (Iterator iterator_7 = setCompResult_1.iterator();
                iterator_7.hasNext();) {
            Tile t = (Tile) iterator_7.next();

            if (t.getPiece().getSize().longValue() >= 6L) {
                if (Utils.equals(t.getPiece().getPlayer(),
                            WhiteQuote.getInstance())) {
                    countW = countW.longValue() + 1L;
                } else { 
                    countB = countB.longValue() + 1L;
                }
            }
        }

        if (countW.longValue() >= 3L) {
            actualState = Player1WonQuote.getInstance();
            score = MapUtil.override(Utils.copy(score),
                    MapUtil.map(
                        new Maplet(Player1Quote.getInstance(),
                            ((Number) Utils.get(score,
                                Player1Quote.getInstance())).longValue() +
                            1L)));
        } else {
            if (countB.longValue() >= 3L) {
                actualState = Player2WonQuote.getInstance();
                score = MapUtil.override(Utils.copy(score),
                        MapUtil.map(
                            new Maplet(
                                Player2Quote.getInstance(),
                                ((Number) Utils.get(score,
                                    Player2Quote.getInstance())).longValue() +
                                1L)));
            }
        }
    }

    public void startGame() {
        actualState = PlayingQuote.getInstance();
    }

    public void endTurn() {
        if (Utils.equals(playerTurn, Player1Quote.getInstance())) {
            playerTurn = Player2Quote.getInstance();
        } else {
            playerTurn = Player1Quote.getInstance();
        }
    }

    public Boolean movePieceTo(final Number xi, final Number yi,
        final Number xf, final Number yf) {
        if (Utils.equals(board.getTile(xi, yi).getPiece(), null)) {
            return false;
        }

        return board.getTile(xi, yi).getPiece()
                    .moveTo(board.getTile(xi, yi), board.getTile(xf, yf));
    }

    public Object getGameState() {
        return actualState;
    }

    public Object getActualPlayer() {
        return playerTurn;
    }

    public String toString() {
        return "Quantum{" + "boardType := " + Utils.toString(boardType) +
        ", board := " + Utils.toString(board) + ", playerTurn := " +
        Utils.toString(playerTurn) + ", actualState := " +
        Utils.toString(actualState) + ", score := " + Utils.toString(score) +
        "}";
    }
}
