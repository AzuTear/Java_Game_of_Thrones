/* (C) 2017, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.11.7
 * mozart: Intel Core i7-4600U/3300 MHz, 4 Core(s), 11706 MByte RAM
 */

import java.util.ArrayList;
import java.util.List;


/**
 * Klasse zur Verwaltung der Character.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2019-04-21
 */
public class AllCharacters
{

	/**
     * Innere Klasse zum Einfuegen der Character in eine Liste.
	 *
	 */
	public static class BaseCharacter{

		/**
         * Erzeugt einen Character und fuegt ihn in die Liste ein.
		 *
		 */
		public BaseCharacter() {
			characters.add((Character)this);
		}

	}

	/**
     * Liste der existierenden Character.
	 *
	 */
	private static final List<Character> characters = new ArrayList<>();

	/**
     * Liefert den ersten Character in der Liste, null wenn die Liste leer ist.
	 * @return den ersten Character oder null.
	 */
	public static Character getFirst (){
		return characters.isEmpty() ? null : characters.get(0);
	}

	/**
     * Liefert den nächsten Character in der Liste,
	 * null am Listenende oder bei falschem Index.
	 *
	 * @param character der n�chste Character.
	 * @return
	 */
	public static Character getNext (Character character){
		final int index = characters.indexOf(character);
		if (index < 0 )
			return null;
		if (index == characters.size()-1)
			return null;
		return characters.get(index+1);
	}

	/**
     * Löscht alle Character in der Liste.
	 *
	 */
	public static void clear(){
		characters.clear();
	}
}
