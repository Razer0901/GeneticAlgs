package first;

public class Gene {
    private String code, target;
    private int cost = -1;

    public Gene (String code, String target) {
        this.code = code;
        this.target = target;
        this.calcCost(target);
    }

    public void generateRandomString(int length) {
        for (int i = 0; i < length; i++) {
            code += Character.toString((char) (Math.random() * (127-32) + 32));
        }
    }

    public void mutate(double chance) {
        if (Math.random() > chance) return;

        int index = (int)(Math.random() * code.length());
        int temp = (int) (Math.random() * Main.mutateRange);
        int upOrDown = Math.random() <= 0.5 ? -1 - temp: 1 + temp;
        String newChar = Character.toString((char)(code.charAt(index) + upOrDown));

        code = code.substring(0, index) + newChar + code.substring(index + 1);
        calcCost(target);
    }

    public Gene[] mate (Gene gene) {
        int pivot = Math.round(this.code.length() / 2) - 1;
        String child1 = this.code.substring(0,pivot) + gene.getCode().substring(pivot);
        String child2 = gene.getCode().substring(0,pivot) + this.code.substring(pivot);

        return new Gene[]{new Gene(child1, target), new Gene(child2, target)};
    }

    public String getCode() {
        return code;
    }

    public void calcCost(String compareTo) {
        int total = 0;
        for (int i = 0; i < this.code.length(); i++) {
            int temp = this.code.charAt(i) - compareTo.charAt(i);
            total += temp * temp;
        }
        this.cost = total;
    }

    public Integer getCost() {
        return cost;
    }
}
