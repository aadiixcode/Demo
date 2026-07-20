class Solution {
    static class Disjoint{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        Disjoint(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }
        int findUltimateParent(int node){
            if (node== parent.get(node)){
                return node;
            }
            int up = findUltimateParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }

        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateV==ultimateU) {
                return;
            }

            int sizeU = size.get(ultimateU);
            int sizeV = size.get(ultimateV);

            if(sizeV < sizeU){
                parent.set(ultimateV,ultimateU);
                size.set(ultimateU,sizeU+sizeV);
            }
            else{
                parent.set(ultimateU,ultimateV);
                size.set(ultimateV,sizeV+sizeU);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint obj = new Disjoint(n);

        HashMap<String,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mp.containsKey(mail)) mp.put(mail,i);
                else obj.unionBySize(i,mp.get(mail));
            }
        }

        List<List<String>> merged = new ArrayList<>();
        for(int i=0;i<n;i++){
          merged.add(new ArrayList<>());  
        } 
        for(Map.Entry<String,Integer> e: mp.entrySet()){
            String mail = e.getKey();
            int ind = obj.findUltimateParent(e.getValue());
            merged.get(ind).add(mail);
        }


        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged.get(i).isEmpty()) continue;

            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged.get(i));
            ans.add(temp);
        }
        return ans;
    }
}