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
            int newX = Math.abs(creature.getX() % this.x);
            int newY = Math.abs(creature.getY() % this.y);
        this.things[newY][newX] = null;
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
            int newX = (((creature.getX() % this.x) + this.x) % this.x);
            int newY = (((creature.getY() % this.y) + this.y) % this.y);
        if (things[newY][newX] == null) {
            things[newY][newX] = creature;
            new Thread(creature).start();
        }
        else if (things[newY][newX] != null) {
            AbstractCreature other = things[newY][newX];
            if (Math.random() <= creature.getFitness() - other.getFitness()) {
                this.remove(other);
                this.addCreature(creature);
            }
        }
    }
}
