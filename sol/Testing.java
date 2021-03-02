package sol;

import src.IAttributeDataset;
import src.IAttributeDatum;
import src.INode;
import tester.Tester;

import java.util.LinkedList;

public class Testing {
    public Testing(){}

    public IAttributeDataset setupNoData(){

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, veggie);

        return veggiePreference;
    }

    public IAttributeDataset setupDiffLength(){
        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", false, true, true);

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();
        veggie.add(spinach);
        veggie.add(kale);
        veggie.add(peas);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, veggie);

        return veggiePreference;
    }

    public IAttributeDataset setupGreenData(){
        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable lettuce = new Vegetable("green", true, false,  true);

        LinkedList<IAttributeDatum> green = new LinkedList<IAttributeDatum>();
        green.add(spinach);
        green.add(kale);
        green.add(peas);
        green.add(lettuce);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, green);

        return veggiePreference;
    }




    public IAttributeDataset setupCarbConclusive(){
        Vegetable spinach = new Vegetable("green", true, true, true);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", true, true, true);
        Vegetable carrot = new Vegetable("orange", true, false, false);
        Vegetable lettuce = new Vegetable("green", true, false,  false);
        Vegetable califlower = new Vegetable("white", true,true, true);

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();
        veggie.add(spinach);
        veggie.add(kale);
        veggie.add(peas);
        veggie.add(carrot);
        veggie.add(lettuce);
        veggie.add(califlower);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, veggie);

        return veggiePreference;
    }

    public IAttributeDataset setupAllSame(){
        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", true, true, true);
        Vegetable carrot = new Vegetable("orange", true, false, false);
        Vegetable lettuce = new Vegetable("green", true, false,  true);
        Vegetable califlower = new Vegetable("white", true,true, true);

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();
        veggie.add(spinach);
        veggie.add(kale);
        veggie.add(peas);
        veggie.add(carrot);
        veggie.add(lettuce);
        veggie.add(califlower);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, veggie);

        return veggiePreference;
    }

    public IAttributeDataset setup(){
        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable lettuce = new Vegetable("green", true, false,  true);
        Vegetable califlower = new Vegetable("white", true,true, true);

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();
        veggie.add(spinach);
        veggie.add(kale);
        veggie.add(peas);
        veggie.add(carrot);
        veggie.add(lettuce);
        veggie.add(califlower);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");


        IAttributeDataset veggiePreference = new ListObjsData(makingAVeggie, veggie);

        return veggiePreference;
    }

    public INode treeBuild(IAttributeDataset data){

        INode tree = new Node("color", "likeToEat", data,
                new Node("highFiber", "likeToEat", data,
                        new Leaf("lowCarb", "likeToEat", data)));
        return tree;

    }

    public Edge makeColorEdge(){
        IAttributeDataset data = this.setup();
        Edge edge = new Edge(data.partition("color"), "color", "likeToEat");
        return edge;
    }

    public Edge makeFiberEdgeIncon(){
        IAttributeDataset data = this.setup();
        Edge edge = new Edge(data.partition("highFiber"), "highFiber", "likeToEat");
        return edge;
    }

    public Edge makeFiberEdgeAllSame(){
        IAttributeDataset data = this.setupAllSame();
        Edge edge = new Edge(data.partition("highFiber"), "highFiber", "likeToEat");
        return edge;
    }

    public Edge makeCarbEdgeCon(){
        IAttributeDataset data = this.setupCarbConclusive();
        Edge edge = new Edge(data.partition("lowCarb"), "lowCarb", "likeToEat");
        return edge;
    }

    // ListObjsData methods

    public void testGetAttributes(Tester t){
        IAttributeDataset data = this.setup();

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");

        t.checkExpect(data.getAttributes(), makingAVeggie);

    }

    // Helper function I added to get objects
    public void testGetObjects(Tester t){
        IAttributeDataset data = this.setup();

        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable lettuce = new Vegetable("green", true, false,  true);
        Vegetable califlower = new Vegetable("white", true,true, true);

        LinkedList<IAttributeDatum> veggie = new LinkedList<IAttributeDatum>();
        veggie.add(spinach);
        veggie.add(kale);
        veggie.add(peas);
        veggie.add(carrot);
        veggie.add(lettuce);
        veggie.add(califlower);

        t.checkExpect(data.getObjects(), veggie);

    }
/*
    public void testContains(Tester t){
        IAttributeDataset data = this.setup();

        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable beans = new Vegetable("brown", false, false, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable califlower = new Vegetable("white", true,true, true);

        t.checkExpect(data.contains(spinach), true);
        t.checkExpect(data.contains(califlower), true);
        t.checkExpect(data.contains(carrot), true);
        t.checkExpect(data.contains(beans), false);
    }
*/
    // does every row/datum have the same value for the given attribute/column
    public void testAllSameValue(Tester t){
        IAttributeDataset data = this.setupAllSame();

        t.checkExpect(data.allSameValue("highFiber"), true);
        t.checkExpect(data.allSameValue("color"), false);
        t.checkExpect(data.allSameValue("likeToEat"), false);


    }

    // number of data/rows in the dataset
    public void testSize(Tester t){
        IAttributeDataset data1 = this.setup();
        IAttributeDataset data2 = this.setupDiffLength();
        IAttributeDataset data3 = this.setupNoData();

        t.checkExpect(data1.size(), 6);
        t.checkExpect(data2.size(), 3);
        t.checkExpect(data3.size(), 0);

    }

    // partition rows into subsets such that each subset has same value of
    // onAttribute
    public void testPartition(Tester t){
        IAttributeDataset data1 = this.setup();

        LinkedList<IAttributeDataset> colorTest = data1.partition("color");

        Vegetable spinach = new Vegetable("green", true, true, false);
        Vegetable kale = new Vegetable("green", true, true,true);
        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable lettuce = new Vegetable("green", true, false,  true);
        Vegetable califlower = new Vegetable("white", true,true, true);

        LinkedList<IAttributeDatum> green = new LinkedList<IAttributeDatum>();
        LinkedList<IAttributeDatum> orange = new LinkedList<>();
        LinkedList<IAttributeDatum> white = new LinkedList<>();
        green.add(spinach);
        green.add(kale);
        green.add(peas);
        orange.add(carrot);
        green.add(lettuce);
        white.add(califlower);

        LinkedList<String> makingAVeggie = new LinkedList<String>();
        makingAVeggie.add("color");
        makingAVeggie.add("highFiber");
        makingAVeggie.add("lowCarb");
        makingAVeggie.add("likeToEat");

        IAttributeDataset greenData = new ListObjsData(makingAVeggie, green);
        IAttributeDataset orangeData = new ListObjsData(makingAVeggie, orange);
        IAttributeDataset whiteData = new ListObjsData(makingAVeggie, white);

        t.checkExpect(colorTest.size(), 3);
        t.checkExpect(colorTest.get(0), greenData);
        t.checkExpect(colorTest.get(1), orangeData);
        t.checkExpect(colorTest.get(2), whiteData);

        LinkedList<IAttributeDataset> likingTest = data1.partition("likeToEat");

        LinkedList<IAttributeDatum> likeIt = new LinkedList<>();
        LinkedList<IAttributeDatum> doesNot = new LinkedList<>();

        likeIt.add(kale);
        likeIt.add(peas);
        likeIt.add(lettuce);
        likeIt.add(califlower);
        doesNot.add(spinach);
        doesNot.add(carrot);

        IAttributeDataset liking = new ListObjsData(makingAVeggie, likeIt);
        IAttributeDataset disliking = new ListObjsData(makingAVeggie, doesNot);

        t.checkExpect(likingTest.size(), 2);
        t.checkExpect(likingTest.get(0), disliking);
        t.checkExpect(likingTest.get(1), liking);


    }

    // get the value for ofAttribute, which is assumed to be common across all
    // rows
    public void testGetSharedValue(Tester t){
        IAttributeDataset sameColor = this.setupGreenData();

        t.checkExpect(sameColor.getSharedValue("color"), "green");
        t.checkExpect(sameColor.getSharedValue("likeToEat"), false);



    }

    // get the most common value for ofAttribute in the dataset
    public void testMostCommonValue(Tester t){
        IAttributeDataset data = this.setup();

        t.checkExpect(data.mostCommonValue("lowCarb"), true);
        t.checkExpect(data.mostCommonValue("color"), "green");

    }

    // Node and Leaf (INode) methods

    // traverse tree based on attribute values to retrieve decision
    public void testLookupDecision(Tester t){
        INode tree = this.treeBuild(this.setup());
        INode treeSameFiber = this.treeBuild(this.setupAllSame());

        Vegetable stringBeans = new Vegetable("green", true, false, null);
        Vegetable squash = new Vegetable("yellow", true, true,null);
        Vegetable cucumber = new Vegetable("green", false, true, null);

        t.checkExpect(tree.lookupDecision(stringBeans), false);
        t.checkExpect(tree.lookupDecision(squash), true);
        t.checkExpect(tree.lookupDecision(cucumber), true);
        t.checkExpect(treeSameFiber.lookupDecision(cucumber), true);
    }

    // Datum Method

    // look up the value associated with the named attribute
    public void getValueOf(Tester t){
        Vegetable stringBeans = new Vegetable("green", true, false, false);
        Vegetable squash = new Vegetable("yellow", true, true,true);
        Vegetable cucumber = new Vegetable("green", false, true, true);

        t.checkExpect(cucumber.getValueOf("lowCarb"), true);
        t.checkExpect(stringBeans.getValueOf("color"), "green");
        t.checkExpect(squash.getValueOf("likeToEat"), true);

    }

    // Edges methods
    public void testIsConclusive(Tester t){
        Edge edge = this.makeColorEdge();
        Edge edgy = this.makeFiberEdgeIncon();
        Edge edgi = this.makeCarbEdgeCon();

        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable tomato = new Vegetable("red", true, false, false);

        t.checkExpect(edge.isConclusive(carrot), true);
        t.checkExpect(edge.isConclusive(peas), false);
        t.checkExpect(edgy.isConclusive(carrot), false);
        t.checkExpect(edgy.isConclusive(tomato), false);

        t.checkExpect(edgi.isConclusive(tomato), true);
        t.checkExpect(edgi.isConclusive(carrot), true);

    }

    public void testGetEdges(Tester t){
        IAttributeDataset data = this.setup();
        Edge edge = this.makeColorEdge();

        t.checkExpect(edge.getEdges(), data.partition("color"));
    }

    public void testInside(Tester t){
        Edge edge = this.makeColorEdge();
        Edge edgy = this.makeFiberEdgeIncon();
        Edge edgi = this.makeCarbEdgeCon();
        Edge edg1 = this.makeFiberEdgeAllSame();

        t.checkExpect(edge.inside("green"), true);
        t.checkExpect(edge.inside("orange"), true);
        t.checkExpect(edge.inside("white"), true);
        t.checkExpect(edge.inside("blue"), false);
        t.checkExpect(edgy.inside(true), true);
        t.checkExpect(edgy.inside(false), true);
        t.checkExpect(edgi.inside(true), true);
        t.checkExpect(edg1.inside(false), false);
    }

    public void testIndexLocal(Tester t){
        Edge edge = this.makeColorEdge();
        Edge edgy = this.makeFiberEdgeIncon();

        t.checkExpect(edge.indexLocal("green"), 0);
        t.checkExpect(edge.indexLocal("orange"), 1);
        t.checkExpect(edge.indexLocal("white"), 2);
        t.checkException(new RuntimeException("value is not here."), edge, "indexLocal", "blue");

        t.checkExpect(edgy.indexLocal(true), 0);
        t.checkExpect(edgy.indexLocal(false), 1);


    }



    public void testGetWantedAttribute(Tester t){
        Edge edge = this.makeColorEdge();
        Edge edgi = this.makeCarbEdgeCon();

        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable tomato = new Vegetable("red", true, false, false);

        t.checkExpect(edge.getWantedAttribute(carrot), false);
        t.checkExpect(edgi.getWantedAttribute(tomato), false);
        t.checkExpect(edgi.getWantedAttribute(peas), true);
    }

    public void testMostCommonWantedAttribute(Tester t){
        Edge edge = this.makeColorEdge();
        Edge edgy = this.makeFiberEdgeIncon();
        Edge edgi = this.makeCarbEdgeCon();

        Vegetable peas = new Vegetable("green", false, true, true);
        Vegetable carrot = new Vegetable("orange", false, false, false);
        Vegetable tomato = new Vegetable("red", true, false, false);

        t.checkExpect(edge.mostCommonWantedAttribute(peas), true);
        t.checkExpect(edgy.mostCommonWantedAttribute(tomato), true);
        t.checkExpect(edgy.mostCommonWantedAttribute(carrot), true);
        t.checkExpect(edgi.mostCommonWantedAttribute(peas), true);
        t.checkExpect(edgi.mostCommonWantedAttribute(tomato), false);

    }


    /**
     * main method
     */
    public static void main(String[] args) {
        Tester.run(new Testing());
    }


}
