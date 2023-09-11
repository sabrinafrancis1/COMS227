package hw4;

import api.Card;
import api.Hand;

/**
 * Evaluator for a hand in which the rank of each card is a prime number.
 * The number of cards required is equal to the hand size. 
 * 
 * The name of this evaluator is "All Primes".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class AllPrimesEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public AllPrimesEvaluator(int ranking, int handSize)
  {
	  
    super("All Primes", ranking, handSize, handSize);
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

			for (int i = 0; i < mainCards.length; i++) {

				if (mainCards[i].getRank() == 1 || mainCards[i].getRank() == 2 || mainCards[i].getRank() == 3 || mainCards[i].getRank() == 5 || mainCards[i].getRank() == 7) {
					
					counter++;
					
				}
				
				
			}
			if (counter == mainCards.length) {
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
			for (int i = 0; i < allCards.length; i++) {

				if (allCards[i].getRank() == 1 || allCards[i].getRank() == 2 || allCards[i].getRank() == 3 || allCards[i].getRank() == 5 || allCards[i].getRank() == 7) {
					
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
