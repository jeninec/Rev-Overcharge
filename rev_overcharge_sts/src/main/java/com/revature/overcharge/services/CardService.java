package com.revature.overcharge.services;

import java.util.List;

import com.revature.overcharge.beans.Card;

public interface CardService {

	public Card addCard(Card f);
	
	public Card getCard(int id);
	
	public Card updateCard(Card newCard);
	
	public boolean deleteCard(int id);
	
	public List<Card> getCardBySetId(int setId);

	public List<Card> getCardsByDeckId(int deckId);
	
}
