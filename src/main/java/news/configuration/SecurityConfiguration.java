package news.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN").and()
                .withUser("user").password("user").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .anyRequest().permitAll();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
////              .antMatchers(HttpMethod.GET, "/api/systemDynamicOption").permitAll()        //system
//                .antMatchers(HttpMethod.GET, "/api/loginFormData").permitAll()              //login
//                .antMatchers(HttpMethod.POST, "/api/login").permitAll()                     //login
//                .antMatchers(HttpMethod.GET, "/api/userIdHeaderFieldName").permitAll()      //login
//                .antMatchers(HttpMethod.GET, "/api/isOrganizationRepository").permitAll()   //login
//                .antMatchers(HttpMethod.GET, "/api/loginFailurePageURL").permitAll()        //login
////                .antMatchers(HttpMethod.GET, "/api/IPMSessionID").permitAll()               //session <== dont like it
//                .antMatchers(HttpMethod.GET, "/api/isUserLoggedIn").permitAll()             //session <== dont like it
//                .antMatchers(HttpMethod.POST, "/api/recoverPassword").permitAll()
//                .anyRequest().authenticated()
//                //.anyRequest().permitAll()
//                .and()
//                .addFilterAt(new JWTAuthenticationFilter(authenticationManager, authenticationFailureHandler),
//                        UsernamePasswordAuthenticationFilter.class)
//                .addFilter(new JWTAuthorizationFilter(authenticationManager(), userManager))
//                // this disables session creation on Spring Security
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public CorsFilter corsFilter() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        //TODO restrict allow origins to only local angular :: configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
////        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//        configuration.addAllowedOrigin("*");
//        configuration.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.OPTIONS.name()));
//
//        configuration.setAllowedHeaders(
//                Arrays.asList(TokenAuthenticationService.HEADER_STRING, "Content-Type"));
//        configuration.setExposedHeaders(Arrays.asList(TokenAuthenticationService.HEADER_STRING, "Accept",
//                TokenAuthenticationService.EXP_TIME_HEADER));
//
//        configuration.setAllowCredentials(Boolean.TRUE);
//        configuration.setMaxAge(1800L); //30 min :: defines maximum age (in seconds) for cache to be alive for a pre-flight request
//
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/api/**", configuration);
//
//        return new CorsFilter(source);
//    }

}