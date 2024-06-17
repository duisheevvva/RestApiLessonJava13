package peaksoft.restapilessonjava13.service;


import peaksoft.restapilessonjava13.dto.authDto.AuthenticationResponse;
import peaksoft.restapilessonjava13.dto.authDto.SignInRequest;
import peaksoft.restapilessonjava13.dto.authDto.SignUpRequest;

public interface AuthenticationService {

    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
}
