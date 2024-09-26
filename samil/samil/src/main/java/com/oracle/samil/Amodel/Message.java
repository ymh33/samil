package com.oracle.samil.Amodel;

import java.sql.Timestamp;

import lombok.Data;

// 메세지 테이블

@Data
public class Message {
	
	public enum MessageType {
		ENTER, TALK
	}
	
	private int 	    messageId; 	    // 메세지 아이디
	private MessageType messageType;	// 메세지 타입
	private int 	    roomId; 		// 채팅방 아이디
	private int 	    senderId;		// 발신자 아이디
	private String 	    messageCnt;     // 메세지 내용
	
	private Timestamp   messageTime;    // 메세지 보낸 시간
	private int 	    messageCheck;   // 메세지 확인 여부
}
