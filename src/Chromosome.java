import java.util.ArrayList;

/**
 * Created by student on 11/17/17.
 */
public class Chromosome {
    ArrayList<Integer> activeElements;

    public Chromosome(ArrayList<Integer> activeElements) {
        this.activeElements = activeElements;
        for (var element in this.members)
        {
            if (typeof this.members[element]['active'] == 'undefined')
            {
                this.members[element]['active'] = Math.round( Math.random() );
            }
        }
        this.mutate();
        this.calcScore();
    }
}
