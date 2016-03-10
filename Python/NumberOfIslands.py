class NumberOfIslands:
	def numIslands(self, grid):
		"""
        :type grid: List[List[str]]
        :rtype: int
        """
        

grid=[['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]
ni=NumberOfIslands()
print ni.numIslands(grid)