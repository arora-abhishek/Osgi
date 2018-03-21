package org.osgi.project.service;

import org.osgi.project.Student;

import java.util.List;

public interface StudentApplication {

    boolean isClassLimitReached(List<Student> a);

    int getPassingMarks();
}
