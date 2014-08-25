/**
 * Created by JMichael on 8/10/2014.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Printer {

    public static <T extends Comparable<?>> void printNode(AVLNode root) {
        int maxLevel = Printer.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<AVLNode> AVLNodes, int level, int maxLevel) {
        if (AVLNodes.isEmpty() || Printer.isAllElementsNull(AVLNodes)){
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2,(Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2,(floor)) - 1;
        int betweenSpaces = (int) Math.pow(2,(floor + 1)) - 1;

        Printer.printWhitespaces(firstSpaces);

        List<AVLNode> newAVLNodes = new ArrayList<AVLNode>();
        for (AVLNode AVLNode : AVLNodes) {
            if (AVLNode != null) {
                System.out.print(AVLNode.value());
                newAVLNodes.add(AVLNode.left());
                newAVLNodes.add(AVLNode.right());
            } else {
                newAVLNodes.add(null);
                newAVLNodes.add(null);
                System.out.print(" ");
            }

            Printer.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < AVLNodes.size(); j++) {
                Printer.printWhitespaces(firstSpaces - i);
                if (AVLNodes.get(j) == null) {
                    Printer.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (AVLNodes.get(j).left() != null){
                    System.out.print("/");
                }
                else{
                    Printer.printWhitespaces(1);
                }

                Printer.printWhitespaces(i + i - 1);

                if (AVLNodes.get(j).right() != null){
                    System.out.print("\\");
                }
                else{
                    Printer.printWhitespaces(1);
                }
                Printer.printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println("");
        }
        printNodeInternal(newAVLNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(AVLNode AVLNode) {
        if (AVLNode == null){
            return 0;
        }
        return Math.max(Printer.maxLevel(AVLNode.left()), Printer.maxLevel(AVLNode.right())) + 1;
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

