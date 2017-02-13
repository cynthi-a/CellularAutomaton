public class Grid {
    private final int x;
    private final int y;
    private final Creature[][] things;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.things = new Creature[y][x];
    }

    public void remove(Creature creature) {
        this.things[creature.getY()][creature.getX()] = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Creature[] row : things) {
            for (Creature creature : row) {
                if (creature == null) {
                    stringBuilder.append('-');
                } else {
                    stringBuilder.append('1');
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
                things[creature.getY()][creature.getX()] == null
                ) {
            things[creature.getY()][creature.getX()] = creature;
            new Thread(creature).start();
        }
    }

}
