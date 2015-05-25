package com.ydsworld.messenger.resources;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ydsworld.messenger.model.*;

import org.glassfish.jersey.message.internal.MediaTypes;

import com.ydsworld.messenger.model.MessageService;

@Path("/messages")
public class MessageResouce {
	
	MessageService service = new MessageService();
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return service.getAllMessages();
		
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId){
		return service.getMessage(messageId);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId){
		 service.removeMessage(messageId);
	}
	
	
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return service.addMessage(message);
	}
}//class
