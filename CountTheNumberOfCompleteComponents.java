class Solution {
    int edge=0;
    int ncount=0;
    public boolean isComplete(int e,int nc)
    {
        int ans=nc*(nc-1)/2;
        if(ans==e)
        {
            return true;
        }
        return false;
    }
    public void dfs(int src,ArrayList<ArrayList<Integer>> list,boolean[] vis)
        {
            vis[src]=true;
            edge+=list.get(src).size();
            for(int it:list.get(src))
            {
                if(!vis[it])
                {
                    dfs(it,list,vis);
                }
            }

        }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        int count=0;
        int prev=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++)
        {
            int c=0;
            if(!vis[i])
            {
                dfs(i,list,vis);
                for(int j=0;j<n;j++)
                {
                    if(vis[j]==true)
                    {
                        c++;
                    }
                }
                ncount=c-prev;
                prev=c;
                if(isComplete(edge/2,ncount))
                {
                    count++;
                }
                edge=0;
            }
        }
        return count;
    }
}