package com.oracle.samil.HbService;

import java.util.List;

import com.oracle.samil.Amodel.Card;
import com.oracle.samil.Amodel.CardUse;
import com.oracle.samil.Amodel.Cost;


public interface CardService {
	
	List<Card> 	  	 getCardList	();
	List<Card> 	  	 getCardList	(Card card);
	int  					 	 addCard(Card card);
	List<CardUse> getCardUseList(CardUse cardUse);
	List<Card>        setLostCard(Card card);
	
	List<Card>		cardNumList(Card card);
	Card                     getCardDetails(String cardNum);
	void                      addCardUse(CardUse cardUse);
	
	//검색 구현 
	List<CardUse> SearchcardUse(CardUse cardUse);

}
