/*@param {string} s
@param {set<string>} wordDict
@return boolean
*/
var wordBreak=function(s,wordDict){
	if(wordDict.size==0) return false
	var dp=new Array()
	for(var i=0; i<s.length; i++) dp[i]=false
	for (var i = 0; i < s.length; i++) {
		for (var j=i; j >= 0; j--) {
			if(wordDict.has(s.substring(j,i+1)) && (j==0 || dp[j-1])){
				dp[i]=true;
				break;
			}
		}
	}
	return dp[s.length-1];
};

var s='aaaaaaa'
var wordDict=new Set(["aaaa","aa"])
//wordDict.add("leet")
//wordDict.add("code")
console.log(s)
console.log(Array.from(wordDict))
console.log(wordBreak(s,wordDict))