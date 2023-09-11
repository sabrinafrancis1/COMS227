package hw4;

import api.Card;
import api.Hand;
import api.IEvaluator;

/**
 * Evaluator for a hand containing (at least) two cards of the same rank. The
 * number of cards required is two.
 * 
 * The name of this evaluator is "One Pair".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */
	
	private int[] subset;

	public OnePairEvaluator(int ranking, int handSize)

	{

		super("One Pair", ranking, 2, handSize);

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

		if (cardsRequired() == mainCards.length) {

			for (int i = 0; i < mainCards.length - 1; i++) {

				for (int j = i + 1; j < mainCards.length; j++) {

					if (mainCards[i].compareToIgnoreSuit(mainCards[j]) == 0) {

						return true;
					}

				}
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

		if (allCards.length >= cardsRequired()) {

			for (int i = 0; i < allCards.length - 1; i++) {
				

				for (int j = i + 1; j < allCards.length; j++) {
					

					if (allCards[i].compareToIgnoreSuit(allCards[j]) == 0) {

						return true;
					}

				}
			}
		}
		return false;

	}

	/**
	 * Returns a hand whose main cards consist of the indicated subset of the given
	 * cards. If the indicated subset does not satisfy the criteria for this
	 * evaluator, this method returns null. The subset is described as an ordered
	 * array of indices to be selected from the given Card array. The number of main
	 * cards in the hand will be the value of <code>getRequiredCards()</code> and
	 * the total number of cards in the hand will be the value of
	 * <code>handSize()</code>. If the length of the given array of cards is less
	 * than <code>handSize()</code>, this method returns null. The given array must
	 * be sorted with highest-ranked card first according to
	 * <code>Card.compareTo()</code>. The array is not modified by this operation.
	 * 
	 * @param allCards list of cards from which to select the main cards for the
	 *                 hand
	 * @param subset   list of indices of cards to be selected, in ascending order
	 * @return hand whose main cards consist of the indicated subset, or null if the
	 *         indicated subset does not satisfy this evaluator
	 */

	@Override
	public Hand createHand(Card[] allCards, int[] subset) {
		
		this.subset = subset;
		
		
		if (allCards.length < handSize()) {
			return null;
		}

		// Hand(Card[] mainCards, Card[] sideCards, IEvaluator evaluator)

		// # of main cards = getRequiredCards()
		// total # of cards = handSize()

		Card[] sub = new Card[subset.length];
		Card[] side = new Card[allCards.length - subset.length];
		int counter = 0;
		int counter2 = 0;

		for (int i = 0; i < subset.length; i++) {

			sub[i] = allCards[subset[i]];

		}

		for (int i = 0; i < allCards.length; i++) {
			

			for (int j = 0; j < sub.length; j++) {

				if (allCards[i].compareToIgnoreSuit(sub[j]) != 0) {
					counter2++;
					
					if (counter2 == sub.length) {
						side[counter] = allCards[i];
						counter++;

					}
				}

			}
			counter2 = 0;

		}

		
		Hand hand = new Hand(sub, side, this);

		if (canSubsetSatisfy(sub)) {

			return hand;

		} else {
			return null;
		}

	}

	
}
