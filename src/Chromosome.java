import java.util.ArrayList;

/**
 * Created by student on 11/17/17.
 */
public class Chromosome {
    private ArrayList<Element> elements;
    private double mutationRate = 0.7, maxWeight = 1000, weight = 0;
    private int score = -1, value = 0;


    public Chromosome(ArrayList<Element> elements) {
        if(elements == null) {
            this.elements = (ArrayList<Element>) Population.masterElementList.clone();
            for (Element element : this.elements) {
//            System.out.print("1");
//            if (!element.isActive()){
                if (Math.random() > 0.950) {
//                    System.out.print("t");
                    element.setActive(true);
                } else {
//                    System.out.print("f");
                    element.setActive(false);
                }
//            }
            }
        }else {
            this.elements = (ArrayList<Element>) elements.clone();

            for (Element element : this.elements) {
//            System.out.print("1");
//            if (!element.isActive()){
                if (Math.random() > 0.70) {
//                    System.out.print("t");
                    element.setActive(true);
                } else {
//                    System.out.print("f");
                    element.setActive(false);
                }
//            }
            }
        }
//        System.out.println();
        this.mutate();
        this.calcScore();
    }

    public boolean mutate(){
        if (Math.random() > this.mutationRate)
            return false;

        Element temp = pickElement();

        temp.setActive(!temp.isActive());
        return true;
    }

    public Element pickElement() {
        return elements.get((int)(Math.random() * elements.size()));
    }

    public int calcScore(){
        if(this.score != -1){
            return this.score;
        }
        this.value = 0;
        this.weight = 0;
        this.score = 0;
        for (Element element:elements){
            if (element.isActive()){
                this.value += element.getValue();
                this.weight += element.getWeight();
            }
        }


        this.score = this.value;

        if (this.weight > this.maxWeight)
        {
            this.score -= (this.weight - this.maxWeight) * Main.chromoPen;
        }

        return this.score;
    }

    public Chromosome[] mateWith(Chromosome other) {
        ArrayList<Element> list1 = new ArrayList<>();
        ArrayList<Element> list2 = new ArrayList<>();

        int pivot = (int) (Math.random() * (this.elements.size()));


        ArrayList<Element> thisTemp = (ArrayList<Element>)this.getElements().clone();
        ArrayList<Element> otherTemp = (ArrayList<Element>)other.getElements().clone();

        list1.addAll(thisTemp.subList(0,pivot));
        list1.addAll(otherTemp.subList(pivot,otherTemp.size()));

        list2.addAll(otherTemp.subList(0,pivot));
        list2.addAll(thisTemp.subList(pivot,thisTemp.size()));

        Chromosome child1 = new Chromosome(list1);
        Chromosome child2 = new Chromosome(list2);

        return new Chromosome[]{child1, child2};
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public int getScore() {
        return score;
    }
}

/*

 */