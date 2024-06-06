package peaksoft.restapilessonjava13.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restapilessonjava13.enitity.Student;
import peaksoft.restapilessonjava13.repository.StudentRepository;
import peaksoft.restapilessonjava13.service.StudentService;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new NullPointerException(String.format("Student with id %d not found", id)));

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public String deleteStudent(Long id) {
        return null;
    }

    @Override
    public Student getByEmail(String email) {
        return studentRepository.getStudentByEmail(email);
    }
}
