package first.original;

import java.util.ArrayList;
import java.util.Collections;

public class OrigPopulation {
    private ArrayList<OrigGene> members;
    private String goal;
    private int generationNumber = 0;

    public OrigPopulation(String goal, int size){
        this.members = new ArrayList<>();
        this.goal = goal;
        this.generationNumber = 0;
        for (int i = 0; i < size; i++) {
            OrigGene gene = new OrigGene("");
            gene.generateRandomString(this.goal.length());
            this.members.add(gene);
        }
    }

    public void sort() {
        Collections.sort(members, (o1, o2) -> o1.getCost() - o2.getCost());
    }

    public int generation() {
        while(true) {
            this.sort();
            OrigGene[] children = this.members.get(0).mate(this.members.get(1));
            this.members.remove(members.size() - 1);
            this.members.remove(members.size() - 1);

            this.members.add(children[0]);
            this.members.add(children[1]);

            for (int i = 0; i < this.members.size(); i++) {
                this.members.get(i).mutate(0.5);
                this.members.get(i).calcCost(this.goal);
                if (this.members.get(i).getCode().equals(this.goal)) {
                    this.sort();
                    return generationNumber;
                }
            }

            this.generationNumber++;
        }
    }
}