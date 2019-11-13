package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.list.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Visualizer {

    public static void main(String[] args) {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));


        List<Student> students = Arrays.asList(student1, student2, student3);

        TempStudent tmpStud1 = new TempStudent(
                "Jayesh1",
                201,
                new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent(
                "Khyati1",
                202,
                new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

        //Find exact match for "Jayesh"
        students.stream()
                .filter(s -> s.name.equals("Jayesh"))
                .forEach(s -> System.out.println(s.name));

        //Find match for address "1235"
        students.stream()
                .map(s -> s.address)
                .filter(a -> a.zipcode.equals("1235"))
                .forEach(a -> System.out.println(a.zipcode));

        List studentNumbers = students.stream()
                .flatMap(s -> s.mobileNumbers.stream())
                .filter(m -> m.number.equals("3333"))
                .map(m -> m.number)
                .collect(Collectors.toList());

        System.out.println(studentNumbers);

        students.stream()
                .flatMap(s -> s.mobileNumbers.stream())
                .filter(n -> n.number.equals("1233") || n.number.equals("1234"))
                .forEach(n -> System.out.println(n.number));

        List<Student> fromTemp = tmpStudents.stream()
                .map(tmp -> new Student(tmp.name, tmp.age, tmp.address, tmp.mobileNumbers))
                .collect(Collectors.toList());

        System.out.println(fromTemp);


    }

    protected static class TempStudent {
        public String name;
        public int age;
        public Address address;
        public List<MobileNumber> mobileNumbers;

        public TempStudent(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.mobileNumbers = mobileNumbers;
        }
    }

    protected static class Student{
        private String name;
        private int age;
        private Address address;
        private List<MobileNumber> mobileNumbers;

        public Student(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.mobileNumbers = mobileNumbers;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Address getAddress() {
            return address;
        }

        public List<MobileNumber> getMobileNumbers() {
            return mobileNumbers;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
            this.mobileNumbers = mobileNumbers;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address=" + address +
                    ", mobileNumbers=" + mobileNumbers +
                    '}';
        }
    }

    protected static class Address{
        private String zipcode;

        public Address(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }

    protected static class MobileNumber{
        private String number;

        public MobileNumber(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

}
