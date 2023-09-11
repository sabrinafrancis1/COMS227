package hw4;

import java.util.ArrayList;

import api.Card;
import api.Hand;
import api.IEvaluator;
import util.SubsetFinder;

/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 * 
 * TODO: Expand this comment with an explanation of how your class hierarchy is
 * organized.
 * 
 * @author sabrinaFrancis
 */
public abstract class AbstractEvaluator implements IEvaluator {

	private String name;
	private int ranking;
	private int cardsRequired;
	private int handSize;

	protected AbstractEvaluator(String name, int ranking, int cardsRequired, int handSize) {

		this.name = name;
		this.ranking = ranking;
		this.cardsRequired = cardsRequired;
		this.handSize = handSize;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getRanking() {
		return ranking;
	}

	@Override
	public int cardsRequired() {
		return cardsRequired;
	}

	@Override
	public int handSize() {
		return handSize;
	}

	public abstract boolean canSatisfy(Card[] mainCards);

	public abstract boolean canSubsetSatisfy(Card[] allCards);

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
		
		
		
		if (canSubsetSatisfy(allCards)) {
			
			
			Card[] side = {};
			
			Hand hand = new Hand(allCards, side, this);
			
			return hand;
		}

		return null;

	}

	/**
	 * Returns the best possible hand satisfying this evaluator's criteria that can
	 * be formed from the given list of cards. "Best" is defined to be first
	 * according to the compareTo() method of Hand. Returns null if there is no such
	 * hand. The number of main cards in the hand will be the value of
	 * <code>getRequiredCards()</code> and the total number of cards in the hand
	 * will be the value of <code>handSize()</code>. If the length of the given
	 * array of cards is less than <code>totalCards()</code>, this method returns
	 * null. The given array must be sorted with highest-ranked card first according
	 * to <code>Card.compareTo()</code>. The array is not modified by this
	 * operation.
	 * 
	 * @param allCards list of cards from which to create the hand
	 * @return best possible hand satisfying this evaluator that can be formed from
	 *         the given cards
	 */

	@Override
	public Hand getBestHand(Card[] allCards) {

		if (allCards.length < handSize) {
			return null;
		} else {

			ArrayList<int[]> subsets = SubsetFinder.findSubsets(allCards.length, cardsRequired);

			Hand best = null;

			for (int i = 0; i < subsets.size(); i++) {

				Hand x = createHand(allCards, subsets.get(i));

				if (x != null) {

					if (best == null) {

						best = new Hand(x.getMainCards(), x.getSideCards(), this);
					} else {
						if (best.compareTo(x) > 0) {

							best = new Hand(x.getMainCards(), x.getSideCards(), this);
						}

					}

				}

			}

			return best;
		}

	}
}
