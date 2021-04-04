
/**
 * @author Khaled Badran
 */

package game.model;

public enum PlayingFieldTile {
    PLAYER(" I "), MINE(" * "), GROUND("   "), DESTINATION(" # "), MONEY(" $ "), DEATH(" X ");
    
    private final String output; //important for printing the playing field

    private PlayingFieldTile(String str) {
        this.output = str;
    }

    public String toString() {
        return output;
    }
}
