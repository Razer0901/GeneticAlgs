package first.original;
/**
 * Created by student on 11/13/17.
 */
public class OrigGene {
    private String code = "";
    private int cost;

    public OrigGene (String code) {
        this.code = code;
        this.cost = 9999;
    }

    public void generateRandomString(int length) {
        for (int i = 0; i < length; i++) {
            code += Character.toString((char) (Math.random() * (256)));
        }
    }

    public void mutate(double chance) {
        if (Math.random() > chance) return;

        int index = (int)(Math.random() * code.length());
        int upOrDown = Math.random() <= 0.5 ? -1 : 1;
        String newChar = Character.toString((char)(code.charAt(index) + upOrDown));
        String newString = "";
        for (int i = 0; i < code.length(); i++) {
            if (i == index) newString += newChar;
            else newString += code.substring(i, i+1);
        }

        code = newString;
    }

    public OrigGene[] mate (OrigGene gene) {
        int pivot = Math.round(this.code.length() / 2) - 1;
        String child1 = this.code.substring(0,pivot) + gene.getCode().substring(pivot);
        String child2 = gene.getCode().substring(0,pivot) + this.code.substring(pivot);

        return new OrigGene[]{new OrigGene(child1), new OrigGene(child2)};
    }

    public String getCode() {
        return code;
    }

    public void calcCost(String compareTo) {
        int total = 0;
        for (int i = 0; i < this.code.length(); i++) {
            total += Math.abs(this.code.charAt(i) - compareTo.charAt(i));
        }
        this.cost = total;
    }

    public Integer getCost() {
        return cost;
    }
}
