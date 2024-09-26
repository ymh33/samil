package com.oracle.samil.Acontroller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.samil.Amodel.Chatroom;
import com.oracle.samil.Amodel.Emp;
import com.oracle.samil.Amodel.Message;
import com.oracle.samil.JmService.chatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/jm")
@RequiredArgsConstructor
public class JmChatController {
		
	private final chatService cs;
	//private final SimpMessageHeaderAccessor messagingTemplate;
	
	
	// 채팅방 목록 가져오기
	@RequestMapping(value = "chatList")
	public String listChatRoom(Chatroom chatroom, Model model) {
		System.out.println("jm chat play~");
		
		List<Chatroom> listChatRoom = cs.listChatRoom(chatroom);
		System.out.println("chatController listChatRoom.size() -> " + listChatRoom.size());
		
		model.addAttribute("listChatRoom", listChatRoom);
		
		// ViewResolver에 의해 jm/chatList.jsp로 이동
		return "jm/chatList";

	}	
	
	// 채팅방 이름 AJAX 요청을 처리하는 메서드
	@ResponseBody
	@RequestMapping(value = "/getRoomInfo")  
	public String getRoomName(Chatroom chatroom, Model model) {
	    System.out.println("ajax 요청 처리 컨트롤러");
	    System.out.println("roomId->"+chatroom.getRoomId());  	
	    String roomName = cs.getRoomName(chatroom.getRoomId());
	    	
	    System.out.println("roomName->"+roomName);
		return  roomName;
	}
	
	// 채팅방 생성
	@RequestMapping(value = "/create")
	public String insertRoom(Chatroom chatroom, Model model) {
		System.out.println("채팅방 생성 컨트롤러 실행");
		
		int insertResult = cs.insertRoom(chatroom);
		
		if (insertResult > 0) {
			return "redirect:chatList";
		}
		else {
			return "jm/chatList";
		}

	}
	
	// 웹소켓 STOMP
		
	
    // 팝업창 통하여 멤버 리스트 출력
    // 멤버 조회
	@RequestMapping(value = "chatMemberList")
	public String listChatMember(Emp emp, Model model) {
		System.out.println("chatController listChatMember Start...");
		
		List<Emp> listChatMember = cs.listChatMember(emp);
		System.out.println("chatController listChatMember.size() -> " + listChatMember.size());
		
		model.addAttribute("listChatMember", listChatMember);
		
		// ViewResolver에 의해 chatMemberList.jsp로 이동
		return "chatMemberList";

	}
}
