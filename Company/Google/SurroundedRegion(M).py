from collections import defaultdict
from itertools import chain
class Solution(object):
	"""
		Union find solution
		Time complexity: O(mn)
		Extra space: O(n)
	"""
	class UnionFind(object):
		def __init__(self, M, N):
			self.id=[i for i in xrange(M*N)]

		def find(self, P):
			# @return: type(P)
			while P!=self.id[P]:
				self.id[P]=self.id[self.id[P]]
				P=self.id[P]
			return P

		def connected(self, P, Q):
			# @return: bool
			return self.find(P)==self.find(Q)

		def union(self, P, Q):
			# @return: None
			P,Q=self.find(P),self.find(Q)
			if P==Q: return
			self.id[P]=Q

	def solve1(self, board):
		# @param board: List[List[str]]
		# @return: None
		m=len(board)
		if not m: return
		n=len(board[0])
		if not n: return
		uf=self.UnionFind(m,n)
		pos_O=[(i,j) for j in xrange(n) for i in xrange(m) if board[i][j]=='O']
		for x,y in pos_O:
			curr_pos=x*n+y
			if x==0 or x==m-1 or y==0 or y==n-1: uf.union(curr_pos,m*n-1)
			else:
				for I,J in (x+1,y),(x-1,y),(x,y+1),(x,y-1):
					if board[I][J]=='O':
						if I==0 or I==m-1 or J==0 or J==n-1: uf.union(curr_pos, m*n-1)
						else:
							next_pos=I*n+J
							uf.union(curr_pos,next_pos)
							
		for i,j in pos_O:
			if not uf.connected(i*n+j,m*n-1): board[i][j]='X'
		return



board1=[['X', 'X', 'X', 'X'],
		['X', 'O', 'O', 'X'],
		['X', 'X', 'O', 'X'],
		['X', 'O', 'X', 'X'],
		['X', 'O', 'X', 'X'],
		['X', 'O', 'X', 'X']]
board2=[[x for x in board1[row]] for row,item in enumerate(board1)]
print 'Initial area:'
for b in board1: print b
Solution().solve1(board1)
print "Union find:"
for b in board1: print b

