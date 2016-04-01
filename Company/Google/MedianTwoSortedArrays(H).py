class Solution(object):
	"""
		Divide-and-conquer/Binary search solution
		Time complexity: O(log(m+n)), m,n is length of each array
		Extra space: O(1)
	"""
	def findMedianSortedArrays(self, nums1, nums2):
		"""
		:type nums1: List[int]
		:type nums2: List[int]
		:rtype: float
		"""
		m,n=len(nums1),len(nums2)
		return float(self.binary_search(nums1,nums2,0,m-1,0,n-1,(m+n)/2)) if (m+n)%2 else (float(self.binary_search(nums1,nums2,0,m-1,0,n-1,(m+n)/2))+float(self.binary_search(nums1,nums2,0,m-1,0,n-1,(m+n)/2-1)))/2.0

	def binary_search(self,nums1,nums2,s1,e1,s2,e2,median):
		curr_length_1,curr_length_2=e1-s1+1,e2-s2+1
		if not curr_length_1: return nums2[s2+median]
		if not curr_length_2: return nums1[s1+median]
		if not median: return min(nums1[s1],nums2[s2])
		mid1=median*curr_length_1/(curr_length_1+curr_length_2)	
		mid2=median-mid1-1	# Calculate absolute value of mid1,mid2
		mid1,mid2=mid1+s1,mid2+s2	# Calculate relative value of mid1,mid2
		return self.binary_search(nums1,nums2,mid1+1,e1,s2,mid2,median-(mid1-s1+1)) if nums1[mid1]<=nums2[mid2] else self.binary_search(nums1,nums2,s1,mid1,mid2+1,e2,median-(mid2-s2+1))

	"""
		Virtual merge/Binary search solution
		Time complexity: O(log(min(m,n))), m,n is length of each list
		Extra space: O(1)
	"""
	def findMedian(self, nums1, nums2):
		"""
		:type nums1: List[int]
		:type nums2: List[int]
		:rtype: float
		"""
		a,b=sorted((nums1,nums2), key=len)
		m,n=len(a),len(b)
		l,r=0,m
		after=(m+n-1)/2
		while(l<r):
			mid=(l+r)/2
			if after-mid<1 or a[mid]>=b[after-mid-1]:
				r=mid
			else:
				l=mid+1
		mid=l
		nextfew = sorted(a[mid:mid+2] + b[after-mid:after-mid+2])
		return (nextfew[0] + nextfew[1 - (m+n)%2]) / 2.0

nums1=[-4,-1,3,7,10,17]
nums2=[-7,-2,0,4,6,12,19]
sol=Solution()
print "Median of",nums1,"and",nums2,"is:",sol.findMedianSortedArrays(nums1,nums2),"VS",sol.findMedian(nums1,nums2)