package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.INode;

public class Node implements INode {
    String ourAttribute;
    String wantedAttribute;
    IAttributeDataset data;
    Edge edges;
    INode next;

    public Node (String ourAttribute, String wantedAttribute, IAttributeDataset data, INode next){
        this.ourAttribute = ourAttribute;
        this.wantedAttribute = wantedAttribute;
        this.data = data;
        this.edges = new Edge (data.partition(ourAttribute), ourAttribute, wantedAttribute);
        this.next = next;
    }



    // traverse tree based on attribute values to retrieve decision
    public Object lookupDecision(IAttributeDatum attrVals){
        if (edges.inside(attrVals.getValueOf(ourAttribute))){
            if (edges.isConclusive(attrVals)){
                return edges.getWantedAttribute(attrVals);
            } else { //if (next != null){
                return next.lookupDecision(attrVals);
            }
            /*
            else{
                return edges.mostCommonWantedAttribute(attrVals);
            }
            */

        } else{
            return data.mostCommonValue(wantedAttribute);
        }
    }

    // print tree
    public void printNode(String leadspace){
        System.out.println(this);
    }
}
