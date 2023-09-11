package hw4;

import api.Card;
import api.Hand;
import api.IEvaluator;

/**
 * Evaluator for a hand consisting of a "straight" in which the card ranks are
 * consecutive numbers. The number of required cards is equal to the hand size.
 * An ace (card of rank 1) may be treated as the highest possible card or as the
 * lowest (not both). To evaluate a straight containing an ace it is necessary
 * to know what the highest card rank will be in a given game; therefore, this
 * value must be specified when the evaluator is constructed. In a hand created
 * by this evaluator the cards are listed in descending order with high card
 * first, e.g. [10 9 8 7 6] or [A K Q J 10], with one exception: In case of an
 * ace-low straight, the ace must appear last, as in [5 4 3 2 A]
 * 
 * The name of this evaluator is "Straight".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class StraightEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator. Note that the maximum rank of the cards to be used
	 * must be specified in order to correctly evaluate a straight with ace high.
	 * 
	 * @param ranking     ranking of this hand
	 * @param handSize    number of cards in a hand
	 * @param maxCardRank largest rank of any card to be used
	 * 
	 */

	public StraightEvaluator(int ranking, int handSize, int maxCardRank) {
		super("Straight", ranking, handSize, handSize);
	}

	@Override
	public boolean canSatisfy(Card[] mainCards) {

		int counter = 1;
		if (cardsRequired() == mainCards.length) {

			for (int i = 0; i < handSize() - 1; i++) {

				if (mainCards[i].compareToIgnoreSuit(mainCards[i + 1]) == -1) {
					

						counter++;
					
					
				}
				if (mainCards[i+1].getRank() == 1) {
					counter++;
				}
				
			}
			if (counter == mainCards.length) {

				return true;
			}

		}

		
		return false;
	}

	@Override
	public boolean canSubsetSatisfy(Card[] allCards) {

		int counter = 1;
		if (cardsRequired() >= allCards.length) {
			for (int i = 0; i < handSize() - 1; i++) {

				if (allCards[i].compareToIgnoreSuit(allCards[i + 1]) == -1) {
					

						counter++;
					
					
				}
				if (allCards[i+1].getRank() == 1) {
					counter++;
				}
				
			}
			if (counter == allCards.length) {

				return true;
			}

		}

		
		return false;
	}
	
	
	
}
