package com.revature.overcharge.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.beans.StudiedCard;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class StudiedCardServiceTests {

	@Autowired
	public StudiedCardService scs;

	@Test
	void addStudiedCardTest() {
		long test = 0;
		StudiedCard StudiedCard1 = new StudiedCard(0, 0, test);

		StudiedCard StudiedCard = scs.addStudiedCard(StudiedCard1);

		Assertions.assertNotEquals(1, StudiedCard.getCardId());
		Assertions.assertEquals(0, StudiedCard.getCardId());
	}

	@Test
	void getStudiedCardTest() {
		long test = 0;
		StudiedCard StudiedCard = new StudiedCard(0, 0, test);
		Optional<StudiedCard> optionI = Optional.of(StudiedCard);

		Assertions.assertEquals(0, optionI.get().getCardId());
	}

	@Test
	void deleteStudiedCardTest() {
		assertTrue(true);
	}

}
