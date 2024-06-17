package peaksoft.restapilessonjava13.dto.authDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SignInRequest {
    private String email;
    private String password;
}
