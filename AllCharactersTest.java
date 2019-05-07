import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AllCharactersTest {
    @Before
    public void before() {
        AllCharacters.clear();
    }

    @Test
    public void testEmpty() {
        assertNull(AllCharacters.getFirst());
        assertNull(AllCharacters.getNext(null));
    }

    @Test
    public void testSingle() {
        Character sansa = new Character("Sansa Stark", 0.5);
        assertSame(AllCharacters.getFirst(), sansa);
        assertNull(AllCharacters.getNext(sansa));
    }

    @Test
    public void testTwo() {
        Character sansa = new Character("Sansa Stark", 0.5);
        Character arya = new Character("Arya Stark", 0.8);
        assertSame(AllCharacters.getFirst(), sansa);
        assertSame(AllCharacters.getNext(sansa), arya);
        assertNull(AllCharacters.getNext(arya));
    }

    @Test
    public void testFallInLoveOtherNull() {
        Character sansa = new Character("Sansa Stark", 0.5);
        sansa.fallInLove(null);
        assertNull(sansa.getLoves());
    }

    @Test
    public void testFallInLoveOtherDoesntLove() { 
        Character sansa = new Character("Sansa Stark", 0.5);
        Character jaime = new Character("Jaime Lannister", 0.5);
        jaime.fallInLove(sansa);
        assertNull(sansa.getLoves());
        assertSame(jaime.getLoves(), sansa);
    }
    @Test
    public void testFallInLoveOtherLovesThis() { 
        Character cersei = new Character("Cersei Lannister", 0.9);
        Character jaime = new Character("Jaime Lannister", 0.5);
        jaime.fallInLove(cersei);
        cersei.fallInLove(jaime);
        assertNotNull(cersei.getLoves());
        assertNotNull(jaime.getLoves());
        assertFalse(jaime.isDead());
        assertFalse(cersei.isDead());
    }

    @Test
    public void testFallInLoveOtherLovesDouble() { 
        Character cersei = new Character("Cersei Lannister", 0.9);
        Character jaime = new Character("Jaime Lannister", 0.5);
        Character cerseiDouble = new Character("Cersei Lannister", 0.9);
        jaime.fallInLove(cerseiDouble);
        cersei.fallInLove(jaime);
        assertNotNull(cersei.getLoves());
        assertNotNull(jaime.getLoves());
        assertFalse(jaime.isDead());
        assertFalse(cersei.isDead());
        assertTrue(cerseiDouble.isDead());
    }

    @Test
    public void testFallInLoveOtherLovesThisWicked() {
        Character sansa = new Character("Sansa Stark", 0.5);
        Character cersei = new Character("Cersei Lannister", 0.9);
        Character jaime = new Character("Jaime Lannister", 0.5);
        jaime.fallInLove(sansa);
        cersei.fallInLove(jaime);
        assertNotNull(cersei.getLoves());
        assertNotNull(jaime.getLoves());
        assertFalse(jaime.isDead());
        assertTrue(sansa.isDead());
    }

    @Test
    public void testFallInLoveOtherLovesNotWicked() {
        Character sansa = new Character("Sansa Stark", 0.5);
        Character jaime = new Character("Jaime Lannister", 0.5);
        Character brandon = new Character("Brandon Stark", 0.1);
        jaime.fallInLove(sansa);
        sansa.fallInLove(brandon);
        assertNotNull(jaime.getLoves());
        assertNotNull(sansa.getLoves());
        assertFalse(jaime.isDead());
        assertFalse(brandon.isDead());
    }

}
