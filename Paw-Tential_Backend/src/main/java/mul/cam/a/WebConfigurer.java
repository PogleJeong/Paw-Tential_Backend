package mul.cam.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration		// 설정
public class WebConfigurer implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {		
		System.out.println("WebConfigurer 접속 클라이언트를 허가");
		// 접속 클라이언트를 허가
		registry.addMapping("/**")
				.allowedOriginPatterns("*")
				.allowedMethods(HttpMethod.GET.name(),
						HttpMethod.POST.name(),
						HttpMethod.PUT.name(),
						HttpMethod.DELETE.name());
	}
}