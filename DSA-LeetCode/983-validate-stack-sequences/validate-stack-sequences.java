class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int index=0;
        for(int i =0 ; i < pushed.length ;i++){
            int curr=pushed[i];
            if(!s.isEmpty() && s.peek()==popped[index]){
        while(!s.isEmpty() && index < popped.length){
            if(s.peek()!=popped[index])break;
            s.pop();
            index++;
            
        } 
            }
            s.push(curr);
        }

        while(index < popped.length){
            if(s.peek()!=popped[index])return false;
            s.pop();
            index++;
            
        }    


        return index==popped.length;
    }
}