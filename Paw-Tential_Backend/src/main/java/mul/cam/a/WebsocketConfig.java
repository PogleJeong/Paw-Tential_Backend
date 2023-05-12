package mul.cam.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // Stomp 를 사용하려 쓰는 어노테이션
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	
	// 엔드포인트등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	System.out.println("register stomp end point");
        registry.addEndpoint("/stomp/chat")
        		.setAllowedOriginPatterns("*")
        		.withSockJS();
    }
	
	//한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는 데 사용될 메시지 브로커를 구성.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	/*
    	 	해당경로로 Simple broker를 등록하고 해당 경로를 subscribe 하는 클라이언트에게 메세지전달.
          	메세지 브로커를 통해 클라이언트에게 Subscriptions, Broadcasting 기능제공
          	topic, queue 로 시작하는 "destination" 헤더를 가진 메세지를 브로커로 라우팅.
        	1. topic : 일대다형식의 커넥션
        	2. queue : 일대일형식의 커넥션
    	 */
        registry.enableSimpleBroker("/sub");
        
        /*
          	클라이언트에서 SEND 요청을 처리함.
          	Destination 의 prefix 설정 (prefix 로 시작되는 destination의 메세지가 라우팅됨.
         
        */
        registry.setApplicationDestinationPrefixes("/pub"); 
        // 도착경로의 prefix 설정 : (topic/hello)에 접속했을 시 실제 도착경로는 [ app/topic/hello ]
        // "/app" 시작되는 메시지가 message-handling methods으로 라우팅 되어야 한다는 것을 명시
    }
}