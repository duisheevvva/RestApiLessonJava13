package peaksoft.restapilessonjava13.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(
            generator = "student_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

}