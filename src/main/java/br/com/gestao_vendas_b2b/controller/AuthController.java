package br.com.gestao_vendas_b2b.controller;

import br.com.gestao_vendas_b2b.model.dto.auth.JwtResponse;
import br.com.gestao_vendas_b2b.model.dto.auth.LoginRequest;
import br.com.gestao_vendas_b2b.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String token = authService.login(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
