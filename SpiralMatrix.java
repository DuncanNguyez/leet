import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SpiralMatrix {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ArrayList<Integer> arrNode = new ArrayList<>();
        int[][] result = new int[m][n];
        ListNode current = head;
        while (current != null) {
            arrNode.add(current.val);
            current = current.next;
        }
        int startLtR = 0, startTtB = 1, startRtL = n - 1, startBtT = m - 2;
        int endLtR = n - 1, endTtB = m - 1, endRtL = 0, endBtT = 1;
        int index = 0;
        int nodeSize = arrNode.size();
        Set<String> set = new HashSet<>();
        boolean checkAll = true;
        while (checkAll && (startLtR <= endLtR || startTtB <= endTtB || startRtL >= endRtL || startBtT >= endBtT)) {
            // let to right
            boolean checkLtR = true;
            System.out.println("let to right");
            for (int i = startLtR; i <= endLtR; i++) {
                if (-1 < startTtB - 1 && startTtB - 1 < m) {
                    if (set.contains(startTtB - 1 + "," + i)) {
                        continue;
                    }
                    set.add(startTtB - 1 + "," + i);
                    if (index < nodeSize) {
                        result[startTtB - 1][i] = arrNode.get(index);
                        System.out.println("[" + (startTtB - 1) + "][" + i + "]= " + arrNode.get(index));
                        index++;
                    } else {
                        result[startTtB - 1][i] = -1;
                        System.out.println("[" + startTtB + "][" + i + "]= " + "-1");
                    }
                } else {
                    checkLtR = false;
                }
            }
            // top to bottom
            boolean checkTtB = true;
            System.out.println("top to bottom");
            for (int i = startTtB; i <= endTtB; i++) {
                if (-1 < endLtR && endLtR < n) {
                    if (set.contains(i + "," + endLtR)) {
                        continue;
                    }
                    set.add(i + "," + endLtR);
                    if (index < nodeSize) {
                        result[i][endLtR] = arrNode.get(index);
                        System.out.println("[" + i + "][" + endLtR + "]= " + arrNode.get(index));
                        index++;
                    } else {
                        result[i][endLtR] = -1;
                        System.out.println("[" + i + "][" + endLtR + "]= " + "-1");
                    }
                } else
                    checkTtB = false;

            }
            // right to left
            boolean checkRtL = true;
            System.out.println("right to left");
            for (int i = startRtL; i >= endRtL; i--) {

                if (-1 < endTtB && endTtB < m) {
                    if (set.contains(endTtB + "," + i)) {
                        continue;
                    }
                    set.add(endTtB + "," + i);
                    if (index < nodeSize) {
                        result[endTtB][i] = arrNode.get(index);
                        System.out.println("[" + endTtB + "][" + i + "]= " + arrNode.get(index));
                        index++;
                    } else {
                        result[endTtB][i] = -1;
                        System.out.println("[" + endTtB + "][" + i + "]= " + "-1");
                    }
                } else
                    checkRtL = false;

            }
            // bottom to top
            boolean checkBtT = true;
            System.out.println("bottom to top");
            for (int i = startBtT; i >= endBtT; i--) {
                if (-1 < startLtR && startLtR < n) {
                    if (set.contains(i + "," + startLtR)) {
                        continue;
                    }
                    set.add(i + "," + startLtR);
                    if (index < nodeSize) {
                        result[i][startLtR] = arrNode.get(index);
                        System.out.println("[" + i + "][" + startLtR + "]= " + arrNode.get(index));
                        index++;
                    } else {
                        result[i][startLtR] = -1;
                        System.out.println("[" + i + "][" + startLtR + "]= " + "-1");
                    }
                } else
                    checkBtT = false;

            }
            checkAll = checkLtR && checkTtB && checkRtL && checkBtT;
            startLtR++;
            endLtR--;
            startTtB++;
            endTtB--;
            startRtL--;
            endRtL++;
            startBtT--;
            endBtT++;

        }
        return result;
    }
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
