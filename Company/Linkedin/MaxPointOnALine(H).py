from collections import defaultdict
from operator import itemgetter
class Point(object):
    def __init__(self,a=0,b=0):
        self.x=a
        self.y=b

class Solution(object):
    """
        Hash table/Greedy solution
        Time complexity: O(n^2)
        Extra space: O(n)
    """
    def maxPoints(self,points):
        max_num=0
        for i,p in enumerate(points):      
            slopes,duplicate=defaultdict(int),1
            for j,q in enumerate(points):
                if i==j: continue
                if p.x==q.x and p.y==q.y:  
                    duplicate+=1
                    continue
                curr_slope=float('inf') if p.x==q.x else (float(q.y)-float(p.y))/(float(q.x)-float(p.x))
                slopes[curr_slope]=slopes[curr_slope]+1 if curr_slope in slopes else 1
            max_num=max(max_num, (max(slopes.values()) if slopes else 0)+duplicate)
        return max_num
                    
sol=Solution()
#coordinates=[(1,1),(2,2),(1,2),(2,1),(2,4),(3,3),(3,2),(5,4),(5,5),(7,10)]
coordinates=[(1,1),(1,1),(2,2),(2,2)]
points=[]
for x,y in coordinates:
    points.append(Point(x,y))
print "max points:%s"%sol.maxPoints(points)