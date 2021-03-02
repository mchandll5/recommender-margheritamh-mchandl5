package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;

import java.util.LinkedList;

/*
 * Class for a specific representation of rows in a data table. This uses a list
 * of objects (one object per row).
 * The type T is the object that forms the "rows" of the data table
 */
public class ListObjsData<T extends IAttributeDatum>
        implements IAttributeDataset<T> {

    LinkedList<String> attributes;
    LinkedList<T> objects;

    public ListObjsData(LinkedList<String> attributes, LinkedList<T> objects){
        this.attributes = attributes;
        this.objects = objects;

    }

    // all the attributes in the dataset
    @Override
    public LinkedList<String> getAttributes() {
        // TODO: Implement.

        return attributes;
    }

    public LinkedList<T> getObjects() { //Helper function I added to get objects
        // TODO: Implement.

        return objects;
    }



    // does every row/datum have the same value for the given attribute/column
    @Override
    public boolean allSameValue(String ofAttribute) {
        // TODO: Implement.
        int n = 1;
        Object baseline = this.objects.get(0).getValueOf(ofAttribute);

        // is baseline == to next, yes, check next, no return false
        while (n < this.size()){
            if (baseline == this.objects.get(n).getValueOf(ofAttribute)){
                n = n + 1;
            } else{
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        // TODO: Implement.
        return this.objects.size();

    }

    // partition rows into subsets such that each subset has same value of
    // onAttribute
    @Override
    public LinkedList<IAttributeDataset<T>> partition(String onAttribute) {
        // TODO: Implement.

        LinkedList<IAttributeDataset<T>> partitioned = new LinkedList<IAttributeDataset<T>>();
        LinkedList<T> firstObj = new LinkedList<T>();
        firstObj.add(this.objects.get(0));
        IAttributeDataset<T> result = new ListObjsData<T>(this.attributes, firstObj); // have a dataset with first obj in it
        partitioned.add(result);


        int index0fDataSet = 1;
        while (index0fDataSet < this.objects.size()){
            int indexOfPartition = 0;
           while (indexOfPartition < partitioned.size()){
               if (partitioned.get(indexOfPartition).getObjects().getFirst().getValueOf(onAttribute).equals(
                       this.objects.get(index0fDataSet).getValueOf(onAttribute))){
                    partitioned.get(indexOfPartition).getObjects().add(this.objects.get(index0fDataSet));
                    break;
               } else if (indexOfPartition + 1 >= partitioned.size()) {
                   LinkedList<T> obj = new LinkedList<T>();
                   obj.add(this.objects.get(index0fDataSet));
                   IAttributeDataset<T> res = new ListObjsData<T>(this.attributes, obj); // have a dataset with first obj in it
                   partitioned.add(res);
                   break;
               } else{
                   indexOfPartition++;
                }
            }
           index0fDataSet++;
        }

        return partitioned;
    }

    // get the value for ofAttribute, which is assumed to be common across all
    // rows
    @Override
    public Object getSharedValue(String ofAttribute) {
        // TODO: Implement.
        return this.objects.get(0).getValueOf(ofAttribute);

    }

    // get the most common value for ofAttribute in the dataset
    @Override
    public Object mostCommonValue(String ofAttribute) {
        // TODO: Implement.
        LinkedList<IAttributeDataset<T>> partitioned = this.partition(ofAttribute);
        int index = 1;
        int mostComIndex = 0;

        while (index < partitioned.size()){
            if(partitioned.get(index).size() > partitioned.get(mostComIndex).size()){
                mostComIndex = index;
                index++;
            } else{
                index++;
            }

        }
        Object mostCommonValue = partitioned.get(mostComIndex).getObjects().get(0).getValueOf(ofAttribute);
        return mostCommonValue;
    }
}
