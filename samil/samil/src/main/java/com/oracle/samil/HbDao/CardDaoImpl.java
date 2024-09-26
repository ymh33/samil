package com.oracle.samil.HbDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.samil.Amodel.Card;
import com.oracle.samil.Amodel.CardUse;
import com.oracle.samil.Amodel.Cost;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Repository
public class CardDaoImpl implements CardDao {
	@Autowired
	private final SqlSession session;
	
	@Override
	public List<Card> cardList(Card card) {
		List<Card> cardList = null;
		try {
			cardList = session.selectList("getCardList",card);
			System.out.println("CardDaoImpl cardList start..." + cardList.size());
		} catch (Exception e) {
			System.out.println("CardDaoImpl cardList e.getMessage => " + e.getMessage());
		}
		return cardList;
	}

	@Override
	public List<CardUse> cardUseList(CardUse cardUse) {
		List<CardUse> cardUseList = null;
		try {
			cardUseList = session.selectList("getCardUseList",cardUse);
			System.out.println("CardDaoImpl CardUseList start..." + cardUseList.size());
		} catch (Exception e) {
			System.out.println("CardDaoImpl cardUseList e.getMessage => " + e.getMessage());
		}
		return cardUseList;
	}

	@Override
	public int addCard(Card newCard) {
	    int cardResult = 0;
	    try {
	    	cardResult = session.insert("cardAdd", newCard); // 새로운 카드 객체를 쿼리에 전달
	        System.out.println("Card added successfully.");
	    } catch (Exception e) {
	        System.out.println("Error adding card: " + e.getMessage());
	    }
	    return cardResult; // 성공적으로 추가된 행의 수를 반환
	}

	@Override
	public List<Card> cardNumList (Card card) {
		List<Card> cardList = null;
		try {
			cardList = session.selectList("cardList", card); // 새로운 카드 객체를 쿼리에 전달
		        System.out.println("Card added successfully.");
		    } catch (Exception e) {
		        System.out.println("Error adding card: " + e.getMessage());
		    }
		    return cardList; // 성공적으로 추가된 행의 수를 반환
		}

	@Override
	public List<Card> setLostCard(Card card) {
		List<Card> setLostCard = null;
		int lostcardupdate = 0;
		try {
			setLostCard = session.selectList("setLostCard", card);
			System.out.println("CardDaoImpl setLostCard size-->" +lostcardupdate);			
		} catch(Exception e) {
			System.out.println("CardDaoImpl setLostCard e.getMessage => " + e.getMessage());
		}
		return setLostCard;
	}

	@Override
	public Card getCardDetails(String cardNum) {
	    return session.selectOne("getCardDetails", cardNum); // MyBatis 쿼리 호출
	}

	@Override
	public List<Card> getCardList() {
		List<Card> cardList = null;
		try {
			cardList = session.selectList("getCardList");
		} catch (Exception e) {
			System.out.println("CardDaoImpl setLostCard e.getMessage => " + e.getMessage());
		}
		
		return cardList;
	}
	
	public void cardUseAdd(CardUse cardUse) {
		session.insert("cardUseAdd",cardUse);
	}

	@Override
	public List<CardUse> searchCardUse(CardUse cardUse) {
		List <CardUse> searchCardUse = null;
		try {
			searchCardUse = session.selectList("searchCard", cardUse);
			System.out.println("searchCost ==> " + (searchCardUse != null ? searchCardUse.size() : 0));
		} catch (Exception e) {
			System.out.println("CostDaoImpl searchCost error : " +e.getMessage());
		}
		return searchCardUse;
	}


	
	}

