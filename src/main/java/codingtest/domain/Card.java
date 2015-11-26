package codingtest.domain;

/**
 * This is the domain class that represents a card in a card game.
 */
public class Card implements Comparable<Card>{
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	@Override
	public int compareTo(Card card) {
		if (this.equals(card)) {
			return 0;
		}
		else if (this.suit == card.suit) {
			return this.rank.compareTo(card.rank);
		}
		else {
			return this.suit.compareTo(card.suit);
		}
	}
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
}
