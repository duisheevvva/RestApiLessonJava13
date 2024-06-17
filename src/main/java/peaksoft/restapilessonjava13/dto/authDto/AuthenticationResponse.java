package peaksoft.restapilessonjava13.dto.authDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import peaksoft.restapilessonjava13.enums.Role;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String email;
    private Role role;
}
