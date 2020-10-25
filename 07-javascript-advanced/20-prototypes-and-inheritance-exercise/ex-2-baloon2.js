function solve(){

    class Balloon {
        constructor(color, gasWeight){
            this.color = color;
            this.gasWeight = gasWeight;
        }
    }

    class PartyBaloon extends Ballon{
        constructor(color, gasWeight, ribbonColor, ribbonLength){
            super(color, gasWeight);
            this._ribbon = {color: ribbonColor, length: ribbonLength}
        }
    }
}

