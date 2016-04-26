# from collections import defaultdict

class defaultdict(dict):
	def __init__(self):
		self.x=4
	
	def __str__(self):
		return str(self.x)
		
	def __missing__(self, key):
		return 'sb'
	
	# def __eq__(self,y):
	# 	return self.x==y
		
	# def __nq__(self, y):
	# 	return self.x!=y
	
	def __cmp__(self,y):
		return cmp(self.x,y)
		
d=defaultdict()
print d
print d['a']
print d=='a'
		