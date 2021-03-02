package sol;

import src.IAttributeDatum;

public class Vegetable implements IAttributeDatum {
    String color;
    Boolean highFiber;
    Boolean lowCarb;
    Boolean likeToEat;

    public Vegetable(String color, Boolean highFiber, Boolean lowCarb, Boolean likeToEat){
        this.color = color;
        this.highFiber = highFiber;
        this.lowCarb = lowCarb;
        this.likeToEat = likeToEat;
    }

    public Object getValueOf(String attrName) {
        if (attrName.equals("color")){
            return this.color;
        } else if (attrName.equals("highFiber")){
            return this.highFiber;
        } else if (attrName.equals("lowCarb")){
            return this.lowCarb;
        } else if (attrName.equals("likeToEat")){
            return this.likeToEat;
        }
        throw new IllegalArgumentException("Attribute " + attrName + " not found");
    }

}
