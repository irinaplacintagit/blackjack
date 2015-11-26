package codingtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.domain.Rank;
import codingtest.domain.RuleResult;
import codingtest.domain.Suit;

public class GameRoundTest {

	@Test
	public void testPlayHIT() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		assertEquals(RuleResult.HIT, GameRound.play(player));
	}
	
	@Test
	public void testPlaySTICK() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.NINE));
		assertEquals(RuleResult.STICK, GameRound.play(player));
	}
	
	@Test
	public void testPlayWIN() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.TEN));
		assertEquals(RuleResult.WIN, GameRound.play(player));
	}
	
	@Test
	public void testPlayGOBUST() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		assertEquals(RuleResult.GO_BUST, GameRound.play(player));
	}

}
