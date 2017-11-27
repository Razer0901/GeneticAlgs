package first;

public class Population {
    private Gene[] members;
    private String goal;
    private int generationNumber = 0;
    private int bi1, bi2, wi1, wi2;

    public Population(String goal, int size){
        this.members = new Gene[size];
        this.goal = goal;
        this.generationNumber = 0;
        for (int i = 0; i < size; i++) {
            Gene gene = new Gene("", goal);
            gene.generateRandomString(this.goal.length());
            this.members[i] = gene;
        }
    }

    public void notSort() {
        bi1 = 0;
        bi2 = 1;

        wi1 = 0;
        wi2 = 1;

        int bc1 = members[bi1].getCost();
        int bc2 = members[bi2].getCost();

        int wc1 = members[wi1].getCost();
        int wc2 = members[wi2].getCost();

        for (int i = 2; i < members.length; i++) {
            int tempCost = members[i].getCost();
            if (tempCost < bc1) {
                bi1 = i;
                bc1 = tempCost;
            }else if (tempCost < bc2) {
                bi2 = i;
                bc2 = tempCost;
            }

            if (tempCost > wc1) {
                wi1 = i;
                wc1 = tempCost;
            }else if (tempCost > wc2) {
                wi2 = i;
                wc2 = tempCost;
            }
        }
    }

    public int generation() {
        while(true) {
            this.notSort();

            if (this.members[bi1].getCode().equals(this.goal)) {
                return generationNumber;
            }else if (this.members[bi2].getCode().equals(this.goal)) {
                return generationNumber;
            }

            Gene[] children = this.members[bi1].mate(this.members[bi2]);

//            this.members.set(wi1,children[0]);
//            this.members.set(wi2,children[first]);

            this.members[wi1] = children[0];
            this.members[wi2] = children[1];

            for (Gene gene : this.members) {
                gene.mutate(Main.mutateChance);
            }

            this.generationNumber++;
        }
    }

    @Override
    public String toString() {
        if(this.members[bi1].getCost() > this.members[bi2].getCost()) {
            return this.members[bi2].getCode();
        }else{
            return this.members[bi1].getCode();
        }
    }
}