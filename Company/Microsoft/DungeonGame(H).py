class Solution(object):
	def calculateMinimumHP(self, dungeon):
		m,n=len(dungeon),len(dungeon[0])
		dp=[[0 for j in xrange(n)] for i in xrange(m)]
		dp[-1][-1]=max(1,1-dungeon[-1][-1])
		for i in xrange(m-2,-1,-1): dp[i][-1]=max(1,dp[i+1][-1]-dungeon[i][-1])
		for j in xrange(n-2,-1,-1): dp[-1][j]=max(1,dp[-1][j+1]-dungeon[-1][j])
		for i in xrange(m-2,-1,-1):
			for j in xrange(n-2,-1,-1):
				dp[i][j]=max(1,min(dp[i+1][j],dp[i][j+1])-dungeon[i][j])
		return dp[0][0]

dungeon=[[-2,-3,3],[-5,-10,1],[10,30,-5]]
print 'Min HP %d'%Solution().calculateMinimumHP(dungeon)