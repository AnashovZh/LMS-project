package zhanuzak.service;

import zhanuzak.dto.request.SignInRequest;
import zhanuzak.dto.request.SignRequest;
import zhanuzak.dto.request.SignUpRequest;
import zhanuzak.dto.response.AuthenticationResponse;
import zhanuzak.dto.response.SimpleResponse;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
    void init();

    SimpleResponse signIn2(SignRequest signRequest);

    SimpleResponse deleteUserById(Long id);

    SimpleResponse deleteUserByEmail(String email);
}
