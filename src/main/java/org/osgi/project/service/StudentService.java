package org.osgi.project.service;

import org.osgi.project.Student;

import java.util.List;

public interface StudentService {

    public void addStudent(Student student);

    public void deleteStudent(int id);

    public boolean isStudentPassed(int id);

    public Student getStudent(int id);

    public List getAllStudents();

}
