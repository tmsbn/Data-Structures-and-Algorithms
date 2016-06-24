package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.Tree;

/**
 * Created by tmsbn on 6/16/16.
 */
public class TreeTest extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        Tree tree = new Tree(Tree.TREES.SAMPLE1);
        tree.print(Tree.TRAVERSAL.LEVELORDER);
    }
}
