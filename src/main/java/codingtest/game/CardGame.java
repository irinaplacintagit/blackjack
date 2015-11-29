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
	
	@Autowired 
	private GameFactory gameFactory;
	
    /**
     * Main. Plays a card game from a command line interface.
     * @param args the arguments to the game
     * 
     * PARAM[0]: number of players; if none specified, default to 3
     * PARAM[1]: deck shuffling type; if none specified or not valid, default to basic shuffle
     * PARAM[2]: game type; if none specified or not valid, default to blackjack
     */
    public static void main(String[] args) {
    	ApplicationContext context = null;
    	try {
	    	context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    	CardGame game = context.getBean(CardGame.class);
	    	
	    	int noPlayers = InputValidator.validatePlayers(args.length > 0 ? args[0] : "");
	    	DeckShuffle shuffleType = InputValidator.validateDeck(args.length > 1 ? args[1] : "");
	    	GameType gameType = InputValidator.validateGameType(args.length > 2 ? args[2] : "");
	    	
	    	game.gameFactory.getGame(gameType).playGame(noPlayers, shuffleType);    
    	}
    	finally {
    		((ClassPathXmlApplicationContext)context).close();
    	}
    }
}
