package com.example.postexamples;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class IteratorTest {
    @Test
    void iteratorTest() {
        // Make a collection
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        Iterator<String> iter = cars.iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            System.out.println("ArrayList : " + obj);
        }

        Set<String> setCars = new HashSet<>();
        setCars.add("Volvo");
        setCars.add("BMW");
        setCars.add("Ford");
        setCars.add("Mazda");


        Iterator<String> iter2 = setCars.iterator();
        while (iter2.hasNext()) {
            System.out.println("set : " + iter2.next());
        }


        assertThat(true).isTrue();
    }
}
