class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        adjacent_list=[]
        res=[]
        if len(edges)==1:
            return [0]
        for i in range(n):
            adjacent_list.append([])
        
        for e in edges:
            u=e[0]
            v=e[1]
            adjacent_list[u].append(v)
            adjacent_list[u].sort()
            adjacent_list[v].append(u)
            adjacent_list[v].sort()
        for i in range(len(adjacent_list)):
            if len(adjacent_list[i])==1:
                res.append(i)
        while n>2:
            n-=len(res)
            tmp=[]

            for u in res:
                it=iter(adjacent_list[u])
                v=next(it)
                adjacent_list[v].remove(u)
                if len(adjacent_list[v])==1:
                    tmp.append(v)
            res=tmp[:]

        return res
n=6
edges=[[0,3],[2,3],[1,3],[4,3],[5,4]]
print n,edges
mh=Solution()
print mh.findMinHeightTrees(n,edges)