package codingtest.game;

import java.security.InvalidParameterException;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import codingtest.domain.DeckShuffle;
import codingtest.domain.GameType;

/**
 * Class that handles the playing of a card game from a simple command line interface,
 * and echoes back a step-by-step description of the game to the console.
 */
@Component
public class CardGame {
	
    /**
     * Main. Plays a card game from a command line interface.
     * @param args the arguments to the game
     */
	@Autowired 
	private GameFactory gameFactory;
	
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	CardGame game = context.getBean(CardGame.class);
    	
    	int noPlayers = game.validatePlayers(args.length > 0 ? args[0] : "");
    	DeckShuffle shuffleType = game.validateDeck(args.length > 1 ? args[1] : "");
    	GameType gameType = game.validateGameType(args.length > 2 ? args[2] : "");
    	
    	game.gameFactory.getGame(gameType).playGame(noPlayers, shuffleType);    	
    }

	private int validatePlayers(String noPlayers) {
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
    
    private DeckShuffle validateDeck(String deck) {
    	if(EnumUtils.isValidEnum(DeckShuffle.class, deck)) {
    		return DeckShuffle.valueOf(deck);
    	}
    	else {
    		return DeckShuffle.SHUFFLE;
    	}
    }
    
    private GameType validateGameType(String game) {
    	if(EnumUtils.isValidEnum(GameType.class, game)) {
    		return GameType.valueOf(game);
    	}
    	else {
    		return GameType.BLACKJACK;
    	}
	}
}
