package ch.thesurvey.configuration;

import ch.thesurvey.service.CustomUserDetailsService;
import ch.thesurvey.service.UserService;
import ch.thesurvey.service.interfaces.IUserService;
import ch.thesurvey.utility.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

/**
 * Created by sam on 08.11.16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public PasswordStorage passwordEncoder() {
        return new PasswordStorage();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }

    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, status from user where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user where username=?");
    }
    */

    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .maximumSessions(10)
                .expiredUrl("/signup");

        http.sessionManagement()
                .sessionFixation()
                .migrateSession();

        http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/*").access("hasRole('ROLE_USER')");

        http.formLogin()
                .successForwardUrl("/")
                .and()
                .logout()
                    .logoutSuccessUrl("/signup?logout")
                .and()
                .exceptionHandling()
                    .accessDeniedPage("/403")
                .and()
                .csrf();
    }
}