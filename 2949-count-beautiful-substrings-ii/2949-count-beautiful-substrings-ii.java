class Solution {
    public long beautifulSubstrings(String s, int k) {
        String vowels = "aeiou";

        int vowelCount = 0;
        int consonantCount = 0;
        long beautifulSubstringCount = 0;

        Map<Integer, Map<Integer, Integer>> prefixMap = new HashMap<>();

        Map<Integer, Integer> initialVowelMap = new HashMap<>();
        initialVowelMap.put(0, 1);
        prefixMap.put(0, initialVowelMap);

        for (char ch : s.toCharArray()) {

            if (vowels.indexOf(ch) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }

            int balance = vowelCount - consonantCount;

            if (prefixMap.containsKey(balance)) {
                Map<Integer, Integer> vowelFrequencyMap = prefixMap.get(balance);

                for (Map.Entry<Integer, Integer> entry : vowelFrequencyMap.entrySet()) {
                    int previousVowelCount = entry.getKey();
                    int frequency = entry.getValue();
                    if ((vowelCount % k - previousVowelCount) * (vowelCount % k - previousVowelCount)
                            % k == 0) {
                        beautifulSubstringCount += frequency;
                    }
                }
            }

            if (!prefixMap.containsKey(balance)) {
                prefixMap.put(balance, new HashMap<>());
            }

            Map<Integer, Integer> vowelFrequencyMap = prefixMap.get(balance);

            vowelFrequencyMap.put(
                    vowelCount % k,
                    vowelFrequencyMap.getOrDefault(vowelCount % k, 0) + 1);
        }

        return beautifulSubstringCount;
    }
}