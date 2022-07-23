package edu.sjsu.assignment4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// published at:https://liulingdu.github.io/edu/sjsu/assignment4/Gradebook.html

/**
 * Gradebook class
 */

public class Gradebook {
    HashMap<Student, Character> studentsMap = new HashMap<>();
    //private HashMap<Student, Character> studentsMap;
    private Student student;

    public Gradebook() {
        this.studentsMap = studentsMap;
    }

    /**
     * Add the student and grade to the map and return true if added successfully
     *
     * @param student
     * @param grade
     * @return true if added successfully
     */
    public boolean addStudent(Student student , char grade) {
        if (studentsMap.containsKey(student))
            return false;
        if (!isValidGrade(grade))
            grade = 'N';
        studentsMap.put(student , grade);
        return true;
    }

    /**
     * Check whether the grade is valid
     *
     * @param grade
     * @return true if grade is valid
     */
    private boolean isValidGrade(char grade) {
        return "ABCDFN".contains(String.valueOf(grade));
    }

    /**
     * Add the student to the map
     *
     * @param student
     * @return true if added successfully
     */
    public boolean addStudent(Student student) {
        return addStudent(student , 'N');
    }

    /**
     * Delete the corresponding student with the id from the map
     *
     * @param id
     * @return true if removed successfully
     */
    public boolean deleteStudent(int id) {
        Student toRemove = new Student(id);
        return studentsMap.remove(toRemove) != null;
    }

    /**
     * Update the name of the corresponding student with the id from the map to newName
     *
     * @param id
     * @param newName
     * @return true if updated successfully.
     */
    public boolean updateStudent(int id , String newName) {
        Student toUpdate = new Student(id , newName);
        Character grade = studentsMap.remove(toUpdate);
        if (grade == null) return false;
        studentsMap.put(toUpdate , grade);
        return true;
    }

    /**
     * Update the grade of the corresponding student with the id from the map to newGrade
     *
     * @param id
     * @param newGrade
     * @return true if the grade is updated successfully.
     */
    public boolean updateGrade(int id , char newGrade) {
        Student updateGrade = new Student(id);
        if (!studentsMap.containsKey(updateGrade))
            return false;
        if (!isValidGrade(newGrade)) return false;
        if (studentsMap.containsKey(updateGrade))
            studentsMap.put(updateGrade , newGrade);
        return true;
    }

    /**
     * Print the students with the grade
     *
     * @param comparator print grades ordered by name
     */
    public void printGrades(Comparator<Student> comparator) {
        TreeMap<Student, Character> sorted = new TreeMap<>(comparator);
        sorted.putAll(studentsMap);
        sorted.forEach((student , grade) ->
                System.out.println(student + "" + grade)
        );
    }
}