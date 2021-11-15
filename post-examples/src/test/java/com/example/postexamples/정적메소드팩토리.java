package com.example.postexamples;

import org.junit.jupiter.api.Test;

public class 정적메소드팩토리 {

    @Test
    void sutudent() {

        System.out.println(Student2.createWithDefaultGrade("name", "우리반")
            .toString()); //Student2{name='name', className='우리반', grade='1학년'}
    }
}

class Student {
    private final String name;
    private final String className;
    private final String grade;

    public Student(String name, String className, String grade) {
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
        this.grade = "1학년";
    }
}

class Student2 {
    public static final String GRADE = "1학년";

    private final String name;
    private final String className;
    private final String grade;

    private Student2(String name, String className, String grade) {
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public static Student2 of(String name, String className, String grade) {
        return new Student2(name, className, grade);
    }

    public static Student2 createWithDefaultGrade(String name, String className) {
        return new Student2(name, className, GRADE);
    }

    @Override
    public String toString() {
        return "Student2{" +
            "name='" + name + '\'' +
            ", className='" + className + '\'' +
            ", grade='" + grade + '\'' +
            '}';
    }
}