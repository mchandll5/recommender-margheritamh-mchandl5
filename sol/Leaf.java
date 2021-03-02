package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.INode;

public class Leaf implements INode {
    String ourAttribute;
    String wantedAttribute;
    IAttributeDataset data;
    Edge edges;

    public Leaf (String ourAttribute, String wantedAttribute, IAttributeDataset data) {
        this.ourAttribute = ourAttribute;
        this.wantedAttribute = wantedAttribute;
        this.data = data;
        this.edges = new Edge(data.partition(ourAttribute), ourAttribute, wantedAttribute);
    }



    public Object lookupDecision(IAttributeDatum attrVals){
        if (edges.inside(attrVals.getValueOf(ourAttribute))){
            if (edges.isConclusive(attrVals)){
                return edges.getWantedAttribute(attrVals);
            } else{
                return edges.mostCommonWantedAttribute(attrVals);
            }

        } else{
            return data.mostCommonValue(wantedAttribute);
        }
    }

    // print tree
    public void printNode(String leadspace){
        System.out.println(this);
    }

}
