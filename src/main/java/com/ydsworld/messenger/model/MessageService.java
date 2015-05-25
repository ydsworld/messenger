package com.ydsworld.messenger.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ydsworld.messenger.database.DatabaseClass;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put( 1L, new Message(1,"hello world","arun"));
		messages.put( 2L, new Message(2,"hello RESST","arun"));
	}



	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(Long id){
		return messages.get(id);
	}
	
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if (message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long id)
	{
		return messages.remove(id);
	}
	
	
}
