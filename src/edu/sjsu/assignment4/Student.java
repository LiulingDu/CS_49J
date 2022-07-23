package edu.sjsu.assignment4;

import java.util.Objects;

// published at: https://liulingdu.github.io/edu/sjsu/assignment4/Student.html

/**
 * Student class
 */
public class Student {
    private final int id;
    private String name;

    public Student(int id , String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id) {
        this(id , "Unnamed");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Check student objects
     *
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    /**
     * @return hash code for a sequence of input values
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @return output students' info
     */
    @Override
    public String toString() {
        return String.format("%d.%s: " , id , name);
    }
}
