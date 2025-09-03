package br.com.gestao_vendas_b2b.utils;

import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import br.com.gestao_vendas_b2b.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository; // seu repositório do banco de dados

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário no banco
        Funcionario funcionario = funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário com esse email nao encontrado: " + email));

        // Retorna uma instância de UserDetailsImpl
        return new UserDetailsImpl(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),  // username do login
                funcionario.getSenha()
        );
    }

    //USERNAME DO USUARIO SERA O SEU LOGIN
}
