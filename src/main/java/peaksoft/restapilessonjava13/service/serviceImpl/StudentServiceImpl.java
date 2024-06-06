package peaksoft.restapilessonjava13.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restapilessonjava13.dto.SimpleResponse;
import peaksoft.restapilessonjava13.dto.StudentRequest;
import peaksoft.restapilessonjava13.dto.StudentResponse;
import peaksoft.restapilessonjava13.enitity.Student;
import peaksoft.restapilessonjava13.repository.StudentRepository;
import peaksoft.restapilessonjava13.service.StudentService;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setPassword(studentRequest.getPassword());
        student.setCreatedDate(LocalDate.now());
        student.setGraduationDate(studentRequest.getGraduationDate());
        student.setBlocked(false);
        studentRepository.save(student);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student with id " + student.getId() + " is saved"
        );
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAllStudents();
    }


    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.getStudentById(id).orElseThrow(
                () -> new NullPointerException(String.format("Student with id %d not found", id)));
    }


    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("Student with id %d not found", id)));
        oldStudent.setFirstName(studentRequest.getFirstName());
        oldStudent.setLastName(studentRequest.getLastName());
        oldStudent.setEmail(studentRequest.getEmail());
        oldStudent.setPassword(studentRequest.getPassword());
        oldStudent.setGraduationDate(studentRequest.getGraduationDate());
        studentRepository.save(oldStudent);
        return new SimpleResponse(
                HttpStatus.OK,
                "Student with id " + oldStudent.getId() + " is updated"
        );
    }

    @Override
    public SimpleResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
        return  SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message( "Student with id " + id + " was deleted")
                .build();

    }

    @Override
    public Student getByEmail(String email) {
        return studentRepository.getStudentByEmail(email);
    }
}
