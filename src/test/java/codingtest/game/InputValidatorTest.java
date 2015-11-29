package codingtest.game;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

import codingtest.domain.DeckShuffle;
import codingtest.domain.GameType;

public class InputValidatorTest {

	private InputValidator inputValidator;

	@Test
	public void testValidatePlayers() {
		assertEquals(3, InputValidator.validatePlayers(""));
		assertEquals(3, InputValidator.validatePlayers("3"));
		assertEquals(6, InputValidator.validatePlayers("6"));
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testValidatePlayersInvalid1() {
		InputValidator.validatePlayers("1");
	}
	
	@Test(expected=InvalidParameterException.class)
	public void testValidatePlayersInvalid2() {
		InputValidator.validatePlayers("7");
	}
	
	@Test
	public void testValidateDeck() {
		assertEquals(DeckShuffle.SHUFFLE, InputValidator.validateDeck("SHUFFLE"));
		assertEquals(DeckShuffle.RIFFLE, InputValidator.validateDeck("RIFFLE"));
		assertEquals(DeckShuffle.SHUFFLE, InputValidator.validateDeck("abc"));
	}
	
	@Test
	public void testValidateGameType() {
		assertEquals(GameType.BLACKJACK, InputValidator.validateGameType("BLACKJACK"));
		assertEquals(GameType.POKER, InputValidator.validateGameType("POKER"));
		assertEquals(GameType.BLACKJACK, InputValidator.validateGameType("abc"));

	}

}
