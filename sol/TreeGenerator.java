package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.IGenerator;
import src.INode;

import java.util.LinkedList;

/*
 * Class for creating and interacting with a decision tree given a dataset.
 *
 * T is the type of object that we are trying to classify.
 * (like src.Vegetable)
 */
public class TreeGenerator<T extends IAttributeDatum> implements IGenerator {

    IAttributeDataset<T> data;
    INode tree;


    /**
     * Constructor for this class.
     *
     * @param initTrainingData - IAttributeDataset of the data table
     */
    public TreeGenerator(IAttributeDataset<T> initTrainingData) {
        // TODO: Implement.
        this.data = initTrainingData;
        this.tree = null;
    }

    @Override
    public INode buildClassifier(String targetAttr) {
        // TODO: Implement.

        return builder(targetAttr, this.data.getAttributes());
    }

    public INode builder(String targetAttr, LinkedList<String> attr) {
        // TODO: Implement.
        LinkedList<String> attributes = attr;
        attributes.remove(targetAttr);
        if (attributes.size() < 1){
            throw new RuntimeException("Empty List for Attribute list");
        } else if (attributes.size() == 1){
            this.tree = new Leaf(attributes.getFirst(), targetAttr, data);
        } else {
            attr.removeFirst();
            this.tree = new Node(attributes.getFirst(), targetAttr, data, this.builder(targetAttr, attr));
        }

        return this.tree;
    }

    @Override
    public Object lookupRecommendation(IAttributeDatum forVals) {
        // TODO: Implement.
        return this.tree.lookupDecision(forVals);
    }

    @Override
    public void printTree() {
        // TODO: Implement.
        System.out.println(this.tree);
    }
}