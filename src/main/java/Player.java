public class Player {

    Builder builder;

    public Player(Builder builder) {
        this.builder = builder;
    }

    public void placeBuilder(Tile[][][] board, Builder builder, int xCoordinate, int yCoordinate) {

        board[0][xCoordinate][yCoordinate].setOccupied(true);
        builder.setxCoordinate(xCoordinate);
        builder.setyCoordinate(yCoordinate);
        builder.setzCoordinate(0);
    }

    void moveBuilderNorth(Tile[][][] board, Builder builder) throws InvalidMoveExcpetion {
        //builder current coordinates set to unoccupied
        int zCoordinate = builder.getzCoordinate();
        int xCoordinate = builder.getxCoordinate();
        int yCoordinate = builder.getyCoordinate();

        // remove the builder from the board
        board[zCoordinate][xCoordinate][yCoordinate].setOccupied(false);

        // move the builder one square north
        yCoordinate++;

        // if the proposed new possition is not already occupied, move the builder and update its position
        if (!board[zCoordinate][xCoordinate][yCoordinate].isOccupied) {
            board[zCoordinate][xCoordinate][yCoordinate].setOccupied(true);
            builder.setyCoordinate(yCoordinate);
        } else throw new InvalidMoveExcpetion();

    }
}
