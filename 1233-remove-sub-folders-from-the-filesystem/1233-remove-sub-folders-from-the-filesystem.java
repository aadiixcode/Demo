class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Set<String> st = new HashSet<>();

        for (String folder : folders) {
            st.add(folder);
        }

        List<String> ans = new ArrayList<>();
        for (String folder : folders) {
            int i = folder.length() - 1;
            boolean isSubFolder = false;
            while (i >= 0) {
                while (i >= 0 && folder.charAt(i) != '/') {
                    i -= 1;
                }
                String parent = folder.substring(0, i);
                if (st.contains(parent)) {
                    isSubFolder = true;
                    break;
                }
                i -= 1;
            }

            if (!isSubFolder) {
                ans.add(folder);
            }
        }
        return ans;
    }
}