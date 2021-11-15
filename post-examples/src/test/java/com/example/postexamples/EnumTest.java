package com.example.postexamples;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void simpleTest() {
        LottoRank lottoRank = new LottoRank();

        int matchedCount = 6;

        Long prize = lottoRank.getPrize(matchedCount);
        System.out.println(prize);
    }

    @Test
    void LottoRankEnumTest() {
        LottoRankEnum lottoRankEnum = LottoRankEnum.valueOf(6);
        System.out.println(lottoRankEnum.prize);
    }
}

enum LottoRankEnum {
    FIRST(6, 1_000_000L),
    SECOND(5, 80_000L),
    THIRD(4, 5_000L),
    FOURTH(3, 1_000L),
    NONE(0, 0L);

    public int matchedCount; // 당첨된 로또 갯수
    public long prize; // 상금

    LottoRankEnum(int matchedCount, Long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static LottoRankEnum valueOf(int matchedCount) {
        return Arrays.stream(values())
            .filter(lottoRankEnum -> lottoRankEnum.matchedCount == matchedCount)
            .findFirst().orElse(NONE);

    }
}

class LottoRank {
    private final static Long FIRST_PRIZE = 1000000L;
    private final static Long SECOND_PRIZE = 80000L;
    private final static Long THIRD_PRIZE = 5000L;
    private final static Long FOURTH_PRIZE = 1000L;
    private final static Long NONE_PRIZE = 0L;

    private final static int MATCHED_COUNT_FIRST = 6;
    private final static int MATCHED_COUNT_SECOND = 5;
    private final static int MATCHED_COUNT_THIRD = 4;
    private final static int MATCHED_COUNT_FOURTH = 3;

    public Long getPrize(int matchedCount) {
        switch (matchedCount) {
            case MATCHED_COUNT_FIRST:
                return FIRST_PRIZE;
            case MATCHED_COUNT_SECOND:
                return SECOND_PRIZE;
            case MATCHED_COUNT_THIRD:
                return THIRD_PRIZE;
            case MATCHED_COUNT_FOURTH:
                return FOURTH_PRIZE;
        }
        return 0L;
    }
}
