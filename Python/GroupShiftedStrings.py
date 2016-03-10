from collections import defaultdict

class GroupShiftedString(object):
	def groupStrings(self, strings):
		"""
        :type strings: List[str]
        :rtype: List[List[str]]
        """
		result=[]
		strs=strings[:]
		d={}
		d=defaultdict(list)
		for i in range(0,len(strings)):
			strs[i]=self.toHashString(strings[i])
			if strs[i] in d.keys():
				d[strs[i]].append(i)
			else:
				d[strs[i]]=[i]
		for key in d.keys():
			group=[]
			for i in d[key]:
				group.append(strings[i])
			result.append(sorted(group))
		return result


	def toHashString(self, ss):
		res=""
		for i in range(0,len(ss)):
			c=chr(ord(ss[i])-ord(ss[0])+ord('a')) if ord(ss[i])>=ord(ss[0]) else chr(26+ord(ss[i])-ord(ss[0])+ord('a'))
			res+=c
		return res
	

#strings=["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
strings=["fpbnsbrkbcyzdmmmoisaa",
"cpjtwqcdwbldwwrryuclcngw",
"a",
"fnuqwejouqzrif",
"js",
"qcpr",
"zghmdiaqmfelr",
"iedda",
"l",
"dgwlvcyubde",
"lpt",
"qzq",
"zkddvitlk",
"xbogegswmad",
"mkndeyrh",
"llofdjckor",
"lebzshcb",
"firomjjlidqpsdeqyn",
"dclpiqbypjpfafukqmjnjg",
"lbpabjpcmkyivbtgdwhzlxa",
"wmalmuanxvjtgmerohskwil",
"yxgkdlwtkekavapflheieb",
"oraxvssurmzybmnzhw",
"ohecvkfe",
"kknecibjnq",
"wuxnoibr",
"gkxpnpbfvjm",
"lwpphufxw",
"sbs",
"txb",
"ilbqahdzgij",
"i",
"zvuur",
"yfglchzpledkq",
"eqdf",
"nw",
"aiplrzejplumda",
"d",
"huoybvhibgqibbwwdzhqhslb",
"rbnzendwnoklpyyyauemm"]
gs=GroupShiftedString()
print(gs.groupStrings(strings))

