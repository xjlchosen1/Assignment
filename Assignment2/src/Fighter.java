import java.util.Random;

public class Fighter {

    private String name;
    private double accuracy;
    private boolean isAlive;
    public int numsOfWin = 0;

    public Fighter(String _name, double _accuracy, boolean _isAlive) {
        name = _name;
        accuracy = _accuracy;
        isAlive = _isAlive;
    }

    public void shootAtTarget(Fighter target) {
        Random random = new Random();
        double probability = random.nextDouble();
        //System.out.println(probability);
        //System.out.println(accuracy);
        if(probability <= accuracy) {
            target.setAlive(false);
            //System.out.println(name + " kill " + target.name);
            //System.out.println();
        }

    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean getAlive() {
        return isAlive;
    }


}
