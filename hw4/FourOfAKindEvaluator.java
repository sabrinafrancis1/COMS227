package hw4;

import api.Card;
import api.Hand;
import api.Suit;

/**
 * Evaluator for a hand containing (at least) four cards of the same rank.
 * The number of cards required is four.
 * 
 * The name of this evaluator is "Four of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public FourOfAKindEvaluator(int ranking, int handSize)
  {
    super("Four of a Kind", ranking, 4, handSize);
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
		
		int counter = 1;
		
		if (mainCards.length == cardsRequired()) {

			for (int i = 0; i < mainCards.length; i++) {

				for (int j = i + 1; j < mainCards.length; j++) {

					if (mainCards[i].compareToIgnoreSuit(mainCards[j]) == 0) {

						
						counter++;
					}

				}
				
				if (counter >= 4) {
					return true;
				}
			}
			counter = 1;

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
		
		int counter = 1;

		if (allCards.length >= cardsRequired()) {

			for (int i = 0; i < allCards.length; i++) {

				for (int j = i + 1; j < allCards.length; j++) {

					if (allCards[i].compareToIgnoreSuit(allCards[j]) == 0) {

						counter++;
					}

				}
				
				if (counter >= 4) {
					return true;
				}
			}
			counter = 1;

		}
		return false;

	}
	
	/**
	   * Returns a hand whose main cards consist of the indicated subset
	   * of the given cards.  If the indicated subset does
	   * not satisfy the criteria for this evaluator, this
	   * method returns null. The subset is described as
	   * an ordered array of indices to be selected from the given
	   * Card array.  The number of main cards in the hand
	   * will be the value of <code>getRequiredCards()</code>
	   * and the total number of cards in the hand will
	   * be the value of <code>handSize()</code>.  If the length
	   * of the given array of cards is less than <code>handSize()</code>,
	   * this method returns null.   The
	   * given array must be sorted with highest-ranked card first
	   * according to <code>Card.compareTo()</code>.  The array
	   * is not modified by this operation.
	   * 
	   * @param allCards
	   *   list of cards from which to select the main cards for the hand
	   * @param subset
	   *   list of indices of cards to be selected, in ascending order
	   * @return
	   *   hand whose main cards consist of the indicated subset, or null
	   *   if the indicated subset does not satisfy this evaluator
	   */
	  
	@Override
	public Hand createHand(Card[] allCards, int[] subset) {
		
		int mainCounter = 0;
		int sideCounter = 0;
		int counter = 0;
		Card card = new Card(1, Suit.CLUBS);
		
		Card[] main = new Card[4];
		Card[] side = new Card[allCards.length-4];
		
		
		if (canSubsetSatisfy(allCards)) {
			
			
			outer: for (int i = 0; i < allCards.length; i++) {

				for (int j = i + 1; j < allCards.length; j++) {

					if (allCards[i].compareToIgnoreSuit(allCards[j]) == 0) {

						counter++;
						
					}

				}
				
				if (counter >= 4) {
					
					card.equals(allCards[i]);
					
					break outer;
				}
			}
			
			for (int i = 0; i < allCards.length; i++) {
				
				if (allCards[i].compareToIgnoreSuit(card) == 0) {
					
					
					
					main[mainCounter] = allCards[i];
					mainCounter++;
					
					
					
				}
				else {
					side[sideCounter] = allCards[i];
					sideCounter++;
				}
				
			}
			
			
			
		}
		Hand hand = new Hand(main, side, this);
		return hand;
	}
	
}