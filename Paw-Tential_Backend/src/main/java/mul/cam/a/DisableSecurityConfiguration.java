package mul.cam.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

//보안관련 class 설정
@Profile("psdev")
@Configuration
@Component("disableSecurityConfigurationBean")
//@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class DisableSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
        web
        	.ignoring()
        	.antMatchers("/**");
    }
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        	.authorizeRequests()
        	.antMatchers("/")
        	.permitAll();
    }	
}
