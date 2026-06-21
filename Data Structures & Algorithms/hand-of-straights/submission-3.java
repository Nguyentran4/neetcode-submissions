class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand); //sorting is what guarantees we always start with the smallest available card.

        for (int num : hand) {
            if (count.get(num) == 0) {
                continue;
            }

            for (int i = num; i < num + groupSize; i++) {
                if (count.getOrDefault(i, 0) == 0) {
                    return false;
                }

                count.put(i, count.get(i) - 1);
            }
        }

        return true;
    }
}