package com.oracle.samil.Acontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.samil.Amodel.Card;
import com.oracle.samil.Amodel.CardUse;
import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.HbService.CardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/hb")
public class HbCardController {

	private final CardService hbCardService;

	@GetMapping(value = "/costMain")
	public String cost_main() {
		System.out.println("hb cost Main play~");
		return "hb/costMain";
	}

	@GetMapping(value = "/costCard")
	public String cost_card(Model model, CardUse cardUse) {
		List<CardUse> cardUseList = hbCardService.getCardUseList(cardUse);
		model.addAttribute("cardUseList", cardUseList);
		Map<Integer, String> cardMap = new HashMap<>();
		cardMap.put(0, "사용중");
		cardMap.put(110, "분실 신청");
		System.out.println("cost_cardStart....");
		return "hb/costCard";
	}

	@GetMapping(value = "/cardUse_search")
	public String searchCardUse(Model model,
	                             @RequestParam("keyword") String keyword, 
	                             @RequestParam("search") String search) {
	    System.out.println("카드 사용 내역 검색 시작...");
	    CardUse cardUse = new CardUse();
	    cardUse.setSearch(search);
	    cardUse.setKeyword(keyword);
	    
	    List<CardUse> searchResults = hbCardService.SearchcardUse(cardUse);
	    model.addAttribute("cardUseList", searchResults);
	    
	    return "hb/costCard"; // 검색 결과를 보여줄 JSP 페이지
	}

	@GetMapping(value = "/costCardLost")
	public String cost_card_lost(Model model) {
		List<Card> cardSearchList = hbCardService.getCardList(new Card()); // 카드 목록을 가져옴
		model.addAttribute("cardSearchList", cardSearchList); // 모델에 카드 목록 추가

		// 카드 번호로 소지자와 부서 정보를 추가해야 함
		for (Card card : cardSearchList) {
			Card cardDetails = hbCardService.getCardDetails(card.getCardNum());
			model.addAttribute("emp", cardDetails); // 모델에 emp 객체 추가
		}

		return "hb/costCardLost";
	}


	@PostMapping(value = "/costCardLost")
	public String cost_card_process(Model model, Card card) {

		return "redirect:/hb/cost_card";
	}
	// admin card 부분

	@GetMapping(value = "/adminCostCard")
	public String list_card(Model model, Card card) {
		List<Card> cardList = hbCardService.getCardList(card);
		Map<Integer, String> cardMap = new HashMap<>();
		model.addAttribute("cardList", cardList);

		cardMap.put(0, "사용");
		cardMap.put(110, "분실신청");
		model.addAttribute("cardMap", cardMap);

		System.out.println("list_card get start....");
		return "hb/adminCostCard";
	}

	@GetMapping(value = "/adminCostCardAdd")
	public String admin_cost_card_add(Model model) {
		System.out.println("HbCardController admin_cost_card_add start...");
		return "hb/adminCostCardAdd";
	}

	@PostMapping(value = "/adminCostCardAdd")
	public String admin_cost_card_add(Card card, Model model) {
		System.out.println("HbCardController After cost_card_add");
		hbCardService.addCard(card);
		card.setCardDelGubun(0);
		model.addAttribute("card", card);
		return "redirect:/hb/adminCostCard";
	}

	@GetMapping(value = "/adminCostCardPlus")
	public String admin_cost_card_plus(Model model) {
		 System.out.println("HbCardController admin_card_plus start...");
	        List<Card> cardList = hbCardService.getCardList();
	        model.addAttribute("cardList", cardList);
	        return "hb/adminCostCardPlus";
	}
	
	@GetMapping(value = "/getCardDetails")
	public Card getCardDetails(String cardNum) {
		return hbCardService.getCardDetails(cardNum);
	}
	
	 @PostMapping(value = "/adminCostCardPlus") 
		 public String admin_cost_card_plus(Model model, CardUse cardUse) {
		System.out.println("HbCardController admin_Card_plus start... ");
		 hbCardService.addCardUse(cardUse); 
		 return "redirect:/hb/adminCostCard"; 
		 }
	 

}
