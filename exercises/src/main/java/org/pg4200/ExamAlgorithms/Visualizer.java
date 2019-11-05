package org.pg4200.ExamAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Visualizer {

    protected static class Student {
        String name;
        Subject[] subjects;
        int age;


        public Student(String name, Subject[] subjects, int age) {
            this.name = name;
            this.subjects = subjects;
            this.age = age;
        }
    }

    protected static class Subject {
        String subjectName;
        String lecturer;

        public Subject(String subjectName, String lecturer) {
            this.subjectName = subjectName;
            this.lecturer = lecturer;
        }
    }

    public static void main(String[] args) {
        Subject[] subjects = new Subject[6];
        subjects[0] = new Subject("PG4200", "Andrea");
        subjects[1] = new Subject("TEK304", "Gebremariam");
        subjects[2] = new Subject("TDS200", "Andreas");
        subjects[3] = new Subject("Foo", "Andrea");
        subjects[4] = new Subject("Bar", "Andreas");
        subjects[5] = new Subject("Test", "Andreas");


        List<Student> students = new ArrayList();

        students.add(new Student("Markus", subjects, 23));
        students.add(new Student("Andreas", subjects, 20));
        students.add(new Student("Karoline", subjects, 24));
        students.add(new Student("Kverner", subjects, 23));
        students.add(new Student("Alf", subjects, 20));
        students.add(new Student("Scooby", subjects, 24));



        students.stream()
                .flatMap(s -> Stream.of(s.subjects)
                        .filter(su -> su.lecturer == "Gebremariam")
                )
                .distinct()
                .forEach(su -> System.out.println(su.subjectName));

    }
}
