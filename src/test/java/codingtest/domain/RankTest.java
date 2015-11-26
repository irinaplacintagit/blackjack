package codingtest.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RankTest {
	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Irina");
	}

	@Test
	public void testGetCardsSum0() {
		assertEquals(0, player.getCardsSum());
	}
	
	@Test
	public void testGetCardsSum() {
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.DIAMOND, Rank.TWO));
		assertEquals(13, player.getCardsSum());
	}

}
