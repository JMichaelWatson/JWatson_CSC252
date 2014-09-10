
public class EditDistanceCalculator {
    public int editDistance(String a, String b) {
        return editDistanceHelper2(a, b, new int[a.length() + 1][b.length() + 1]);
    }

    private int editDistanceHelper(String a, String b, int[][] eds) {
        for (int i = 1; i <= a.length(); i++) {
            eds[i][0] = b.length();
        }
        for (int j = 1; j <= b.length(); j++) {
            eds[0][j] = a.length();
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int delete = eds[i - 1][j] + 1;
                int insert = eds[i][j - 1] + 1;
                int remove = eds[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);
                eds[i][j] = Math.min(delete, Math.min(insert, remove));
            }
        }

        return eds[a.length()][b.length()];
    }

    /**
     * #2.  Add a recursive version here, which uses a memory function.  Change your internal implementation
     * to use this version. (1 point)
     */

    private int editDistanceHelper2(String a, String b, int[][] eds) {
        stepOne(a, b, eds, 1);
        stepThree(a, b, eds, 1,1);
        return eds[a.length()][b.length()];
    }

    private void stepOne(String a, String b, int[][] eds, int count) {
        if (a.length() + 1 == count || b.length() + 1 == count) {
            return;
        } else {
            eds[count][0] = b.length();
            eds[0][count] = a.length();
            stepOne(a, b, eds, ++count);
        }
    }


    private void stepThree(String a, String b, int[][] eds, int count, int j) {
        if (count == a.length() + 1) {
            return;
        } else {
            if (j == b.length() + 1) {
                stepThree(a, b, eds, ++count, 1);
            } else {
                int delete = eds[count - 1][j] + 1;
                int insert = eds[count][j - 1] + 1;
                int remove = eds[count - 1][j - 1] + (a.charAt(count - 1) == b.charAt(j - 1) ? 0 : 1);
                eds[count][j] = Math.min(delete, Math.min(insert, remove));
                stepThree(a, b, eds, count, ++j);
            }
        }
    }
}

