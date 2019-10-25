public class Main {

    private Fighter Gandalf = new Fighter("Gandalf", 1.0/3.0, true);
    private Fighter Merlin = new Fighter("Merlin", 0.5, true);
    private Fighter Dumbledore = new Fighter("Dumbledore", 0.95, true);
    private int numbersOfAlive = 3;

    private void gandalfShoot() {
        if(Dumbledore.getAlive()) {
            Gandalf.shootAtTarget(Dumbledore);
            if (!Dumbledore.getAlive()){
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Gandalf.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        else if(Merlin.getAlive()) {
            Gandalf.shootAtTarget(Merlin);
            if (!Merlin.getAlive()) {
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Gandalf.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        if (numbersOfAlive == 1) {
            Gandalf.numsOfWin ++;
        }
    }

    private void merlinShoot() {
        if(Dumbledore.getAlive()) {
            Merlin.shootAtTarget(Dumbledore);
            if (!Dumbledore.getAlive()){
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Merlin.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        else if(Gandalf.getAlive()) {
            Merlin.shootAtTarget(Gandalf);
            if (!Gandalf.getAlive()){
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Merlin.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        if (numbersOfAlive == 1) {
            Merlin.numsOfWin ++;
        }

    }

    private void dumbledoreShoot() {
        if(Merlin.getAlive()){
            Dumbledore.shootAtTarget(Merlin);
            if (!Merlin.getAlive()) {
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Dumbledore.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        else if(Gandalf.getAlive()){
            Dumbledore.shootAtTarget(Gandalf);
            if (!Gandalf.getAlive()){
                numbersOfAlive--;
                /*if (numbersOfAlive == 1) {
                    Dumbledore.numsOfWin ++;
                }*/
                //System.out.println("numbersoflive is " + numbersOfAlive);
            }
        }
        if (numbersOfAlive == 1) {
            Dumbledore.numsOfWin ++;
        }

    }

    private void startFight(){
        for(int i = 0; i < 10000; i++){
            while (numbersOfAlive > 1) {
                if(Gandalf.getAlive()){
                    gandalfShoot();
                }
                if (Merlin.getAlive()) {
                    merlinShoot();
                }
                if (Dumbledore.getAlive()) {
                    dumbledoreShoot();
                }
            }
            Gandalf.setAlive(true);
            Merlin.setAlive(true);
            Dumbledore.setAlive(true);
            numbersOfAlive = 3;
        }
    }

    //第二种情况，Gandalf不开第一枪
    private void startFight2(){
        for(int i = 1; i < 10000; i++){
            boolean temp = false;
            while (numbersOfAlive > 1) {
                if(Gandalf.getAlive() && temp){
                    gandalfShoot();
                }
                if (Merlin.getAlive()) {
                    merlinShoot();
                }
                if (Dumbledore.getAlive()) {
                    dumbledoreShoot();
                }
                temp = true;
            }
            Gandalf.setAlive(true);
            Merlin.setAlive(true);
            Dumbledore.setAlive(true);
            numbersOfAlive = 3;
        }
    }

    private void outPutResults() {
        System.out.printf("%-16s%-16s%-16s", "Name", "Winning times", "Winning percentage");
        System.out.println();
        System.out.printf("%-16s%-16s%-16s", "Gandalf", Gandalf.numsOfWin, Gandalf.numsOfWin/100.0 + "%");
        System.out.println();
        System.out.printf("%-16s%-16s%-16s", "Merlin", Merlin.numsOfWin, Merlin.numsOfWin/100.0 + "%");
        System.out.println();
        System.out.printf("%-16s%-16s%-16s", "Dumbledore", Dumbledore.numsOfWin, Dumbledore.numsOfWin/100.0 + "%");
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.startFight();
        System.out.println("第一种情况：");
        main.outPutResults();

        System.out.println();

        Main main1 = new Main();
        main1.startFight2();
        System.out.println("第二种情况：");
        main1.outPutResults();
    }
}
