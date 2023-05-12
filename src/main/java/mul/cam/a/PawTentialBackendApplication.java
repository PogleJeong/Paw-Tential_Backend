package mul.cam.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


// exclude 부분을 통해 보안관련설정완료
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class PawTentialBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawTentialBackendApplication.class, args);
	}
	
	
}
