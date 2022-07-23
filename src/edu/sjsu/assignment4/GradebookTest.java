package edu.sjsu.assignment4;

import edu.sjsu.assignment2.MyTime;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTest {
    HashMap<Student, Character> studentsMap = new HashMap<>();

    @Test
    void addStudent() {
        Gradebook addStudent = new Gradebook();
        assertEquals(true , addStudent(new Student(3 , "Alice") , 'A'));
        assertEquals(true , addStudent(new Student(4 , "Alice") , 'A'));
        assertEquals(true , addStudent(new Student(1 , "Bob") , 'I'));
        assertEquals(true , addStudent(new Student(5) , 'B'));
        assertEquals(false , addStudent(new Student(5 , "Eve") , 'D'));
        assertEquals(false , addStudent(new Student(1 , "Trudy") , ' '));
        assertEquals(true , addStudent(new Student(2 , "Cathy") , ' '));
        System.out.println(studentsMap);

    }

    private boolean addStudent(Student student , char grade) {
        if (studentsMap.containsKey(student))
            return false;
        if (!isValidGrade(grade))
            grade = 'N';
        studentsMap.put(student , grade);
        return true;
    }

    private boolean isValidGrade(char grade) {
        return "ABCDFN".contains(String.valueOf(grade));
    }


    @Test
    void deleteStudent() {
        this.studentsMap = studentsMap;
        // Recall the studentMap after add Student
        // {1.Bob: =N, 2.Cathy: =N, 3.Alice: =A, 4.Alice: =A, 5.Unnamed: =B}
        addStudent(new Student(3 , "Alice") , 'A');
        addStudent(new Student(4 , "Alice") , 'A');
        addStudent(new Student(1 , "Bob") , 'I');
        addStudent(new Student(5) , 'B');
        addStudent(new Student(5 , "Eve") , 'D');
        addStudent(new Student(1 , "Trudy") , ' ');
        addStudent(new Student(2 , "Cathy") , ' ');
        System.out.println("Before add student : " + studentsMap);

        // Test deleteStudent() function
        Gradebook deleteStudent = new Gradebook();
        assertEquals(true , deleteStudent(4));
        assertEquals(false , deleteStudent(6));
        assertEquals(false , deleteStudent(4));
        System.out.println("After add student : " + studentsMap);
    }

    private boolean deleteStudent(int id) {
        Student toRemove = new Student(id);
        return studentsMap.remove(toRemove) != null;
    }

    @Test
    void updateStudent() {
        // Recall the studentMap after add Student
        // {1.Bob: =N, 2.Cathy: =N, 3.Alice: =A, 5.Unnamed: =B}
        addStudent(new Student(3 , "Alice") , 'A');
        addStudent(new Student(4 , "Alice") , 'A');
        addStudent(new Student(1 , "Bob") , 'I');
        addStudent(new Student(5) , 'B');
        addStudent(new Student(5 , "Eve") , 'D');
        addStudent(new Student(1 , "Trudy") , ' ');
        addStudent(new Student(2 , "Cathy") , ' ');
        deleteStudent(4);
        deleteStudent(6);
        deleteStudent(4);
        System.out.println("Before update student : " + studentsMap);
        // Test updateStudent() function
        Gradebook updateStudent = new Gradebook();
        assertEquals(true , updateStudent(5 , "Denny"));
        assertEquals(true , updateStudent(5 , "Dennis"));
        assertEquals(true , updateStudent(3 , "Bob"));
        assertEquals(false , updateStudent(4 , "Cathy"));
        assertEquals(false , updateStudent(6 , "Eve"));
        System.out.println("After update student : " + studentsMap);
    }

    public boolean updateStudent(int id , String newName) {
        Student toUpdate = new Student(id , newName);
        Character grade = studentsMap.remove(toUpdate);
        if (grade == null) return false;
        studentsMap.put(toUpdate , grade);
        return true;
    }

    @Test
    void updateGrade() {
        this.studentsMap = studentsMap;
        // Recall the studentMap after add Student
        // {1.Bob: =N, 2.Cathy: =N, 3.Bob: =A, 5.Dennis: =B}
        addStudent(new Student(3 , "Alice") , 'A');
        addStudent(new Student(4 , "Alice") , 'A');
        addStudent(new Student(1 , "Bob") , 'I');
        addStudent(new Student(5) , 'B');
        addStudent(new Student(5 , "Eve") , 'D');
        addStudent(new Student(1 , "Trudy") , ' ');
        addStudent(new Student(2 , "Cathy") , ' ');
        deleteStudent(4);
        deleteStudent(6);
        deleteStudent(4);
        updateStudent(5 , "Denny");
        updateStudent(5 , "Dennis");
        updateStudent(3 , "Bob");
        updateStudent(4 , "Cathy");
        updateStudent(6 , "Eve");
        System.out.println("Before update grade : " + studentsMap);
        // Test updateGrade() function
        Gradebook updateGrade = new Gradebook();
        assertEquals(true , updateGrade(3 , 'A'));
        assertEquals(true , updateGrade(3 , 'B'));
        assertEquals(true , updateGrade(5 , 'C'));
        assertEquals(false , updateGrade(6 , 'A'));
        assertEquals(false , updateGrade(1 , 'J'));
        System.out.println("After update grade : " + studentsMap);
    }

    public boolean updateGrade(int id , char newGrade) {
        Student updateGrade = new Student(id);
        if (!studentsMap.containsKey(updateGrade))
            return false;
        if (!isValidGrade(newGrade)) return false;
        if (studentsMap.containsKey(updateGrade))
            studentsMap.put(updateGrade , newGrade);
        return true;
    }


    @Test
    void printGrades() {
        this.studentsMap = studentsMap;
        // Recall the studentMap after add Student
        // {1.Bob: =N, 2.Cathy: =N, 3.Bob: =B, 5.Dennis: =C}
        addStudent(new Student(3 , "Alice") , 'A');
        addStudent(new Student(4 , "Alice") , 'A');
        addStudent(new Student(1 , "Bob") , 'I');
        addStudent(new Student(5) , 'B');
        addStudent(new Student(5 , "Eve") , 'D');
        addStudent(new Student(1 , "Trudy") , ' ');
        addStudent(new Student(2 , "Cathy") , ' ');
        deleteStudent(4);
        deleteStudent(6);
        deleteStudent(4);
        updateStudent(5 , "Denny");
        updateStudent(5 , "Dennis");
        updateStudent(3 , "Bob");
        updateStudent(4 , "Cathy");
        updateStudent(6 , "Eve");
        updateGrade(3 , 'A');
        updateGrade(3 , 'B');
        updateGrade(5 , 'C');
        updateGrade(6 , 'A');
        updateGrade(1 , 'J');
        System.out.println("Before print grade ordered by name : " + studentsMap);
        // Test printGrades() function
        Gradebook printGrades = new Gradebook();
        Comparator<Student> studentsMap = new Comparator<Student>() {
            @Override
            public int compare(Student o1 , Student o2) {
                if (o1.getName() != o2.getName())
                    return o1.getName().compareTo(o2.getName());
                else if (o1.getName() == o2.getName())
                    return o1.getId() - (o2.getId());
                return 0;
            }
        };

        String result = new String("1.Bob: N" + "\n" +
                "3.Bob: B" + "\n" +
                "2.Cathy: N" + "\n" +
                "5.Dennis: C");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));
        printGrade(studentsMap);
        assertEquals(result , outputStream.toString().trim());
    }

    private void printGrade(Comparator<Student> comparator) {
        TreeMap<Student, Character> sorted = new TreeMap<>(comparator);
        sorted.putAll(studentsMap);
        sorted.forEach((student , grade) ->
                System.out.println(student + "" + grade)
        );
    }
}