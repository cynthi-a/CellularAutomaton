public class Grid {
    private final int x;
    private final int y;
    private final Creature[][] things;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.things = new Creature[x][y];
    }

    public void remove(Creature creature) {
        this.things[creature.getX()][creature.getY()] = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Creature[] row : things) {
            for (Creature creature : row) {
                if (creature == null) {
                    stringBuilder.append('O');
                } else {
                    stringBuilder.append('*');
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public void addCreature(Creature creature) {
        if(
                creature.getX() < (x) &&
                creature.getX() >= (0) &&
                creature.getY() < (y) &&
                creature.getY() >= (0) &&
                things[creature.getX()][creature.getY()] == null
                ) {
            things[creature.getX()][creature.getY()] = creature;
            new Thread(creature).start();
        }
    }
}
