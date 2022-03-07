/*package tn.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/message")
public class MessageController {
	
	/*@Autowired
	/* private SimpMessagingTemplate simpMessagingTemplate;

	   /* @MessageMapping("/message/{to}")
	    public void sendMessage(@DestinationVariable String to, Message message) {
	        System.out.println("handling send message: " + message + " to: " + to);
	        boolean isExists = User.getInstance().getUsers().contains(to);
	        if (isExists) {
	       
	            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
	        }
	    }
	@MessageMapping("/chat/{to}")
    public void sendMessagePersonal(@DestinationVariable String to, MessageDTO message) {

        messageService.sendMessage(to,message);

    }

}*/
