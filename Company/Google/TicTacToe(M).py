from operator import add, sub
class TicTacToe(object):
	"""
		Time complexity: O(1)
		Extra space: O(n)
	"""
	def __init__(self, n):
		self.n=n
		self.count=n*n
		self.diagonal=0
		self.anti_diagonal=0
		self.ops={1:add, 2:sub}
		self.rows=[0 for i in xrange(n)]
		self.cols=[0 for i in xrange(n)]

	def move(self, row, col, player):
		# Player {player} makes a move at ({row}, {col}).
		# @param row The row of the board.
		# @param col The column of the board.
		# @param player The player, can be either 1 or 2.
		# @return The current winning condition, can be either:
		# 0: No one wins.
		# 1: Player 1 wins.
		# 2: Player 2 wins.
		if row<0 or row>=self.n or col<0 or col>=self.n: return 0
		self.rows[row]=self.ops[player](self.rows[row],1)
		self.cols[col]=self.ops[player](self.cols[col],1)
		if row==col: self.diagonal=self.ops[player](self.diagonal,1)
		if row+col==self.n-1: self.anti_diagonal=self.ops[player](self.anti_diagonal,1)
		if not self.count: return 0
		self.count-=1
		#print self.rows,'\n',self.cols, '\n',self.diagonal,self.anti_diagonal
		if (abs(self.diagonal)==self.n or 
			abs(self.anti_diagonal)==self.n or 
			self.n in self.rows or -self.n in self.rows or 
			self.n in self.cols or -self.n in self.cols): return player
		return 0
if __name__ == "__main__":
	obj=TicTacToe(3)
	print "No one wins" if not obj.move(2,1,1) else "Player %d wins"%1
	print "No one wins" if not obj.move(1,2,2) else "Player %d wins"%2
	print "No one wins" if not obj.move(0,2,1) else "Player %d wins"%1
	print "No one wins" if not obj.move(2,2,2) else "Player %d wins"%2
	print "No one wins" if not obj.move(0,1,1) else "Player %d wins"%1
	print "No one wins" if not obj.move(0,0,2) else "Player %d wins"%2
	print "No one wins" if not obj.move(2,0,1) else "Player %d wins"%1
	print "No one wins" if not obj.move(1,0,2) else "Player %d wins"%2
	print "No one wins" if not obj.move(1,1,1) else "Player %d wins"%1
