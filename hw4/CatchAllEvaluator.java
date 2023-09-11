package hw4;

import api.Card;
import api.Hand;

/**
 * Evaluator satisfied by any set of cards.  The number of
 * required cards is equal to the hand size.
 * 
 * The name of this evaluator is "Catch All".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class CatchAllEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public CatchAllEvaluator(int ranking, int handSize)
  {
    super("Catch All", ranking, handSize, handSize);
  }
  
  /**
	 * Determines whether the given group of cards satisfies the criteria this
	 * evaluator. The length of the given array must exactly match the value
	 * returned by <code>cardsRequired()</code>. The given array must be sorted with
	 * highest-ranked card first according to <code>Card.compareTo()</code>. The
	 * array is not modified by this operation.
	 * 
	 * @param mainCards array of cards
	 * @return true if the given cards satisfy this evaluator
	 */
	@Override
	public boolean canSatisfy(Card[] mainCards) {
		
		int counter = 0;

		if (cardsRequired() == mainCards.length) {

			for (int i = 0; i < mainCards.length-1; i++) {
				
				if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) == 0) {
					counter++;
					
				}

			}
			if (counter == mainCards.length - 1) {
				return true;
			}

		}
		return false;

	}

	/**
	 * Determines whether there exists a subset of the given cards that satisfies
	 * the criteria for this evaluator. The length of the given array must be
	 * greater than or equal to the value returned by <code>cardsRequired()</code>.
	 * The given array must be sorted with highest-ranked card first according to
	 * <code>Card.compareTo()</code>. The array is not modified by this operation.
	 * 
	 * @param allCards list of cards to evaluate
	 * @return true if some subset of the given cards satisfy this evaluator
	 */

	@Override
	public boolean canSubsetSatisfy(Card[] allCards) {
		
		int counter = 0;

		if (allCards.length >= cardsRequired()) {

for (int i = 0; i < allCards.length-1; i++) {
				
				if (allCards[i].compareToIgnoreSuit(allCards[i+1]) == 0) {
					counter++;
				}

			}
			if (counter == allCards.length - 1) {
				return true;
			}

		}
		return false;

	}
	
	
}
