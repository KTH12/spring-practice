package com.example.postexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class CollectionsunmodifiableListTest {


    @Test
    void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);

        List<Integer> list2 = Collections.unmodifiableList(list);
        System.out.println(list.equals(list2));

        list.add(2);
        System.out.println(list);
        System.out.println(list2);

        list2.remove(1);
        list2.add(1);
    }
}

class LottoNumbers {
     List<Integer> lottoNumbers;

    public LottoNumbers(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void add(Integer number) {
        lottoNumbers.add(number);
    }

    public int getSize() {
        return lottoNumbers.size();
    }
}
