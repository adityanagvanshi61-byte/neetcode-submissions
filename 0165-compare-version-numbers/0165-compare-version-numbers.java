class Solution {
    public int compareVersion(String version1, String version2) {
    int i = 0, j = 0;
    int n1 = version1.length();
    int n2 = version2.length();
    
    while (i < n1 || j < n2) {
        int val1 = 0, val2 = 0;
        
        while (i < n1 && version1.charAt(i) != '.') { 
            val1 = val1 * 10 + (version1.charAt(i) - '0'); 
            i++;
        }
        
        while (j < n2 && version2.charAt(j) != '.') { 
            val2 = val2 * 10 + (version2.charAt(j) - '0'); 
            j++;
        }
        
        if (val1 < val2) return -1;
        if (val1 > val2) return 1;
        
        i++; 
        j++; 
    }
    return 0;
    }
}