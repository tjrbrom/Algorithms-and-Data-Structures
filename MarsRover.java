/**
 * 5x5 (x y) array
 *
 * An example position might be 0, 0, N,
 * which means the rover is in the bottom left corner and facing North.
 *
 * L (90 degrees left), R(90 degrees right), M(move forward)
 *
 * Assume that the square directly North from (x, y) is (x, y + 1).
 *
 */
class Rover {

    int x;
    int y;
    Direction direction;

    Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    Direction getDirection() {
        return direction;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }

    void printPosition() {
        System.out.println("x: " + x + ", y: " + y + ", direction: " + direction);
    }
}

enum Direction { N, E, S, W }

public class MarsRover {

    private static Rover currentRover;

    public static void main(String args[]) {

        MarsRover.placeAtPosition(new Rover(1, 2, Direction.N));
        MarsRover.rotateAndMove("LMLMLMLMM");
        MarsRover.printPositionCoordinates(); // x: 1, y: 3, direction: N

        MarsRover.placeAtPosition(new Rover(3, 3, Direction.E));
        MarsRover.rotateAndMove("MMRMMRMRRM");
        MarsRover.printPositionCoordinates(); // x: 5, y: 1, direction: E
    }

    private static void placeAtPosition(Rover rover) {
        validateCoordinates(rover);
        currentRover = rover;
    }

    private static void validateCoordinates(Rover rover) {
        if(!(rover.x <= 5 && rover.x >= 0 && rover.y <= 5 && rover.y >= 0)) {
            throw new IllegalArgumentException("wrong coordinates, must be between 0 and 5");
        }
    }

    private static void rotateAndMove(String command) {
        for(char c : command.toCharArray()) {
            Direction previousDir = currentRover.getDirection();
            if (c == 'L') {
                if(previousDir.equals(Direction.N)) {
                    currentRover.setDirection(Direction.W);
                } else {
                    currentRover.setDirection(Direction.values()[previousDir.ordinal() - 1]);
                }
            } else if(c == 'R') {
                if(previousDir.equals(Direction.W)) {
                    currentRover.setDirection(Direction.N);
                } else {
                    currentRover.setDirection(Direction.values()[previousDir.ordinal() + 1]);
                }
            } else if(c == 'M') {
                if(currentRover.direction == Direction.N) {
                    currentRover.y++;
                } else if(currentRover.direction == Direction.E) {
                    currentRover.x++;
                } else if(currentRover.direction == Direction.S) {
                    currentRover.y--;
                } else if(currentRover.direction == Direction.W) {
                    currentRover.x--;
                }
            } else {
                throw new IllegalArgumentException("wrong command characters, use L R or M");
            }
        }
    }

    private static void printPositionCoordinates() {
        currentRover.printPosition();
    }

}
