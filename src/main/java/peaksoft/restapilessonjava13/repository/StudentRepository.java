package peaksoft.restapilessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapilessonjava13.dto.studentDto.StudentResponse;
import peaksoft.restapilessonjava13.enitity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select new peaksoft.restapilessonjava13.dto.studentDto.StudentResponse(" +
            "s.id," +
             "concat(u.firstName,' ',u.lastName) ,"+
            "u.email," +
            "s.createdDate," +
            "s.graduationDate," +
            "s.isBlocked)  from Student s join s.user u ")
    List<StudentResponse>findAllStudents();

    @Query("select new peaksoft.restapilessonjava13.dto.studentDto.StudentResponse(" +
            "s.id," +
            "concat(u.firstName,' ',u.lastName) ,"+
            "u.email," +
            "s.createdDate," +
            "s.graduationDate," +
            "s.isBlocked)  from Student s join s.user u where s.id=:id")
    Optional<StudentResponse> getStudentById(Long id);

    @Query("select new peaksoft.restapilessonjava13.dto.studentDto.StudentResponse( " +
            "s.id," +
            "concat(u.firstName,' ',u.lastName) ,"+
            "u.email," +
            "s.createdDate," +
            "s.graduationDate," +
            "s.isBlocked)  from Student s join s.user u where u.email = :email")
    StudentResponse getStudentByEmail(String email);
}
