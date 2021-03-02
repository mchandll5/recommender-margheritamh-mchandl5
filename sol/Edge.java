package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;

import java.util.LinkedList;

public class Edge {
    LinkedList<IAttributeDataset<IAttributeDatum>> edges;
    String ourAttribute;
    String wantedAttribute;

    public Edge (LinkedList<IAttributeDataset<IAttributeDatum>> edges, String ourAttribute, String wantedAttribute){
        this.edges = edges;
        this.ourAttribute = ourAttribute;
        this.wantedAttribute =  wantedAttribute;
    }

    public LinkedList<IAttributeDataset<IAttributeDatum>> getEdges(){
        return edges;
    }

    public Boolean inside(Object value){
        int index = 0;
        while (index < this.edges.size()){
            if (this.edges.get(index).getSharedValue(ourAttribute).equals(value)){
                return true;
            }else{
                index++;
            }

            }
        return false;
    }

    public int indexLocal(Object value){
        int index = 0;
        while (index < this.edges.size()){
            if (this.edges.get(index).getSharedValue(ourAttribute).equals(value)){
                return index;
            }else{
                index++;
            }

            }
        throw new RuntimeException("value is not here.");
    }

    public Boolean isConclusive(IAttributeDatum item){

        if (this.inside(item.getValueOf(ourAttribute))){ //if value is there
            return this.edges.get(this.indexLocal(item.getValueOf(ourAttribute))).allSameValue(wantedAttribute);
        } else{
            return false;
        }


    }
    public Object getWantedAttribute(IAttributeDatum item){

        return this.edges.get(this.indexLocal(item.getValueOf(ourAttribute))).getSharedValue(wantedAttribute);

    }

    public Object mostCommonWantedAttribute(IAttributeDatum item){

        return this.edges.get(this.indexLocal(item.getValueOf(ourAttribute))).mostCommonValue(wantedAttribute);

    }



}
