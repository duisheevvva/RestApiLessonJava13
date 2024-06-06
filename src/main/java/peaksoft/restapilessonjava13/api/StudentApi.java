package peaksoft.restapilessonjava13.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapilessonjava13.dto.SimpleResponse;
import peaksoft.restapilessonjava13.dto.StudentRequest;
import peaksoft.restapilessonjava13.dto.StudentResponse;
import peaksoft.restapilessonjava13.enitity.Student;
import peaksoft.restapilessonjava13.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;

    @PostMapping
    public SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/{id}/get")
    StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    List<StudentResponse>getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getEmail")
    Student getStudentByEmail(@RequestParam String email){
        return studentService.getByEmail(email);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateStudent(@PathVariable Long id,@RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id,studentRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
