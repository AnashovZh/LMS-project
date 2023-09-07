package zhanuzak.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhanuzak.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "AuthenticationApi")
public class AuthenticationApi {
    private AuthenticationService authenticationService;
    @PostMapping("/signUp")
@Operation(summary = "Sign up",description = "To sign up fill ")
}
