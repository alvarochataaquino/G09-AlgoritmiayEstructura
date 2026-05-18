package arbolesAVL;

public class PokedexAVL {

    /*Pokédex  cada Pokémon se registra por su número de Pokédex.
 El árbol AVL garantiza búsqueda en O(log n) sin importar el orden de inserción.*/

    public static void main(String[] args) {

        AVLTree pokedex = new AVLTree();

        int[] pokemon = {25, 6, 9, 1, 4, 150, 131, 39, 52, 143};
        

        String[] nombres = {
            "Tinkaton", "Shuckle", "Basculegion", "Kingabit", "Gyarados",
            "Mew", "Goodra", "Pelipper", "Meowth de Alola", "Manaphy"
        };

        System.out.println("=------- Pokédex AVL ---------------------------");
        System.out.println("Registrando Pokémon por número de Pokédex...");
        System.out.println();

        for (int i = 0; i < pokemon.length; i++) {
            System.out.println("Insertando #" + pokemon[i] + " - " + nombres[i]);
            pokedex.insert(pokemon[i]);
            pokedex.printTree();
            System.out.println();
        }

        System.out.println("=== Pokédex completa ===");
        pokedex.printTree();
    }
}