package org.launchcode;

import java.util.Objects;

public class Student {

    private static int nextStudentId = 1;
    private String name;
    private int studentId;
    private int numberOfCredits = 0;
    private double gpa = 0.0;

    public Student (String name, int studentId, int numberOfCredits, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.numberOfCredits = numberOfCredits;
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentId);
    }

    public Student(String name, int studentId) {
        this(name, studentId, 0, 0);
    }

    public Student(String name) {
        this(name, nextStudentId);
        nextStudentId++;
    }

    public String studentInfo() {
        return (this.name + " has a GPA of: " + this.gpa);
    }


    //TODO: Uncomment and complete the getGradeLevel method here:
    public String getGradeLevel(Student student) {
        // Determine the grade level of the student based on numberOfCredits
        //Freshman (0-29 credits), Sophomore (30-59 credits), Junior (60-89 credits), or Senior (90+ credits).
        String studentLevel = "";
        if (student.getNumberOfCredits() >= 0 && student.getNumberOfCredits() <= 29) {
                studentLevel = "Freshman";
        }
        if (student.getNumberOfCredits() >= 30 && student.getNumberOfCredits() <= 59) {
            studentLevel = "Sophomore";
        }
        if (student.getNumberOfCredits() >= 60 && student.getNumberOfCredits() <= 89) {
            studentLevel = "Junior";
        }
        if (student.getNumberOfCredits() >= 90) {
            studentLevel = "Senior";
        }

        return studentLevel;
    }

    // TODO: Complete the addGrade method.
    public void addGrade(int courseCredits, double grade) {
        // Update the appropriate fields: numberOfCredits, gpa
        //This method accepts two parameters—a number of course credits and a numerical grade (0.0-4.0).
        // With this data, you need to update the student’s GPA.
      double gpa = 0.0;
      int totalQualityScore = 0;
      int qualityScore = 0;
      int updatedCourseCreditCount = 0;
      
      updatedCourseCreditCount = courseCredits + this.getNumberOfCredits();
      this.setNumberOfCredits(updatedCourseCreditCount);
      qualityScore = (int)grade * courseCredits;
      totalQualityScore = ((int)getGpa() * getNumberOfCredits()) + qualityScore;
      this.gpa = (double) totalQualityScore /getNumberOfCredits();



    }

    // TODO: Add your custom 'toString' method here. Make sure it returns a well-formatted String rather
    //  than just the class fields.

    // TODO: Add your custom 'equals' method here. Consider which fields should match in order to call two
    //  Student objects equal.

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    private void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public static void main(String[] args) {
        Student sally = new Student("Sally",1,1,4.0);
        System.out.println("The Student class works! " + sally.getName() + " is a student!");
        System.out.println(sally);
        sally.addGrade(12, 3.5);
        System.out.println(sally);
        sally.addGrade(25, 3.8);
        System.out.println(sally);
    }
}