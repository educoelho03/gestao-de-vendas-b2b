package br.com.gestao_vendas_b2b.utils;

import org.springframework.web.filter.OncePerRequestFilter;

public abstract class AuthTokenFilter extends OncePerRequestFilter { // classe responsavel por validar os tokens de entrada e autenticar o usuario se estiver valido

    private JwtUtils jwtUtils;

    private Customer

}
