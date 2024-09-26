package com.oracle.samil.HbDao;

import java.util.List;

import com.oracle.samil.Amodel.Card;
import com.oracle.samil.Amodel.CardUse;
import com.oracle.samil.Amodel.Cost;

public interface CardDao {

	List<Card> 	  	cardList(Card card);
	int 						  	addCard(Card newCard);
	List<CardUse>cardUseList(CardUse cardUse);
	List<Card>         setLostCard(Card card);
	List<Card> 		cardNumList (Card card);
	
	// 카드 내역 추가 admin
	Card                      getCardDetails(String cardNum);
	List<Card>         getCardList();
	void                       cardUseAdd(CardUse cardUse);
	
	// 검색 구현 
	List<CardUse> searchCardUse(CardUse cardUse);
}
