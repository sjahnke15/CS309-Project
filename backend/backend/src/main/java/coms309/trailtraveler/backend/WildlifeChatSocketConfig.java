package coms309.trailtraveler.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WildlifeChatSocketConfig {

	@Bean
	public ServerEndpointExporter serverEndpointExplorer() {
		return new ServerEndpointExporter();
	}
}
