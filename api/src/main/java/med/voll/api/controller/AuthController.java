package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.AuthRequestDTO;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signin")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity<String> signIn(@RequestBody @Valid AuthRequestDTO request) {

        var token = new UsernamePasswordAuthenticationToken(request.login(), request.password());
        Authentication authentication = manager.authenticate(token);

        return ResponseEntity.ok(service.gerarToken((User) authentication.getPrincipal()));
    }
}























