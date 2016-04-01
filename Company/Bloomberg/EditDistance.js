/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */

var minDistance = function(word1, word2) {
    var m=word1.length;
    var n=word2.length;
    if(m==0) return word2.length;
    if(n==0) return word1.length;

    var dp=new Array(m+1);
    for(var i=0; i<=m; i++)
    	dp[i]=new Array(n+1);

    for(var i=0; i<=m; i++)
    	dp[i][0]=i;
    for(var j=0; j<=n; j++)
    	dp[0][j]=j;

    for(var i=0; i<m; i++){
    	for(var j=0; j<n; j++){
    		if(word1[i]==word2[j]) dp[i+1][j+1]=dp[i][j];
    		else{
    			var replace=dp[i][j]+1;
    			var insert=dp[i][j+1]+1;
    			var remove=dp[i+1][j]+1;

    			dp[i+1][j+1]=Math.min(replace,Math.min(insert,remove));
    		}
    	}
    }
  //  console.log(dp[0][2])
    return dp[m][n];
};

var word1='Michael'
var word2='Michelle'
console.log("word1: "+word1+"-> word2: "+word2)
console.log(minDistance(word1,word2))