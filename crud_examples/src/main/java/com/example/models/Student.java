package com.example.models;

public class Student {
    private long studentNo;
    private String firstName;
    private String lastName;
    private String middleName;
    private int yearEnrolled;
    private String degree;

    public Student(long studentNo, String firstName, String lastName, int yearEnrolled, String degree) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearEnrolled = yearEnrolled;
        this.degree = degree;
    }

    public Student(long studentNo, String firstName, String middleName, String lastName, int yearEnrolled, String degree) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.yearEnrolled = yearEnrolled;
        this.degree = degree;
    }

    public long getStudentNo() {
        return this.studentNo;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public int getYearEnrolled() {
        return this.yearEnrolled;
    }

    public String getDegree() {
        return this.degree;
    }
}
