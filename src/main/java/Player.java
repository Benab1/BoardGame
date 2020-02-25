import java.util.Arrays;
import java.util.List;

public class Player {

    Builder builder;

    public Player(Builder builder) {
        this.builder = builder;
    }

    // for the first time placement of the builder
    public void placeBuilder(Tile[][][] board, Builder builder, int xCoordinate, int yCoordinate) {

        board[0][xCoordinate][yCoordinate].setOccupied(true);
        builder.setxCoordinate(xCoordinate);
        builder.setyCoordinate(yCoordinate);
        builder.setzCoordinate(0);
    }

    public List<Move> getMoveList(){
        Move moveNorth = new Move(0,1);
        Move moveNorthEast = new Move(1,1);
        Move moveEast = new Move(1,0);
        Move moveSouthEast = new Move(-1,1);
        Move moveSouth = new Move(0,-1);
        Move moveSouthWest = new Move(-1,-1);
        Move moveWest = new Move(-1,0);
        Move moveNorthWest = new Move(-1,1);
        return Arrays.asList(moveNorth,moveNorthEast,moveEast,moveSouthEast,moveSouth,moveSouthWest,moveWest,moveNorthWest);
    }

    void moveBuilder(Tile[][][] board, Builder builder,Move move) throws InvalidMoveExcpetion {
        //builder current coordinates set to unoccupied
        int zCoordinate = builder.getzCoordinate();
        int xCoordinate = builder.getxCoordinate();
        int yCoordinate = builder.getyCoordinate();

        // remove the builder from the board
        board[zCoordinate][xCoordinate][yCoordinate].setOccupied(false);

        // move the builder in accordance with the move
        xCoordinate += move.getX();
        yCoordinate += move.getY();

        // if the proposed new possition is not already occupied, move the builder and update its position
        if (!board[zCoordinate][xCoordinate][yCoordinate].isOccupied) {
            board[zCoordinate][xCoordinate][yCoordinate].setOccupied(true);
            builder.setyCoordinate(yCoordinate);
        } else throw new InvalidMoveExcpetion();

    }
}
