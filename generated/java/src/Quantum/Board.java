package quantum;

import java.util.Iterator;

import org.overture.codegen.runtime.SeqUtil;
import org.overture.codegen.runtime.SetUtil;
import org.overture.codegen.runtime.Tuple;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSeq;
import org.overture.codegen.runtime.VDMSet;


@SuppressWarnings("all")
public class Board {
    public static final double smallSizeX = 10L;
    public static final double smallSizeY = 6L;
    public static final double bigSizeX = 12L;
    public static final double bigSizeY = 8L;
    private static Board boardInstance = new Board();
    private VDMSeq board = SeqUtil.seq(SeqUtil.seq());

    public Board() {
    }

    private Tile buildBoard(final Number x, final Number y) {
        Object casesExpResult_1 = null;

        Tuple casesExp_1 = Tuple.mk_(x, y);
        Tuple tuplePattern_1 = Utils.copy(casesExp_1);
        Boolean success_1 = tuplePattern_1.compatible(Number.class, Number.class);

        if (success_1) {
            Number intPattern_1 = ((Number) tuplePattern_1.get(0));
            success_1 = Utils.equals(intPattern_1, 1L);

            if (success_1) {
                Number intPattern_2 = ((Number) tuplePattern_1.get(1));
                success_1 = Utils.equals(intPattern_2, 2L);
            }
        }

        if (!(success_1)) {
            Tuple tuplePattern_2 = Utils.copy(casesExp_1);
            success_1 = tuplePattern_2.compatible(Number.class, Number.class);

            if (success_1) {
                Number intPattern_3 = ((Number) tuplePattern_2.get(0));
                success_1 = Utils.equals(intPattern_3, 1L);

                if (success_1) {
                    Number intPattern_4 = ((Number) tuplePattern_2.get(1));
                    success_1 = Utils.equals(intPattern_4, 5L);
                }
            }

            if (!(success_1)) {
                Tuple tuplePattern_3 = Utils.copy(casesExp_1);
                success_1 = tuplePattern_3.compatible(Number.class, Number.class);

                if (success_1) {
                    Number intPattern_5 = ((Number) tuplePattern_3.get(0));
                    success_1 = Utils.equals(intPattern_5, 5L);

                    if (success_1) {
                        Number intPattern_6 = ((Number) tuplePattern_3.get(1));
                        success_1 = Utils.equals(intPattern_6, 1L);
                    }
                }

                if (!(success_1)) {
                    Tuple tuplePattern_4 = Utils.copy(casesExp_1);
                    success_1 = tuplePattern_4.compatible(Number.class,
                            Number.class);

                    if (success_1) {
                        Number intPattern_7 = ((Number) tuplePattern_4.get(0));
                        success_1 = Utils.equals(intPattern_7, 6L);

                        if (success_1) {
                            Number intPattern_8 = ((Number) tuplePattern_4.get(1));
                            success_1 = Utils.equals(intPattern_8, 1L);
                        }
                    }

                    if (!(success_1)) {
                        Tuple tuplePattern_5 = Utils.copy(casesExp_1);
                        success_1 = tuplePattern_5.compatible(Number.class,
                                Number.class);

                        if (success_1) {
                            Number intPattern_9 = ((Number) tuplePattern_5.get(0));
                            success_1 = Utils.equals(intPattern_9, 1L);

                            if (success_1) {
                                Number intPattern_10 = ((Number) tuplePattern_5.get(1));
                                success_1 = Utils.equals(intPattern_10, 3L);
                            }
                        }

                        if (!(success_1)) {
                            Tuple tuplePattern_6 = Utils.copy(casesExp_1);
                            success_1 = tuplePattern_6.compatible(Number.class,
                                    Number.class);

                            if (success_1) {
                                Number intPattern_11 = ((Number) tuplePattern_6.get(0));
                                success_1 = Utils.equals(intPattern_11, 1L);

                                if (success_1) {
                                    Number intPattern_12 = ((Number) tuplePattern_6.get(1));
                                    success_1 = Utils.equals(intPattern_12, 4L);
                                }
                            }

                            if (!(success_1)) {
                                Tuple tuplePattern_7 = Utils.copy(casesExp_1);
                                success_1 = tuplePattern_7.compatible(Number.class,
                                        Number.class);

                                if (success_1) {
                                    Number intPattern_13 = ((Number) tuplePattern_7.get(0));
                                    success_1 = Utils.equals(intPattern_13, 2L);

                                    if (success_1) {
                                        Number intPattern_14 = ((Number) tuplePattern_7.get(1));
                                        success_1 = Utils.equals(intPattern_14,
                                                2L);
                                    }
                                }

                                if (!(success_1)) {
                                    Tuple tuplePattern_8 = Utils.copy(casesExp_1);
                                    success_1 = tuplePattern_8.compatible(Number.class,
                                            Number.class);

                                    if (success_1) {
                                        Number intPattern_15 = ((Number) tuplePattern_8.get(0));
                                        success_1 = Utils.equals(intPattern_15,
                                                2L);

                                        if (success_1) {
                                            Number intPattern_16 = ((Number) tuplePattern_8.get(1));
                                            success_1 = Utils.equals(intPattern_16,
                                                    5L);
                                        }
                                    }

                                    if (!(success_1)) {
                                        Tuple tuplePattern_9 = Utils.copy(casesExp_1);
                                        success_1 = tuplePattern_9.compatible(Number.class,
                                                Number.class);

                                        if (success_1) {
                                            Number intPattern_17 = ((Number) tuplePattern_9.get(0));
                                            success_1 = Utils.equals(intPattern_17,
                                                    4L);

                                            if (success_1) {
                                                Number intPattern_18 = ((Number) tuplePattern_9.get(1));
                                                success_1 = Utils.equals(intPattern_18,
                                                        2L);
                                            }
                                        }

                                        if (!(success_1)) {
                                            Tuple tuplePattern_10 = Utils.copy(casesExp_1);
                                            success_1 = tuplePattern_10.compatible(Number.class,
                                                    Number.class);

                                            if (success_1) {
                                                Number intPattern_19 = ((Number) tuplePattern_10.get(0));
                                                success_1 = Utils.equals(intPattern_19,
                                                        7L);

                                                if (success_1) {
                                                    Number intPattern_20 = ((Number) tuplePattern_10.get(1));
                                                    success_1 = Utils.equals(intPattern_20,
                                                            2L);
                                                }
                                            }

                                            if (!(success_1)) {
                                                Tuple tuplePattern_11 = Utils.copy(casesExp_1);
                                                success_1 = tuplePattern_11.compatible(Number.class,
                                                        Number.class);

                                                if (success_1) {
                                                    Number intPattern_21 = ((Number) tuplePattern_11.get(0));
                                                    success_1 = Utils.equals(intPattern_21,
                                                            2L);

                                                    if (success_1) {
                                                        Number intPattern_22 = ((Number) tuplePattern_11.get(1));
                                                        success_1 = Utils.equals(intPattern_22,
                                                                3L);
                                                    }
                                                }

                                                if (!(success_1)) {
                                                    Tuple tuplePattern_12 = Utils.copy(casesExp_1);
                                                    success_1 = tuplePattern_12.compatible(Number.class,
                                                            Number.class);

                                                    if (success_1) {
                                                        Number intPattern_23 = ((Number) tuplePattern_12.get(0));
                                                        success_1 = Utils.equals(intPattern_23,
                                                                2L);

                                                        if (success_1) {
                                                            Number intPattern_24 =
                                                                ((Number) tuplePattern_12.get(1));
                                                            success_1 = Utils.equals(intPattern_24,
                                                                    4L);
                                                        }
                                                    }

                                                    if (!(success_1)) {
                                                        Tuple tuplePattern_13 = Utils.copy(casesExp_1);
                                                        success_1 = tuplePattern_13.compatible(Number.class,
                                                                Number.class);

                                                        if (success_1) {
                                                            Number intPattern_25 =
                                                                ((Number) tuplePattern_13.get(0));
                                                            success_1 = Utils.equals(intPattern_25,
                                                                    4L);

                                                            if (success_1) {
                                                                Number intPattern_26 =
                                                                    ((Number) tuplePattern_13.get(1));
                                                                success_1 = Utils.equals(intPattern_26,
                                                                        1L);
                                                            }
                                                        }

                                                        if (!(success_1)) {
                                                            Tuple tuplePattern_14 =
                                                                Utils.copy(casesExp_1);
                                                            success_1 = tuplePattern_14.compatible(Number.class,
                                                                    Number.class);

                                                            if (success_1) {
                                                                Number intPattern_27 =
                                                                    ((Number) tuplePattern_14.get(0));
                                                                success_1 = Utils.equals(intPattern_27,
                                                                        7L);

                                                                if (success_1) {
                                                                    Number intPattern_28 =
                                                                        ((Number) tuplePattern_14.get(1));
                                                                    success_1 = Utils.equals(intPattern_28,
                                                                            1L);
                                                                }
                                                            }

                                                            if (!(success_1)) {
                                                                Tuple tuplePattern_15 =
                                                                    Utils.copy(casesExp_1);
                                                                success_1 = tuplePattern_15.compatible(Number.class,
                                                                        Number.class);

                                                                if (success_1) {
                                                                    Number intPattern_29 =
                                                                        ((Number) tuplePattern_15.get(0));
                                                                    success_1 = Utils.equals(intPattern_29,
                                                                            5L);

                                                                    if (success_1) {
                                                                        Number intPattern_30 =
                                                                            ((Number) tuplePattern_15.get(1));
                                                                        success_1 = Utils.equals(intPattern_30,
                                                                                2L);
                                                                    }
                                                                }

                                                                if (!(success_1)) {
                                                                    Tuple tuplePattern_16 =
                                                                        Utils.copy(casesExp_1);
                                                                    success_1 = tuplePattern_16.compatible(Number.class,
                                                                            Number.class);

                                                                    if (success_1) {
                                                                        Number intPattern_31 =
                                                                            ((Number) tuplePattern_16.get(0));
                                                                        success_1 = Utils.equals(intPattern_31,
                                                                                6L);

                                                                        if (success_1) {
                                                                            Number intPattern_32 =
                                                                                ((Number) tuplePattern_16.get(1));
                                                                            success_1 = Utils.equals(intPattern_32,
                                                                                    2L);
                                                                        }
                                                                    }

                                                                    if (!(success_1)) {
                                                                        Tuple tuplePattern_17 =
                                                                            Utils.copy(casesExp_1);
                                                                        success_1 = tuplePattern_17.compatible(Number.class,
                                                                                Number.class);

                                                                        if (success_1) {
                                                                            Number intPattern_33 =
                                                                                ((Number) tuplePattern_17.get(0));
                                                                            success_1 = Utils.equals(intPattern_33,
                                                                                    5L);

                                                                            if (success_1) {
                                                                                Number intPattern_34 =
                                                                                    ((Number) tuplePattern_17.get(1));
                                                                                success_1 = Utils.equals(intPattern_34,
                                                                                        6L);
                                                                            }
                                                                        }

                                                                        if (!(success_1)) {
                                                                            Tuple tuplePattern_18 =
                                                                                Utils.copy(casesExp_1);
                                                                            success_1 = tuplePattern_18.compatible(Number.class,
                                                                                    Number.class);

                                                                            if (success_1) {
                                                                                Number intPattern_35 =
                                                                                    ((Number) tuplePattern_18.get(0));
                                                                                success_1 = Utils.equals(intPattern_35,
                                                                                        6L);

                                                                                if (success_1) {
                                                                                    Number intPattern_36 =
                                                                                        ((Number) tuplePattern_18.get(1));
                                                                                    success_1 = Utils.equals(intPattern_36,
                                                                                            6L);
                                                                                }
                                                                            }

                                                                            if (!(success_1)) {
                                                                                Tuple tuplePattern_19 =
                                                                                    Utils.copy(casesExp_1);
                                                                                success_1 = tuplePattern_19.compatible(Number.class,
                                                                                        Number.class);

                                                                                if (success_1) {
                                                                                    Number intPattern_37 =
                                                                                        ((Number) tuplePattern_19.get(0));
                                                                                    success_1 = Utils.equals(intPattern_37,
                                                                                            10L);

                                                                                    if (success_1) {
                                                                                        Number intPattern_38 =
                                                                                            ((Number) tuplePattern_19.get(1));
                                                                                        success_1 = Utils.equals(intPattern_38,
                                                                                                2L);
                                                                                    }
                                                                                }

                                                                                if (!(success_1)) {
                                                                                    Tuple tuplePattern_20 =
                                                                                        Utils.copy(casesExp_1);
                                                                                    success_1 = tuplePattern_20.compatible(Number.class,
                                                                                            Number.class);

                                                                                    if (success_1) {
                                                                                        Number intPattern_39 =
                                                                                            ((Number) tuplePattern_20.get(0));
                                                                                        success_1 = Utils.equals(intPattern_39,
                                                                                                10L);

                                                                                        if (success_1) {
                                                                                            Number intPattern_40 =
                                                                                                ((Number) tuplePattern_20.get(1));
                                                                                            success_1 = Utils.equals(intPattern_40,
                                                                                                    5L);
                                                                                        }
                                                                                    }

                                                                                    if (!(success_1)) {
                                                                                        Tuple tuplePattern_21 =
                                                                                            Utils.copy(casesExp_1);
                                                                                        success_1 = tuplePattern_21.compatible(Number.class,
                                                                                                Number.class);

                                                                                        if (success_1) {
                                                                                            Number intPattern_41 =
                                                                                                ((Number) tuplePattern_21.get(0));
                                                                                            success_1 = Utils.equals(intPattern_41,
                                                                                                    4L);

                                                                                            if (success_1) {
                                                                                                Number intPattern_42 =
                                                                                                    ((Number) tuplePattern_21.get(1));
                                                                                                success_1 = Utils.equals(intPattern_42,
                                                                                                        5L);
                                                                                            }
                                                                                        }

                                                                                        if (!(success_1)) {
                                                                                            Tuple tuplePattern_22 =
                                                                                                Utils.copy(casesExp_1);
                                                                                            success_1 = tuplePattern_22.compatible(Number.class,
                                                                                                    Number.class);

                                                                                            if (success_1) {
                                                                                                Number intPattern_43 =
                                                                                                    ((Number) tuplePattern_22.get(0));
                                                                                                success_1 = Utils.equals(intPattern_43,
                                                                                                        4L);

                                                                                                if (success_1) {
                                                                                                    Number intPattern_44 =
                                                                                                        ((Number) tuplePattern_22.get(1));
                                                                                                    success_1 = Utils.equals(intPattern_44,
                                                                                                            7L);
                                                                                                }
                                                                                            }

                                                                                            if (!(success_1)) {
                                                                                                Tuple tuplePattern_23 =
                                                                                                    Utils.copy(casesExp_1);
                                                                                                success_1 = tuplePattern_23.compatible(Number.class,
                                                                                                        Number.class);

                                                                                                if (success_1) {
                                                                                                    Number intPattern_45 =
                                                                                                        ((Number) tuplePattern_23.get(0));
                                                                                                    success_1 = Utils.equals(intPattern_45,
                                                                                                            9L);

                                                                                                    if (success_1) {
                                                                                                        Number intPattern_46 =
                                                                                                            ((Number) tuplePattern_23.get(1));
                                                                                                        success_1 = Utils.equals(intPattern_46,
                                                                                                                2L);
                                                                                                    }
                                                                                                }

                                                                                                if (!(success_1)) {
                                                                                                    Tuple tuplePattern_24 =
                                                                                                        Utils.copy(casesExp_1);
                                                                                                    success_1 = tuplePattern_24.compatible(Number.class,
                                                                                                            Number.class);

                                                                                                    if (success_1) {
                                                                                                        Number intPattern_47 =
                                                                                                            ((Number) tuplePattern_24.get(0));
                                                                                                        success_1 = Utils.equals(intPattern_47,
                                                                                                                9L);

                                                                                                        if (success_1) {
                                                                                                            Number intPattern_48 =
                                                                                                                ((Number) tuplePattern_24.get(1));
                                                                                                            success_1 = Utils.equals(intPattern_48,
                                                                                                                    5L);
                                                                                                        }
                                                                                                    }

                                                                                                    if (!(success_1)) {
                                                                                                        Tuple tuplePattern_25 =
                                                                                                            Utils.copy(casesExp_1);
                                                                                                        success_1 = tuplePattern_25.compatible(Number.class,
                                                                                                                Number.class);

                                                                                                        if (success_1) {
                                                                                                            Number intPattern_49 =
                                                                                                                ((Number) tuplePattern_25.get(0));
                                                                                                            success_1 = Utils.equals(intPattern_49,
                                                                                                                    10L);

                                                                                                            if (success_1) {
                                                                                                                Number intPattern_50 =
                                                                                                                    ((Number) tuplePattern_25.get(1));
                                                                                                                success_1 = Utils.equals(intPattern_50,
                                                                                                                        3L);
                                                                                                            }
                                                                                                        }

                                                                                                        if (!(success_1)) {
                                                                                                            Tuple tuplePattern_26 =
                                                                                                                Utils.copy(casesExp_1);
                                                                                                            success_1 = tuplePattern_26.compatible(Number.class,
                                                                                                                    Number.class);

                                                                                                            if (success_1) {
                                                                                                                Number intPattern_51 =
                                                                                                                    ((Number) tuplePattern_26.get(0));
                                                                                                                success_1 = Utils.equals(intPattern_51,
                                                                                                                        10L);

                                                                                                                if (success_1) {
                                                                                                                    Number intPattern_52 =
                                                                                                                        ((Number) tuplePattern_26.get(1));
                                                                                                                    success_1 = Utils.equals(intPattern_52,
                                                                                                                            4L);
                                                                                                                }
                                                                                                            }

                                                                                                            if (!(success_1)) {
                                                                                                                Tuple tuplePattern_27 =
                                                                                                                    Utils.copy(casesExp_1);
                                                                                                                success_1 = tuplePattern_27.compatible(Number.class,
                                                                                                                        Number.class);

                                                                                                                if (success_1) {
                                                                                                                    Number intPattern_53 =
                                                                                                                        ((Number) tuplePattern_27.get(0));
                                                                                                                    success_1 = Utils.equals(intPattern_53,
                                                                                                                            9L);

                                                                                                                    if (success_1) {
                                                                                                                        Number intPattern_54 =
                                                                                                                            ((Number) tuplePattern_27.get(1));
                                                                                                                        success_1 = Utils.equals(intPattern_54,
                                                                                                                                3L);
                                                                                                                    }
                                                                                                                }

                                                                                                                if (!(success_1)) {
                                                                                                                    Tuple tuplePattern_28 =
                                                                                                                        Utils.copy(casesExp_1);
                                                                                                                    success_1 = tuplePattern_28.compatible(Number.class,
                                                                                                                            Number.class);

                                                                                                                    if (success_1) {
                                                                                                                        Number intPattern_55 =
                                                                                                                            ((Number) tuplePattern_28.get(0));
                                                                                                                        success_1 = Utils.equals(intPattern_55,
                                                                                                                                9L);

                                                                                                                        if (success_1) {
                                                                                                                            Number intPattern_56 =
                                                                                                                                ((Number) tuplePattern_28.get(1));
                                                                                                                            success_1 = Utils.equals(intPattern_56,
                                                                                                                                    4L);
                                                                                                                        }
                                                                                                                    }

                                                                                                                    if (!(success_1)) {
                                                                                                                        Tuple tuplePattern_29 =
                                                                                                                            Utils.copy(casesExp_1);
                                                                                                                        success_1 = tuplePattern_29.compatible(Number.class,
                                                                                                                                Number.class);

                                                                                                                        if (success_1) {
                                                                                                                            Number intPattern_57 =
                                                                                                                                ((Number) tuplePattern_29.get(0));
                                                                                                                            success_1 = Utils.equals(intPattern_57,
                                                                                                                                    4L);

                                                                                                                            if (success_1) {
                                                                                                                                Number intPattern_58 =
                                                                                                                                    ((Number) tuplePattern_29.get(1));
                                                                                                                                success_1 = Utils.equals(intPattern_58,
                                                                                                                                        6L);
                                                                                                                            }
                                                                                                                        }

                                                                                                                        if (!(success_1)) {
                                                                                                                            Tuple tuplePattern_30 =
                                                                                                                                Utils.copy(casesExp_1);
                                                                                                                            success_1 = tuplePattern_30.compatible(Number.class,
                                                                                                                                    Number.class);

                                                                                                                            if (success_1) {
                                                                                                                                Number intPattern_59 =
                                                                                                                                    ((Number) tuplePattern_30.get(0));
                                                                                                                                success_1 = Utils.equals(intPattern_59,
                                                                                                                                        7L);

                                                                                                                                if (success_1) {
                                                                                                                                    Number intPattern_60 =
                                                                                                                                        ((Number) tuplePattern_30.get(1));
                                                                                                                                    success_1 = Utils.equals(intPattern_60,
                                                                                                                                            6L);
                                                                                                                                }
                                                                                                                            }

                                                                                                                            if (!(success_1)) {
                                                                                                                                Tuple tuplePattern_31 =
                                                                                                                                    Utils.copy(casesExp_1);
                                                                                                                                success_1 = tuplePattern_31.compatible(Number.class,
                                                                                                                                        Number.class);

                                                                                                                                if (success_1) {
                                                                                                                                    Number intPattern_61 =
                                                                                                                                        ((Number) tuplePattern_31.get(0));
                                                                                                                                    success_1 = Utils.equals(intPattern_61,
                                                                                                                                            5L);

                                                                                                                                    if (success_1) {
                                                                                                                                        Number intPattern_62 =
                                                                                                                                            ((Number) tuplePattern_31.get(1));
                                                                                                                                        success_1 = Utils.equals(intPattern_62,
                                                                                                                                                5L);
                                                                                                                                    }
                                                                                                                                }

                                                                                                                                if (!(success_1)) {
                                                                                                                                    Tuple tuplePattern_32 =
                                                                                                                                        Utils.copy(casesExp_1);
                                                                                                                                    success_1 = tuplePattern_32.compatible(Number.class,
                                                                                                                                            Number.class);

                                                                                                                                    if (success_1) {
                                                                                                                                        Number intPattern_63 =
                                                                                                                                            ((Number) tuplePattern_32.get(0));
                                                                                                                                        success_1 = Utils.equals(intPattern_63,
                                                                                                                                                6L);

                                                                                                                                        if (success_1) {
                                                                                                                                            Number intPattern_64 =
                                                                                                                                                ((Number) tuplePattern_32.get(1));
                                                                                                                                            success_1 = Utils.equals(intPattern_64,
                                                                                                                                                    5L);
                                                                                                                                        }
                                                                                                                                    }

                                                                                                                                    if (success_1) {
                                                                                                                                        casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                                    } else {
                                                                                                                                        casesExpResult_1 = null;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    casesExpResult_1 = new Square(quantum.quotes.WhiteQuote.getInstance());
                                                                                                                }
                                                                                                            } else {
                                                                                                                casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                                            }
                                                                                                        } else {
                                                                                                            casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                                        }
                                                                                                    } else {
                                                                                                        casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                                    }
                                                                                                } else {
                                                                                                    casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                                }
                                                                                            } else {
                                                                                                casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                            }
                                                                                        } else {
                                                                                            casesExpResult_1 = new Circle(quantum.quotes.WhiteQuote.getInstance());
                                                                                        }
                                                                                    } else {
                                                                                        casesExpResult_1 = new Cross(quantum.quotes.WhiteQuote.getInstance());
                                                                                    }
                                                                                } else {
                                                                                    casesExpResult_1 = new Cross(quantum.quotes.WhiteQuote.getInstance());
                                                                                }
                                                                            } else {
                                                                                casesExpResult_1 = new Cross(quantum.quotes.WhiteQuote.getInstance());
                                                                            }
                                                                        } else {
                                                                            casesExpResult_1 = new Cross(quantum.quotes.WhiteQuote.getInstance());
                                                                        }
                                                                    } else {
                                                                        casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                                    }
                                                                } else {
                                                                    casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                                }
                                                            } else {
                                                                casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                            }
                                                        } else {
                                                            casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                        }
                                                    } else {
                                                        casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                    }
                                                } else {
                                                    casesExpResult_1 = new Square(quantum.quotes.BlackQuote.getInstance());
                                                }
                                            } else {
                                                casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                                            }
                                        } else {
                                            casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                                        }
                                    } else {
                                        casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                                    }
                                } else {
                                    casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                                }
                            } else {
                                casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                            }
                        } else {
                            casesExpResult_1 = new Circle(quantum.quotes.BlackQuote.getInstance());
                        }
                    } else {
                        casesExpResult_1 = new Cross(quantum.quotes.BlackQuote.getInstance());
                    }
                } else {
                    casesExpResult_1 = new Cross(quantum.quotes.BlackQuote.getInstance());
                }
            } else {
                casesExpResult_1 = new Cross(quantum.quotes.BlackQuote.getInstance());
            }
        } else {
            casesExpResult_1 = new Cross(quantum.quotes.BlackQuote.getInstance());
        }

        {
            Object piece = casesExpResult_1;

            return new Tile(x, y, ((Piece) piece));
        }
    }

    public static Board getInstance() {
        return boardInstance;
    }

    public void setBoardType(final Boolean bigBoard) {
        if (bigBoard) {
            VDMSeq seqCompResult_1 = SeqUtil.seq();
            VDMSet set_1 = SetUtil.range(1L, bigSizeY);

            for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext();) {
                Number i = ((Number) iterator_1.next());
                VDMSeq seqCompResult_2 = SeqUtil.seq();
                VDMSet set_2 = SetUtil.range(1L, bigSizeX);

                for (Iterator iterator_2 = set_2.iterator();
                        iterator_2.hasNext();) {
                    Number j = ((Number) iterator_2.next());
                    seqCompResult_2 = SeqUtil.conc(Utils.copy(seqCompResult_2),
                            SeqUtil.seq(buildBoard(j, i)));
                }

                seqCompResult_1 = SeqUtil.conc(Utils.copy(seqCompResult_1),
                        SeqUtil.seq(Utils.copy(seqCompResult_2)));
            }

            board = Utils.copy(seqCompResult_1);
        } else {
            VDMSeq seqCompResult_3 = SeqUtil.seq();
            VDMSet set_3 = SetUtil.range(1L, smallSizeY);

            for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext();) {
                Number i = ((Number) iterator_3.next());
                VDMSeq seqCompResult_4 = SeqUtil.seq();
                VDMSet set_4 = SetUtil.range(1L, smallSizeX);

                for (Iterator iterator_4 = set_4.iterator();
                        iterator_4.hasNext();) {
                    Number j = ((Number) iterator_4.next());
                    seqCompResult_4 = SeqUtil.conc(Utils.copy(seqCompResult_4),
                            SeqUtil.seq(buildBoard(j, i)));
                }

                seqCompResult_3 = SeqUtil.conc(Utils.copy(seqCompResult_3),
                        SeqUtil.seq(Utils.copy(seqCompResult_4)));
            }

            board = Utils.copy(seqCompResult_3);
        }
    }

    public Tile getTile(final Number x, final Number y) {
        return ((Tile) Utils.get(((VDMSeq) Utils.get(board, x)), y));
    }

    public String toString() {
        return "Board{" + "smallSizeX = " + Utils.toString(smallSizeX) +
        ", smallSizeY = " + Utils.toString(smallSizeY) + ", bigSizeX = " +
        Utils.toString(bigSizeX) + ", bigSizeY = " + Utils.toString(bigSizeY) +
        ", board := " + Utils.toString(board) + ", boardInstance := " +
        Utils.toString(boardInstance) + "}";
    }
}
