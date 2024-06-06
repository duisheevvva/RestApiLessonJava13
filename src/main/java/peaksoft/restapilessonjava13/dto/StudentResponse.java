package peaksoft.restapilessonjava13.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String fullName;
    private String email;
    private LocalDate createdDate;
    private LocalDate graduationDate;
    private boolean isBlocked;
}
