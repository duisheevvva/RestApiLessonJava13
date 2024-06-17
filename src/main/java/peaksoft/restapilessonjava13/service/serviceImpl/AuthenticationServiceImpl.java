package peaksoft.restapilessonjava13.service.serviceImpl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.restapilessonjava13.config.JwtService;
import peaksoft.restapilessonjava13.dto.authDto.AuthenticationResponse;
import peaksoft.restapilessonjava13.dto.authDto.SignInRequest;
import peaksoft.restapilessonjava13.dto.authDto.SignUpRequest;
import peaksoft.restapilessonjava13.enitity.User;
import peaksoft.restapilessonjava13.enums.Role;
import peaksoft.restapilessonjava13.repository.UserRepository;
import peaksoft.restapilessonjava13.service.AuthenticationService;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @PostConstruct
    public void initSaveAdmin() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Adminov");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("Admin123"));
        user.setRole(Role.ADMIN);
        if (!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
        }
    }


    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EntityExistsException(String.format(
                    "User with email: %s already exists!", signUpRequest.getEmail()));
        }

        User user = User.builder()
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        userRepository.save(user);

        String jwtToken = jwtService.createToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }


    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with email: " + signInRequest.getEmail() + " not found"
                ));

        if(signInRequest.getEmail().isBlank()){
            throw new BadCredentialsException("Email doesn't exist!");
        }

        if(!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())){
            throw new BadCredentialsException("Incorrect password!");
        }

        String jwtToken=jwtService.createToken(user);

        return AuthenticationResponse
                .builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtToken)
                .build();
    }
}
