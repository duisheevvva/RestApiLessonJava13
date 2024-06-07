package peaksoft.restapilessonjava13.service;

import peaksoft.restapilessonjava13.dto.SimpleResponse;
import peaksoft.restapilessonjava13.dto.studentDto.StudentRequest;
import peaksoft.restapilessonjava13.dto.studentDto.StudentResponse;
import peaksoft.restapilessonjava13.enitity.Student;

import java.util.List;

public interface StudentService {

    SimpleResponse saveStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Long id);

    List<StudentResponse> getAllStudents();

    SimpleResponse updateStudent(Long id, StudentRequest student);

    SimpleResponse deleteStudent(Long id);

    Student getByEmail(String email);

}
