class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        Set<String> st = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String folder : folders) {
            if (st.isEmpty()) {
                st.add(folder);
                ans.add(folder);
            } else {
                int i = folder.length() - 1;
                boolean isSubfolder = false;
                while (i >= 0) {
                    while(i>=0 && folder.charAt(i)!='/'){
                        i-=1;
                    }
                    String parent = folder.substring(0,i);
                    if(st.contains(parent)){
                        isSubfolder = true;
                        break;
                    }
                    i -= 1;
                }
                if(!isSubfolder){
                    st.add(folder);
                    ans.add(folder);
                }
            }
        }
        return ans;
    }
}