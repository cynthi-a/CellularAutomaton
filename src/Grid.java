public class Grid {
    private final int x;
    private final int y;
    private final AbstractCreature[][] things;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.things = new AbstractCreature[y][x];
    }

    public void remove(AbstractCreature creature) {
        this.things[creature.getY()][creature.getX()] = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (AbstractCreature[] row : things) {
            for (AbstractCreature creature : row) {
                if (creature == null) {
                    stringBuilder.append('-');
                } else {
                    stringBuilder.append(creature.getIdentifier());
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public void addCreature(AbstractCreature creature) {
        //System.err.println("" + creature.getY() + " " + creature.getY());
        if (
                creature.getX() < (x) &&
                creature.getX() >= (0) &&
                creature.getY() < (y) &&
                creature.getY() >= (0) &&
                things[creature.getY()][creature.getX()] == null
                ) {
            things[creature.getY()][creature.getX()] = creature;
            new Thread(creature).start();
        }
        else if (
                creature.getX() < (x) &&
                creature.getX() >= (0) &&
                creature.getY() < (y) &&
                creature.getY() >= (0) &&
                things[creature.getY()][creature.getX()] != null
            ) {
            AbstractCreature other = things[creature.getY()][creature.getX()];
            if (Math.random() <= creature.getFitness() - other.getFitness()) {
                this.remove(other);
                this.addCreature(creature);
            }
        }
    }
}
