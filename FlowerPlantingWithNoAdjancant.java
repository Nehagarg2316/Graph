class Solution {
    public void bfs(int[] ans, List<List<Integer>> list, int src) {
     ans[src - 1] = 1;
     Queue<Integer> q = new LinkedList<>();
     q.add(src);
 
     while (!q.isEmpty()) {
         int dummy = q.poll();
         int color = ans[dummy - 1];
 
         for (int it : list.get(dummy)) {
             if (ans[it - 1] == 0 || ans[it - 1] == color) {
                 ans[it - 1] = color == 4 ? 1 : color + 1;
                 q.add(it);
             }
         }
     }
 }
     public int[] gardenNoAdj(int n, int[][] paths) {
         int[] ans=new int[n];
        List<List<Integer>> list=new ArrayList<>();
         for(int i=0;i<n+1;i++)
         {
             list.add(new ArrayList<>());
         }
         for(int i=0;i<paths.length;i++)
         {
             list.get(paths[i][0]).add(paths[i][1]);
             list.get(paths[i][1]).add(paths[i][0]);
         }
         for(int i=1;i<=n;i++)
         {
             if(ans[i-1]==0)
             {
                 bfs(ans,list,i);
             }
         }
         return ans;
     }
 }