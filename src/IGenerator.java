package src;

import java.util.LinkedList;

public interface IGenerator {
    // buildClassifier helper function
    public INode builder(String targetAttr, LinkedList<String> attr);

    // build a decision tree to predict the named attribute
    public INode buildClassifier(String targetAttr);

    // produce the decision predicted for the given datum
    public Object lookupRecommendation(IAttributeDatum forVals);

    // print the decision tree
    public void printTree();
}