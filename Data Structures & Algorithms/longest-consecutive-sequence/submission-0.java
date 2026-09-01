class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for( int i : nums)
        {
            set.add(i);
        }

        int longest = 0;

        for(int num : set)
        {
            if(!set.contains(num-1)) // as we want to start the sequence from here
            {
                int current = num;
                int length=1;
            
            while(set.contains(current+1))
            {
                current++;
                length++;
            }

            longest = Math.max(longest,length);
            }
        }
        return longest;

    }
}
