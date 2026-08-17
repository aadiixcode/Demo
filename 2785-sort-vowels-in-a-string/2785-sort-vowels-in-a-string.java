class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        String vowels = "AEIOUaeiou";
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            }
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                while (i < 10) {
                    char vowel = vowels.charAt(i);
                    if (mp.containsKey(vowel)) {
                        int freq = mp.get(vowel);
                        if (freq > 0) {
                            sb.append(vowel);
                            freq -= 1;
                            if (freq > 0) {
                                mp.put(vowel, freq);
                            } else if (freq == 0) {
                                mp.remove(vowel);
                            }
                            break;
                        }
                    }
                    i += 1;
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}