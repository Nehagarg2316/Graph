class Pair{
    String s;
    int m;
    Pair(String s,int m)
    {
        this.s=s;
        this.m=m;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<deadends.length;i++)
        {
            set.add(deadends[i]);
        }
        String start="0000";
        if(set.contains(start))
        {
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair("0000",0));
        Set<String> vis=new HashSet<>();
        vis.add(start);
        while(!q.isEmpty())
        {
            Pair dummy=q.remove();
            int moves=dummy.m;
            if(dummy.s.equals(target))
            {
                return moves;
            }
            for(int i=0;i<4;i++)
            {
                for(int delta:new int[]{-1,1})
                {
                    int newDigit=(dummy.s.charAt(i)-'0'+delta+10)%10;
                    String newCombination=dummy.s.substring(0,i)+newDigit+dummy.s.substring(i+1);
                    if(!vis.contains(newCombination) && !set.contains(newCombination))
                    {
                        vis.add(newCombination);
                        q.offer(new Pair(newCombination,moves+1));
                    }
                }
            }
        }
        return -1;
    }
}