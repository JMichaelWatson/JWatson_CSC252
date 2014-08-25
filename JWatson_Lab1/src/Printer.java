/**
 * Created by JMichael on 8/10/2014.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = Printer.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> Nodes, int level, int maxLevel) {
        if (Nodes.isEmpty() || Printer.isAllElementsNull(Nodes)){
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2,(Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2,(floor)) - 1;
        int betweenSpaces = (int) Math.pow(2,(floor + 1)) - 1;

        Printer.printWhitespaces(firstSpaces);

        List<Node> newNode = new ArrayList<Node>();
        for (Node node : Nodes) {
            if (node != null) {
                System.out.print(node.getKey());
                newNode.add(node.getLeftNode());
                newNode.add(node.getRightNode());
            } else {
                newNode.add(null);
                newNode.add(null);
                System.out.print(" ");
            }

            Printer.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < Nodes.size(); j++) {
                Printer.printWhitespaces(firstSpaces - i);
                if (Nodes.get(j) == null) {
                    Printer.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (Nodes.get(j).getLeftNode() != null){
                    System.out.print("/");
                }
                else{
                    Printer.printWhitespaces(1);
                }

                Printer.printWhitespaces(i + i - 1);

                if (Nodes.get(j).getRightNode() != null){
                    System.out.print("\\");
                }
                else{
                    Printer.printWhitespaces(1);
                }
                Printer.printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println("");
        }
        printNodeInternal(newNode, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null){
            return 0;
        }
        return Math.max(Printer.maxLevel(node.getLeftNode()), Printer.maxLevel(node.getRightNode())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null){
                return false;
            }
        }
        return true;
    }
}

