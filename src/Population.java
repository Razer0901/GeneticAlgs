import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by student on 11/27/17.
 */
public class Population {
    public static int[][] elements = {{389,400},{309,380},{339,424},{405,387},{12,174},{298,483},{409,303},{432,497},{414,306},{149,127},{247,341},{327,98},{195,343},{356,122},{49,157},{151,438},{56,460},{317,395},{383,221},{281,395},{394,79},{377,303},{381,308},{299,295},{114,447},{422,360},{288,249},{458,482},{91,314},{104,140},{470,254},{77,25},{213,393},{419,96},{114,199},{490,8},{278,367},{310,159},{175,109},{453,288},{56,375},{147,343},{123,105},{325,214},{418,428},{353,387},{182,429},{411,394},{322,329},{490,436},{28,479},{443,305},{345,253},{463,19},{361,416},{307,417},{291,453},{259,414},{58,83},{127,475},{11,480},{361,192},{409,271},{86,231},{100,75},{166,128},{54,109},{432,399},{361,395},{417,222},{311,224},{138,101},{177,397},{14,234},{480,141},{208,490},{121,68},{182,29},{339,267},{259,438},{342,425},{65,395},{33,497},{293,394},{392,210},{116,203},{433,253},{303,109},{149,317},{342,129},{457,50},{118,77},{117,300},{106,455},{66,365},{393,407},{289,458},{302,322},{455,94},{216,347},{304,331},{49,236},{84,351},{345,233},{168,187},{361,125},{236,479},{201,353},{278,307},{308,344},{171,201},{251,460},{158,52},{282,113},{145,497},{459,449},{327,7},{184,411}};

    private ArrayList<Chromosome> chromosomes;
    private ArrayList<Element> masterElementList;
    private double elitism = 0.2;

    private int size;

    public Population(int size){
        this.size = size;
        this.fill();
        chromosomes = new ArrayList<>();

        masterElementList = new ArrayList<>();
        for (int i = 0; i < Population.elements.length; i++) {
            masterElementList.add(new Element(i));
        }

    }

    public void fill(){
        while (this.chromosomes.size() < this.size)
        {
            if (this.chromosomes.size() < this.size / 3) {
                this.chromosomes.add( new Chromosome( (ArrayList<Element>) this.masterElementList.clone() ) );
            } else {
//                this.mate();
            }
        }
    }

    public void sort(){
        chromosomes.sort((o1, o2) -> o1.calcScore() - o2.calcScore());
    }

    public void kill(){
        int target = (int) (this.elitism * this.chromosomes.size());
        while (this.chromosomes.size() > target){
            this.chromosomes.remove(this.chromosomes.size() - 1);
        }
    }

//    public void mate(){
//        var key1 = pickRandomProperty(this.chromosomes);
//        var key2 = key1;
//
//        while (key2 == key1)
//        {
//            key2 = pickRandomProperty(this.chromosomes);
//        }
//
//        var children = this.chromosomes[key1].mateWith(this.chromosomes[key2]);
//        this.chromosomes = this.chromosomes.concat(children);
//    }
}


/*
Population.prototype.mate = function() {

};
 */
