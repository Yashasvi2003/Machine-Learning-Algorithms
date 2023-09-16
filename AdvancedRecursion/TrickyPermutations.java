import java.util.*;
public class TrickyPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        List<String> permutations = getDistinctPermutations(in);
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    public static List<String> getDistinctPermutations(String in) {
        List<String> permutations = new ArrayList<>();
        char[] ch = in.toCharArray();
        Arrays.sort(ch);
        boolean[] use = new boolean[in.length()];
        StringBuilder curr = new StringBuilder();

        backtrack(ch, use, curr, permutations);

        return permutations;
    }

    private static void backtrack(char[] ch, boolean[] use, StringBuilder curr, List<String> permutations) {
        if (curr.length() == ch.length) {
            permutations.add(curr.toString());
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (use[i] || (i > 0 && ch[i] == ch[i - 1] && !use[i - 1])) {
                continue;
            }

            use[i] = true;
            curr.append(ch[i]);

            backtrack(ch, use, curr, permutations);

            use[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}