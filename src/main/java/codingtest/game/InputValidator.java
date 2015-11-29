package codingtest.game;

import java.security.InvalidParameterException;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.StringUtils;

import codingtest.domain.DeckShuffle;
import codingtest.domain.GameType;

/**
 * @author Irina
 *
 * Validates input given by the user
 * - number of players
 * - shuffling mechanism
 * - game type
 */
public class InputValidator {
	
	public static int validatePlayers(String noPlayers) {
    	if (StringUtils.isEmpty(noPlayers)) {
    		return 3;
    	}
    	else {
    		int numberOfPlayers = Integer.parseInt(noPlayers);
    		if (numberOfPlayers <= 1 || numberOfPlayers > 6){
    			throw new InvalidParameterException("You can only have 2 to 6 players.");
    		}
    		else {
    			return numberOfPlayers;
    		}
    	}
    }
    
    public static DeckShuffle validateDeck(String deck) {
    	if(EnumUtils.isValidEnum(DeckShuffle.class, deck)) {
    		return DeckShuffle.valueOf(deck);
    	}
    	else {
    		return DeckShuffle.SHUFFLE;
    	}
    }
    
    public static GameType validateGameType(String game) {
    	if(EnumUtils.isValidEnum(GameType.class, game)) {
    		return GameType.valueOf(game);
    	}
    	else {
    		return GameType.BLACKJACK;
    	}
	}
}
