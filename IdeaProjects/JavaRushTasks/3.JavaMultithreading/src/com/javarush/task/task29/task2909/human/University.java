package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student:students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student maxAverageStudent = null;
        double maxAverage = 0;

        for (Student student:students) {
            if (student.getAverageGrade() > maxAverage){
                maxAverageStudent = student;
                maxAverage = student.getAverageGrade();
            }
        }
        return maxAverageStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student minAverageStudent = null;
        double minAverage = Double.MAX_VALUE;

        for (Student student:students) {
            if (student.getAverageGrade() < minAverage){
                minAverageStudent = student;
                minAverage = student.getAverageGrade();
            }
        }
        return minAverageStudent;
    }

    public void expel(Student student) {
        //TODO:
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student s = iter.next();
            if (s.getId() == student.getId()) iter.remove();
        }
    }


}