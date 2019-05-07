public class Main {
    
    public static void main(String... args) {
        Character sansaStark = new Character("Sansa Stark", 0.5);
        Character cerseiLannister = new Character("Cersei Lannister", 0.9);
        Character jaimeLannister = new Character("Jaime Lannister", 0.5);

        output();

        jaimeLannister.fallInLove(sansaStark);
        cerseiLannister.fallInLove(jaimeLannister);

        output();

        jaimeLannister.fallInLove(cerseiLannister);
        cerseiLannister.fallInLove(jaimeLannister);

        output();
    }

    
    // Print all characters to command line
     
    private static void output() {
        Character character = AllCharacters.getFirst();
        while (character != null) {
            System.out.println(character);
            character = AllCharacters.getNext(character);
        }
        System.out.println();
    }
}