package com.oracle.samil.Amodel;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.Data;

// 채팅방 테이블

@Data
public class Chatroom {
	private int roomId;		// 채팅방 아이디
	private String roomName;	// 채팅방 이름
	//private Set<WebSocketSession> sessions = new HashSet<>();
	
	// 채팅방 아이디 랜덤 설정
//	public static Chatroom create(String name){
//        Chatroom chatroom = new Chatroom();
//        chatroom.roomId = UUID.randomUUID().hashCode(); // UUID의 해시값을 사용하여 int로 설정
//        chatroom.roomName = name;
//        return chatroom;
    }