package definingClassesExercise.pokemonTrainer;

import java.util.List;


public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void commandExecuting(String command) {

        if (isExist(command)) {
            numberOfBadges += 1;
        } else {

            for (int i = 0; i < collectionOfPokemon.size(); i++) {
                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                if (collectionOfPokemon.get(i).getHealth() <= 0) {
                    collectionOfPokemon.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : collectionOfPokemon) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + numberOfBadges + " " + collectionOfPokemon.size();
    }
}
