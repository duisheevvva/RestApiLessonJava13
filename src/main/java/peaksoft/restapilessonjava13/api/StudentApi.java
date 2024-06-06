package peaksoft.restapilessonjava13.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapilessonjava13.enitity.Student;
import peaksoft.restapilessonjava13.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/get")
    Student getStudentById(@RequestParam Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    List<Student>getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getEmail")
    Student getStudentByEmail(@RequestParam String email){
        return studentService.getByEmail(email);
    }

}
