package com.example.postexamples;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class MethodNamingConventions {

    @Test
    void method_naming_conventions() {
        // of (static factory)
        String str1 = "123456";
        System.out.println(str1.indexOf("1")); // 0
        System.out.println(str1.indexOf("2")); // 1
        // str1.{index}Of({arg}) -> str1 의 {arg} 값의 index 를 줘

        StringArray of = StringArray.of(1, 2, 3, 4, 5, 6);
        System.out.println(of.toString()); // [1, 2, 3, 4, 5, 6]
        // {StringArray}.of({arg}); -> {arg} 를 검증해서 {StringArray} 인스턴스를 줘

        // from (static factory)
        StringArray from = StringArray.from("1,2,3,4,5,6", ":");
        System.out.println(from.toString()); // [1,2,3,4,5,6]
        // {StringArray}.from({arg}) -> {arg} 를 변경해서 {StringArray} 인스턴스 를 줘

        // parse (static factory)
        int parseInt = Integer.parseInt("1");
        System.out.println(parseInt); // 1
        // {Integer}.parseInt({arg}) -> {arg} 를 Int 로 parse 해줘

        // format (instance)
        String stringFormat = String.format("%s 포맷팅합니다.", "문자열");
        System.out.println(stringFormat); // "문자열 포맷팅합니다."
        // 입력 값을 포매팅해서 반환합니다.
        // {String}.format({arg}) -> {arg}를 포맷팅해서 {String} 으로 줘

        // get (instance)
        List<String> stringList = new ArrayList<>();
        stringList.add("첫번째 String");
        stringList.add("두번째 String");
        System.out.println(stringList.get(0)); // "안녕 String"
        // {instance}.get({arg}) -> {instance} 의 {arg} 번째 데이터를 줘

        // is (instance)
        String empty = "";
        System.out.println(empty.isEmpty()); // true
        // {instance}.is{Status}() -> {instance} 가 {Status} 이냐? 맞으면 true , 틀리면 false

        // to (instance)
        Integer number = 1234;
        System.out.println(number.toString()); // "1234"
        // {number}.to{String} -> {number} 를 {String} 으로 변환해줘

        // at (instance)
        String str = "adasd";
        System.out.println(str.charAt(1));
        // str.{char}At(arg) -> str 의 {arg} index 의 값을 {char} 로 반환해줘

    }
}

class Number {
    private final int number;

    private Number(int i) {
        this.number = i;
    }

    public static Number of(int i) {
        return new Number(i);
    }

}

class StringArray {
    private final List<String> stringArray;

    private StringArray(List<String> array) {
        this.stringArray = array;
    }

    public static StringArray of(int... ints) {
        return new StringArray(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.toList()));
    }

    public static StringArray from(String str, String delimiter) {
        return new StringArray(List.of(str.split(delimiter)));
    }

    public static StringArray parse(String str, String delimiter) {
        return new StringArray(List.of(str.split(delimiter)));
    }

    @Override
    public String toString() {
        return stringArray.toString();
    }
}
