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

    private FuncionarioRepository funcionarioRepository;

    public CustomerUserDetailsService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário com esse email nao encontrado: " + email));

        return new UserDetailsImpl(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getSenha()
        );
    }

    //USERNAME DO USUARIO SERA O SEU LOGIN
}
