class Solution(object):
	def findItinerary(self, tickets):
		"""
		:type tickets: List[List[str]]
		:rtype: List[str]
		"""
		adjacent_matrix={}
		for fromTo in tickets:
			if fromTo[0] in adjacent_matrix:
				adjacent_matrix[fromTo[0]].append(fromTo[1])
				adjacent_matrix[fromTo[0]].sort()
			else:
				adjacent_matrix[fromTo[0]]=[fromTo[1]]
		#print adjacent_matrix
		itinerary=[]
		self.getItinerary(adjacent_matrix,itinerary,"JFK")
		itinerary.reverse()
		return itinerary

	def getItinerary(self, adjacent_matrix, itinerary, startFrom):
		"""
		***Topological sort***
		:type adjacent_matrix: Dict{key:[value1,valu2,valu3...]}
			  itinerary: List[int]
			  startFrom: str
		"rType: null (void)
		"""
		while adjacent_matrix.has_key(startFrom) and len(adjacent_matrix[startFrom])>0:
			destination=adjacent_matrix[startFrom].pop(0)
			self.getItinerary(adjacent_matrix,itinerary,destination)
		itinerary.append(startFrom)

tickets=[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
print "Tickets:", tickets
s=Solution()
print "Itinerary: ", s.findItinerary(tickets)