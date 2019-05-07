import java.util.Objects;

public class Character extends AllCharacters.BaseCharacter {

    // Name of Character
    private final String name;

    // Wickedness
    private double wickedness;

    // Dead?
    private boolean dead;

    // IT'S LOVE, LET IT HAPPEND AND KEEP SCROLLING!
    private Character loves;

    // Constructor
    public Character(String name, double wickedness) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht leer sein");
        } else {
            this.name = name;
        }

        if (wickedness < 0 || wickedness > 1) {
            throw new IllegalArgumentException("Wert für Bösartigkeit muss zwischen 0 und 1 liegen");
        } else {
            this.wickedness = wickedness;
        }
    }

    // Get Name of Character
    public String getName() {
        return name;
    }

    // Get wickedness
    public double getWickedness() {
        return wickedness;
    }

    // Set wickedness
    public void setWickedness(double wickedness) {
        if (wickedness < 0 || wickedness > 1) {
            throw new IllegalArgumentException("Wert für Bösartigkeit muss zwischen 0 und 1 liegen");
        }
        this.wickedness = wickedness;
    }

    // Check if Character is dead
    public boolean isDead() {
        return dead;
    }

    // Set Dead of a Character
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    // Get him/her a lover plx
    public Character getLoves() {
        return loves;
    }

    // Set Love of this Character
    public void setLoves(Character loves) {
        this.loves = loves;
    }

    // properties of this String
    @Override
    public String toString() {
        return "Character{name=" + name + ", wickedness=" + wickedness + ", dead=" + dead + ", loves=" + (loves == null ? "not in love" : loves.getName()) + "}";
    }

    
    // Check Character with given Character -> return true
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Character character = (Character) object;
        return (wickedness == character.wickedness) &&
                (dead == character.dead) &&
                name.equals(character.name) &&
                Objects.equals(loves, character.loves);
    }

    // Get hashCode of Character
    @Override
    public int hashCode() {
        return Objects.hash(name, wickedness, dead, loves);
    }

    // Murder Character, yikes
    private void kill(Character victim) {
        if (victim.isDead()) {
            throw new IllegalArgumentException("Einen toten Character kann man nicht noch einmal toeten");
        } else {
            victim.setDead(true);
        }
    }

    // Fall in LOVE, NOW... pls.. hurry up.
    public void fallInLove(Character other) {
        if (other == null) return;

        Character otherLove = other.getLoves();

        if (otherLove != null && otherLove != this) {
            if (otherLove.equals(this) || this.wickedness > 0.6) {
                this.kill(otherLove);
            }
        }

        this.setLoves(other);
    }
}