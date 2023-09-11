package hw4;

import api.Card;
import api.Hand;
import api.IEvaluator;

/**
 * Evaluator for a generalized full house. The number of required cards is equal
 * to the hand size. If the hand size is an odd number n, then there must be (n
 * / 2) + 1 cards of the matching rank and the remaining (n / 2) cards must be
 * of matching rank. In this case, when constructing a hand, the larger group
 * must be listed first even if of lower rank than the smaller group</strong>
 * (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]). If the hand size is even, then
 * half the cards must be of matching rank and the remaining half of matching
 * rank. Any group of cards, all of which are the same rank, always satisfies
 * this evaluator.
 * 
 * The name of this evaluator is "Full House".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator {
	/**
	 * Constructs the evaluator.
	 * 
	 * @param ranking  ranking of this hand
	 * @param handSize number of cards in a hand
	 */


	public FullHouseEvaluator(int ranking, int handSize) {
		super("Full House", ranking, handSize, handSize);
	}

	@Override
	public boolean canSatisfy(Card[] mainCards) {
		
		boolean firstTrue = false;
		boolean secondTrue = false;
		int counter = 1;
		int counter2 = 1;
		
		if (cardsRequired() == mainCards.length) {

			if (handSize() % 2 != 0) {
				
				for (int i = 0; i < handSize()/2; i++) {
					
					if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) == 0) {
						
						counter++;
					}
					
					if (counter == handSize()/2 +1) {
						firstTrue = true;
					}
					
					
				}
				
				counter = 1;
				
				for (int i = handSize() / 2 + 1; i < handSize()-1; i++) {
					
					if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) == 0) {
						
						counter2++;
						
					}
					
					if (counter2 == handSize() - (handSize()/2 +1)) {
						secondTrue = true;
					}
					
					
					
				}
				counter2 = 1;
				
				if (firstTrue && secondTrue) {
					
					return true;
				}
				
			}
			else if (handSize() % 2 == 0) {
				
				for (int i = 0; i < handSize()/2-1; i++) {
					
					if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) == 0) {
						
						counter++;
					}
					
					if (counter == handSize()/2) {
						firstTrue = true;
					}
					
					
				}
				
				counter = 1;
				
				for (int i = handSize() / 2 ; i < handSize()-1; i++) {
					
					if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) == 0) {
						
						counter2++;
						
					}
					
					if (counter2 == handSize() - (handSize()/2)) {
						secondTrue = true;
					}
					
					
					
				}
				counter2 = 1;
				
				if (firstTrue && secondTrue) {
					
					return true;
				}
				
			}
		}

		return false;
	}

	@Override
	public boolean canSubsetSatisfy(Card[] allCards) {
		
		boolean firstTrue = false;
		boolean secondTrue = false;
		int counter = 1;
		int counter2 = 1;
		if (cardsRequired() >= allCards.length) {
if (handSize() % 2 != 0) {
				
				for (int i = 0; i < handSize()/2; i++) {
					
					if (allCards[i].compareToIgnoreSuit(allCards[i+1]) == 0) {
						
						counter++;
					}
					
					if (counter == handSize()/2 +1) {
						firstTrue = true;
					}
					
					
				}
				
				counter = 1;
				
				for (int i = handSize() / 2 + 1; i < handSize()-1; i++) {
					
					if (allCards[i].compareToIgnoreSuit(allCards[i+1]) == 0) {
						
						counter2++;
						
					}
					
					if (counter2 == handSize() - (handSize()/2 +1)) {
						secondTrue = true;
					}
					
					
					
				}
				counter2 = 1;
				
				if (firstTrue && secondTrue) {
					
					return true;
				}
				
			}
			else if (handSize() % 2 == 0) {
				
				for (int i = 0; i < handSize()/2-1; i++) {
					
					if (allCards[i].compareToIgnoreSuit(allCards[i+1]) == 0) {
						
						counter++;
					}
					
					if (counter == handSize()/2) {
						firstTrue = true;
					}
					
					
				}
				
				counter = 1;
				
				for (int i = handSize() / 2 ; i < handSize()-1; i++) {
					
					if (allCards[i].compareToIgnoreSuit(allCards[i+1]) == 0) {
						
						counter2++;
						
					}
					
					if (counter2 == handSize() - (handSize()/2)) {
						secondTrue = true;
					}
					
					
					
				}
				counter2 = 1;
				
				if (firstTrue && secondTrue) {
					
					return true;
				}
				
			}
		}
		return false;
	}
	
	

	

}
