package codingtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import codingtest.domain.Card;
import codingtest.domain.Deck;
import codingtest.domain.Player;
import codingtest.domain.Rank;
import codingtest.domain.Suit;

public class BlackjackServiceTest {
	@Autowired
	BlackjackService blackjackService;
	
	@Before
	public void init() {
		blackjackService =  new BlackjackService();
	}
	
	@Test
	public void testInitDeck() {
		blackjackService.initDeck();
		assertEquals(52, blackjackService.getDeck().getDeck().size());
	}
	
	@Test
	public void testInitPlayers() {
		blackjackService.initDeck();
		blackjackService.initPlayers(3);
		assertEquals(3, blackjackService.getPlayers().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
	}
	
	@Test
	public void testPlayRound() {
		blackjackService.initDeck();
		blackjackService.initPlayers(3);
		Player player1 = blackjackService.getPlayers().get(0);
		blackjackService.playRound(player1);
	}
}
