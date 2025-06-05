class Solution {
    public boolean isValid(String s) {
        Stack <Character> st=new Stack<Character>();
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
        switch(c[i])
        {
            case '(':
                st.push(c[i]);
                break;
            case '{':
                st.push(c[i]);
                break;
            case '[':
                st.push(c[i]);
                break;
            case ']':
                if(st.isEmpty() ||  st.pop()!='[')
                {
                    return false;
                }
                break;
            case '}':
                if(st.isEmpty() || st.pop()!='{')
                {
                    return false;
                }
                break;
            case ')':
                if(st.isEmpty() || st.pop()!='(')
                {
                    return false;
                }
                break;
        }
        }
        return st.isEmpty();
    }
}