package peaksoft.restapilessonjava13.service;

import peaksoft.restapilessonjava13.enitity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateStudent(Long id, Student student);

    String deleteStudent(Long id);

    Student getByEmail(String email);

}
