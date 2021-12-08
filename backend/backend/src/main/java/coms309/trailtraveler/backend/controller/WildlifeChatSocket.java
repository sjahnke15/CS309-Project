package coms309.trailtraveler.backend.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import coms309.trailtraveler.backend.model.Message;
import coms309.trailtraveler.backend.repository.MessageRepository;

@Controller
@ServerEndpoint(value = "/chat/{username}")
public class WildlifeChatSocket {

	private static MessageRepository msgRepo;
	
	@Autowired
	public void setMessageRepository(MessageRepository repo) {
		msgRepo = repo;
	}
	
	private final Logger logger = LoggerFactory.getLogger(WildlifeChatSocket.class);
	
	private static Map<Session, String> sessionUsernameMap = new Hashtable<>();
	private static Map<String, Session> usernameSessionMap = new Hashtable<>();
	
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException {
		logger.info("Entered into Open");
		
		sessionUsernameMap.put(session, username);
		usernameSessionMap.put(username, session);
		
		sendMessageToUser(username, getChatHistory());
	}
	
	public void onMessage(Session session, String message) throws IOException {
		logger.info("Entered into Message: Got Message: " + message);
		String username = sessionUsernameMap.get(session);
		
		if(message.startsWith("@")) {
			String destUsername = message.split(" ")[0].substring(1);
			
			sendMessageToUser(destUsername, "[DM] " + username + ": " + message);
		}
	}

	private void sendMessageToUser(String username, String message) {
		try {
			usernameSessionMap.get(username).getBasicRemote().sendText(message);
		} 
		catch(IOException e) {
			logger.info("Exception: " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	private String getChatHistory() {
		List<Message> messages = msgRepo.findAll();
		
		StringBuilder sb = new StringBuilder();
		if(messages != null && messages.size() != 0) {
			for(Message message : messages) {
				sb.append(message.getUsername() + ": " + message.getContent() + "\n");
			}
		}
		return sb.toString();
	}
	
}
