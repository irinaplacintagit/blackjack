package codingtest.blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import codingtest.blackjack.BlackjackService;
import codingtest.domain.DeckShuffle;
import codingtest.domain.Player;

public class BlackjackServiceTest {

	private BlackjackService blackjackService;
	
	@Before
	public void init() {
		blackjackService =  new BlackjackService();
	}
	
	@Test
	public void testInitDeck() {
		blackjackService.initDeck(DeckShuffle.SHUFFLE);
		assertEquals(52, blackjackService.getDeck().getDeck().size());
	}
	
	@Test
	public void testInitPlayers() {
		blackjackService.initDeck(DeckShuffle.SHUFFLE);
		blackjackService.initPlayers(3);
		assertEquals(3, blackjackService.getPlayers().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
		assertEquals(2, blackjackService.getPlayers().get(0).getHand().size());
	}
	
	@Test
	public void testPlayRound() {
		blackjackService.initDeck(DeckShuffle.SHUFFLE);
		blackjackService.initPlayers(3);
		Player player1 = blackjackService.getPlayers().get(0);
		blackjackService.playRound(player1);
	}
	
	@Test
	public void testPlay() {
		blackjackService.initDeck(DeckShuffle.SHUFFLE);
		blackjackService.initPlayers(3);
		blackjackService.play();
	}
}
