import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    Deck testDeck;
    Card testCard;
    Card testCard2;

    @Before
    public void before(){
        testDeck = new Deck();
        testCard = new Card(SuitType.HEARTS, CardTypes.EIGHT);
        testCard2 = new Card(SuitType.HEARTS, CardTypes.ACE);
    }

    @Test
    public void countDoesWork(){
        testDeck.addToDeck(testCard);
        assertEquals(1, testDeck.countCards());
    }

    @Test
    public void doesItWorkTestValue(){
        assertEquals(8, testCard.getValueFromEnum());
    }

    @Test
    public void doesItWorkTestType(){
        assertEquals("HEARTS", testCard.getSuitFromEnum());
    }

    @Test
    public void doesPopulateDeckWork(){
        testDeck.populateDeck();
        assertEquals(52, testDeck.countCards());
    }

    @Test
    public void canShuffleDeck(){
        testDeck.populateDeck();
        Card variable = testDeck.shuffleDeck();
        assertNotEquals(variable.getSuitFromEnum(), testCard2.getSuitFromEnum());
    }

    @Test
    public void shuffleDefoWorks(){
        testDeck.populateDeck();
        Card variable = testDeck.takeFirstCard();
        assertEquals(variable.getValueFromEnum(), testCard2.getValueFromEnum());
        assertEquals(variable.getSuitFromEnum(), testCard2.getSuitFromEnum());
    }



}
