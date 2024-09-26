package com.oracle.samil.HbService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Card;
import com.oracle.samil.Amodel.CardUse;
import com.oracle.samil.Amodel.Cost;
import com.oracle.samil.HbDao.CardDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private final CardDao hbCardDao;

	@Override
	public List<Card> getCardList(Card card) {
		System.out.println("HbCardService getCardList start...");
		List<Card> cardList = null;
		cardList = hbCardDao.cardList(card);
		System.out.println("HbCardService getCardList card size -> " + cardList.size());
		return cardList;
	}

	@Override
	public List<CardUse> getCardUseList(CardUse cardUse) {
		System.out.println("HbCardService getCardUseList start...");
		List<CardUse> cardUseList = null;
		cardUseList = hbCardDao.cardUseList(cardUse);
		System.out.println("HbCardService getCardUseList size => " + cardUseList.size());
		return cardUseList;
	}

	@Override
	public int addCard(Card card) {
		int cardResult = 0;
		System.out.println("HbCardService addcard start...");
		cardResult = hbCardDao.addCard(card);
		System.out.println("HbCardService .." +card.getCardBank());
		return cardResult;
	}

	@Override
	public List<Card> cardNumList(Card card) {
		System.out.println("HbCardService addCardUse start..");
		List<Card> cardNumList = hbCardDao.cardNumList(card);
		System.out.println("HbCardService addCardUSE .. " +card.getCardNum());
		return cardNumList;
	}

	@Override
	public List<Card> setLostCard(Card card) {
		List<Card> setLostCard = hbCardDao.setLostCard(card);
		System.out.println("HbCardService cardSearchList start...");
		return setLostCard;
	}
	
	@Override
	public Card getCardDetails(String cardNum) {
	    return hbCardDao.getCardDetails(cardNum); // DAO 호출
	}

	@Override
	public List<Card> getCardList() {
	   return hbCardDao.getCardList();
	}
	
	@Override
	public void addCardUse(CardUse cardUse) {
		hbCardDao.cardUseAdd(cardUse);
	}
	@Override
	public List<CardUse> SearchcardUse(CardUse cardUse) {
	    System.out.println("카드 사용 내역 검색 서비스 시작...");
	    List<CardUse> cardUseSearch = hbCardDao.searchCardUse(cardUse);
	    if (cardUseSearch != null) {
	        System.out.println("검색 결과 수: " + cardUseSearch.size());
	    } else {
	        System.out.println("검색 결과가 없습니다.");
	    }
	    return cardUseSearch;
	}

	
}
