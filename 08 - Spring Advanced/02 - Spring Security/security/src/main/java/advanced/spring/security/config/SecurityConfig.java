package advanced.spring.security.config;

import advanced.spring.security.user.DemoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
//    private DataSource dataSource;
    private final DemoUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, DemoUserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
           .antMatchers("h2_console/**", "/home").permitAll()
           .antMatchers("/admin").hasRole("ADMIN")
           .antMatchers("/user").hasRole("USER")
           .and()
           .formLogin();

        //h2 magic, TODO: delete me
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
           .userDetailsService(userDetailsService)
           .passwordEncoder(passwordEncoder);

//        auth
////           .inMemoryAuthentication()
//           .jdbcAuthentication()
//           .withDefaultSchema()
//           .dataSource(dataSource)
//           .passwordEncoder(passwordEncoder)
//           .withUser("user")
//           .password(passwordEncoder.encode("user")).roles("USER")
//           .and()
//           .withUser("admin")
//           .password(passwordEncoder.encode("admin")).roles("ADMIN", "USER");

    }
}
