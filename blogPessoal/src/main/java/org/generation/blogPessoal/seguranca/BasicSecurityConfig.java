package org.generation.blogpessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override // SUBSCREVENDO UM METODO QUE EXISTE DENTRO DO 'USERDETAUKSSERVICE'
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder senhaEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override // LIBERA ALGUNS CAMINHOS DENTRO DO CONTROLLE, PARA QUE O CLIENTE TENHA ACESSO A
              // ELE, SEM TOKEN
    protected void configure(HttpSecurity htpp) throws Exception {
        htpp.authorizeRequests().antMatchers("/usuario/logar").permitAll().antMatchers("/usuario/cadastrar").permitAll()
                .antMatchers("/usuario/atualizar").permitAll().anyRequest().authenticated() // SOLICITANDO TOKEN PARA
                                                                                            // TUDO QUE NAO SEJA O
                                                                                            // ENDPOINTS ACIMA
                .and().httpBasic() // UTILIZANDO O PADRAO BASIC PARA GERAR A CHAVE TOKEN
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // INDICAR QUAL É O
                                                                                                  // TIPO DE SESSÃO QUE
                                                                                                  // VAMOS UTILIZAR
                .and().cors() // HABILITANDO O CORS
                .and().csrf().disable(); // DESABILITANDO O CSRF (ESTAMOS UTILIZANDO TODOS AS CONF PADRAO)
    }
}
