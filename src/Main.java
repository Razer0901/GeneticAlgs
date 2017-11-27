/**
 * Created by student on 11/17/17.
 */
public class Main {
    int[][] elements = {{389,400},{309,380},{339,424},{405,387},{12,174},{298,483},{409,303},{432,497},{414,306},{149,127},{247,341},{327,98},{195,343},{356,122},{49,157},{151,438},{56,460},{317,395},{383,221},{281,395},{394,79},{377,303},{381,308},{299,295},{114,447},{422,360},{288,249},{458,482},{91,314},{104,140},{470,254},{77,25},{213,393},{419,96},{114,199},{490,8},{278,367},{310,159},{175,109},{453,288},{56,375},{147,343},{123,105},{325,214},{418,428},{353,387},{182,429},{411,394},{322,329},{490,436},{28,479},{443,305},{345,253},{463,19},{361,416},{307,417},{291,453},{259,414},{58,83},{127,475},{11,480},{361,192},{409,271},{86,231},{100,75},{166,128},{54,109},{432,399},{361,395},{417,222},{311,224},{138,101},{177,397},{14,234},{480,141},{208,490},{121,68},{182,29},{339,267},{259,438},{342,425},{65,395},{33,497},{293,394},{392,210},{116,203},{433,253},{303,109},{149,317},{342,129},{457,50},{118,77},{117,300},{106,455},{66,365},{393,407},{289,458},{302,322},{455,94},{216,347},{304,331},{49,236},{84,351},{345,233},{168,187},{361,125},{236,479},{201,353},{278,307},{308,344},{171,201},{251,460},{158,52},{282,113},{145,497},{459,449},{327,7},{184,411}};
    public static void main(String[] args) {

    }

    public static int[] pickElement(int[][] elements) {
        return elements[(int)Math.random() * elements.length];
    }
}


/*
var Chromosome = function(members) {
    this.members = members;
    for (var element in this.members)
    {
        if (typeof this.members[element]['active'] == 'undefined')
        {
            this.members[element]['active'] = Math.round( Math.random() );
        }
    }
    this.mutate();
    this.calcScore();
};
Chromosome.prototype.mutate = function() {
    if (Math.random() > this.mutationRate)
        return false;
    var element = pickRandomProperty(this.members);
    this.members[element]['active'] = Number(! this.members[element]['active']);
};
Chromosome.prototype.calcScore = function() {
    if (this.score)
        return this.score;

    this.value = 0;
    this.weight = 0;
    this.score = 0;

    for (var element in this.members)
    {
        if (this.members[element]['active'])
        {
            this.value += this.members[element]['value'];
            this.weight += this.members[element]['weight'];
        }
    }

    this.score = this.value;

    if (this.weight > this.maxWeight)
    {
        this.score -= (this.weight - this.maxWeight) * 50;
    }

    return this.score;
};
Chromosome.prototype.mateWith = function(other) {
    var child1 = {};
    var child2 = {};
    var pivot = Math.round( Math.random() * (length(this.members) - 1) );
    var i = 0;
    for (var element in elements)
    {
        if (i < pivot)
        {
            child1[element] = clone(this.members[element]);
            child2[element] = clone(other.members[element]);
        }
        else
        {
            child2[element] = clone(this.members[element]);
            child1[element] = clone(other.members[element]);
        }
        i++;
    }

    child1 = new Chromosome(child1);
    child2 = new Chromosome(child2);

    return [child1, child2];
};
Chromosome.prototype.weight = 0;
Chromosome.prototype.value = 0;
Chromosome.prototype.members = [];
Chromosome.prototype.maxWeight = 1000;
Chromosome.prototype.mutationRate = 0.7;
Chromosome.prototype.score = 0;


var Population = function(elements, size)
{
    if ( ! size )
        size = 20;
    this.elements = elements;
    this.size = size;
    this.fill();
};
Population.prototype.fill = function() {
    while (this.chromosomes.length < this.size)
    {
        if (this.chromosomes.length < this.size / 3)
        {
            this.chromosomes.push( new Chromosome( clone(this.elements) ) );
        }
        else
        {
            this.mate();
        }
    }
};
Population.prototype.sort = function() {
    this.chromosomes.sort(function(a, b) { return b.calcScore() - a.calcScore(); });
};
Population.prototype.kill = function() {
    var target = Math.floor( this.elitism * this.chromosomes.length );
    while (this.chromosomes.length > target)
    {
        this.chromosomes.pop();
    }
};
Population.prototype.mate = function() {
    var key1 = pickRandomProperty(this.chromosomes);
    var key2 = key1;

    while (key2 == key1)
    {
        key2 = pickRandomProperty(this.chromosomes);
    }

    var children = this.chromosomes[key1].mateWith(this.chromosomes[key2]);
    this.chromosomes = this.chromosomes.concat(children);
};
Population.prototype.generation = function(log) {
    this.sort();
    this.kill();
    this.mate();
    this.fill();
    this.sort();
};
Population.prototype.display = function(i, noImprovement) {
    document.getElementById('gen_no').innerHTML = i;
    document.getElementById('weight').innerHTML = this.chromosomes[0].weight;
    document.getElementById('value').innerHTML = this.chromosomes[0].score;
    document.getElementById('nochange').innerHTML = noImprovement;

};
Population.prototype.run = function(threshold, noImprovement, lastScore, i) {
    if ( ! threshold )
        threshold = 1000;
    if ( ! noImprovement )
        noImprovement = 0;
    if ( ! lastScore )
        lastScore = false;
    if ( ! i )
        i = 0;

    if (noImprovement < threshold)
    {
        lastScore = this.chromosomes[0].calcScore();
        this.generation();

        if (lastScore >= this.chromosomes[0].calcScore())
        {
            noImprovement++;
        }
        else
        {
            noImprovement = 0;
        }

        i++;

        if (i % 10 == 0)
            this.display(i, noImprovement);
        var scope = this;
        setTimeout(function() { scope.run(threshold, noImprovement, lastScore, i) }, 1);

        return false;

    }
    this.display(i, noImprovement);
};


Population.prototype.elitism = 0.2;
Population.prototype.chromosomes = [];
Population.prototype.size = 100;
Population.prototype.elements = false;


var p;
p = new Population(clone(elements));

document.getElementById('runbutton').onclick = function() {
   p.run(document.getElementById('runfor').value);
};
 */