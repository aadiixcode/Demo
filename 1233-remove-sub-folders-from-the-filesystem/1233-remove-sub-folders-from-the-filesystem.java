class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);

        List<String> ans = new ArrayList<>();
        ans.add(folders[0]);
        for (int i = 1; i < folders.length; i++) {
            String curr = folders[i];
            String parent = ans.getLast() + "/";
            if (curr.indexOf(parent) != 0) {
                ans.add(curr);
            }
        }
        return ans;
    }
}