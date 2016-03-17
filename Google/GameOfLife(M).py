class Solution(object):
	def gameOfLife(self, board):
		"""
		:type board: List[List[int]]
		:rtype: void Do not return anything, modify board in-place instead.
		"""
		if len(board)==0 or len(board[0])==0: return
		m,n=len(board),len(board[0])
		for i in range(0,m):
			for j in range(0,n):
				num_live_neighbor_cells=self.countLives(board,i,j)
				# live -> live
				if board[i][j]==1 and (num_live_neighbor_cells==2 or num_live_neighbor_cells==3):
					board[i][j]=3 # curr: live(1) -> next: live(1)
				# dead -> live
				if board[i][j]==0 and num_live_neighbor_cells==3:
					board[i][j]=2 # curr: dead(0) -> next: live(1)

		for i in range(0,m):
			for j in range(0,n):
				board[i][j]>>=1

	def countLives(self,board,i,j):
		"""
		:type board: List[List[int]], i: int, j: int
		:rType: int
		"""
		lives=0
		m,n=len(board),len(board[0])
		for x in range(max(i-1,0),min(i+1,m-1)+1):
			for y in range(max(j-1,0),min(j+1,n-1)+1):
				if x==i and y==j:
					continue
				lives+=board[x][y]&1
		# lives-=board[i][j]&1
		return lives

s=Solution()
board=[
		[0,0,0,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,1,0,0],[0,0,0,0,0]
	]
print "Initial state:"
for row in board: print row
s.gameOfLife(board)
print "Next state:"
for row in board: print row
