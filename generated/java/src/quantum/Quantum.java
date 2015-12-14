package quantum;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Quantum {
    private Boolean boardType;
    public Board board;
    private Object playerTurn;
    private Object actualState;
    private VDMMap score = MapUtil.map(new Maplet(
                quantum.quotes.Player1Quote.getInstance(), 0L),
            new Maplet(quantum.quotes.Player2Quote.getInstance(), 0L));

    public Quantum(final Boolean n) {
        cg_init_Quantum_1(n);
    }

    public Quantum() {
    }

    public void cg_init_Quantum_1(final Boolean n) {
        boardType = n;
        board = Board.getInstance();
        board.setBoardType(boardType);
        playerTurn = quantum.quotes.Player1Quote.getInstance();
        actualState = quantum.quotes.NotStartedQuote.getInstance();
    }

    public void updateGameState() {
        Number countW = 0L;
        Number countB = 0L;
        VDMSet setCompResult_1 = SetUtil.set();
        VDMSet set_5 = SetUtil.range(1L, Board.smallSizeY);

        for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext();) {
            Number x = ((Number) iterator_5.next());
            VDMSet set_6 = SetUtil.range(1L, Board.smallSizeX);

            for (Iterator iterator_6 = set_6.iterator(); iterator_6.hasNext();) {
                Number y = ((Number) iterator_6.next());
                setCompResult_1 = SetUtil.union(Utils.copy(setCompResult_1),
                        SetUtil.set(board.getTile(x, y)));
            }
        }

        for (Iterator iterator_7 = setCompResult_1.iterator();
                iterator_7.hasNext();) {
            Tile t = (Tile) iterator_7.next();
            Boolean andResult_27 = false;

            if (!(Utils.equals(t.getPiece(), null))) {
                if (t.getPiece().getSize().longValue() >= 6L) {
                    andResult_27 = true;
                }
            }

            if (andResult_27) {
                if (Utils.equals(t.getPiece().getPlayer(),
                            quantum.quotes.WhiteQuote.getInstance())) {
                    countW = countW.longValue() + 1L;
                } else {
                    countB = countB.longValue() + 1L;
                }
            }
        }

        if (countW.longValue() >= 3L) {
            actualState = quantum.quotes.Player1WonQuote.getInstance();
            score = MapUtil.override(Utils.copy(score),
                    MapUtil.map(
                        new Maplet(quantum.quotes.Player1Quote.getInstance(),
                            ((Number) Utils.get(score,
                                quantum.quotes.Player1Quote.getInstance())).longValue() +
                            1L)));
        } else {
            if (countB.longValue() >= 3L) {
                actualState = quantum.quotes.Player2WonQuote.getInstance();
                score = MapUtil.override(Utils.copy(score),
                        MapUtil.map(
                            new Maplet(
                                quantum.quotes.Player2Quote.getInstance(),
                                ((Number) Utils.get(score,
                                    quantum.quotes.Player2Quote.getInstance())).longValue() +
                                1L)));
            }
        }
    }

    public void startGame() {
        actualState = quantum.quotes.PlayingQuote.getInstance();
    }

    public void endTurn() {
        if (Utils.equals(playerTurn, quantum.quotes.Player1Quote.getInstance())) {
            playerTurn = quantum.quotes.Player2Quote.getInstance();
        } else {
            playerTurn = quantum.quotes.Player1Quote.getInstance();
        }
    }

    public Boolean movePieceTo(final Number xi, final Number yi,
        final Number xf, final Number yf) {
        if (!(Utils.equals(board.getTile(xi, yi).getPiece(), null))) {
            return board.getTile(xi, yi).getPiece()
                        .moveTo(board.getTile(xi, yi), board.getTile(xf, yf));
        } else {
            return false;
        }
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
