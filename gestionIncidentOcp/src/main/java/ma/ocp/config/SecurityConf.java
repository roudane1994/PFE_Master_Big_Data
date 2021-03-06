package ma.ocp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConf  extends WebSecurityConfigurerAdapter{
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//http.authorizeRequests().antMatchers("/incidents/**").hasAuthority("USER");
	
	//http.authorizeRequests().antMatchers("/incidents/**").permitAll();
	http.authorizeRequests().anyRequest().permitAll();
	http.addFilterBefore(new JWTAuthorizationFiler(),UsernamePasswordAuthenticationFilter.class);
	}

}
