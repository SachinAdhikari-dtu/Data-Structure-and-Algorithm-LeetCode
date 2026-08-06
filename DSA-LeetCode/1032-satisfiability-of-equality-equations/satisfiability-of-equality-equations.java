class Solution {
    public boolean equationsPossible(String[] arr) {
        ArrayList<Character> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();
        
        // Initialize parent and rank for all 26 letters
        for (int i = 0; i < 26; i++) {
            char curr = (char) ('a' + i);
            parent.add(curr);
            rank.add(0);
        }
        
        // FIRST PASS: Process only equality equations
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.charAt(1) == '=') {
                char one = str.charAt(0);
                char two = str.charAt(3);
                char pone = find(one, parent);
                char ptwo = find(two, parent);
                union(pone, ptwo, rank, parent);
            }
        }
        
        // SECOND PASS: Check all inequality equations
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.charAt(1) == '!') {
                char one = str.charAt(0);
                char two = str.charAt(3);
                char pone = find(one, parent);
                char ptwo = find(two, parent);
                // If they're in the same set, contradiction!
                if (pone == ptwo) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static char find(char curr, ArrayList<Character> parent) {
        int index = curr - 'a';
        if (curr == parent.get(index)) {
            return curr;
        }
        // Path compression with correct return
        char root = find(parent.get(index), parent);
        parent.set(index, root);
        return root;
    }
    
    public static void union(char pone, char ptwo, ArrayList<Integer> rank, ArrayList<Character> parent) {
        int index1 = pone - 'a';
        int index2 = ptwo - 'a';
        
        if (rank.get(index1) > rank.get(index2)) {
            parent.set(index2, pone);
        } else if (rank.get(index1) < rank.get(index2)) {
            parent.set(index1, ptwo);
        } else {
            // Same rank, make one root and increase its rank
            parent.set(index1, ptwo);
            rank.set(index2, rank.get(index2) + 1);
        }
    }
}