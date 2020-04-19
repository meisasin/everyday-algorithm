package _20200419;

class Solution_me {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if (s1.equals(s2) && n1 == n2) {
            return 1;
        }

        int nd1idx = 0;
        int s1IthmCount = 0;
        int s2IthmCount = 0;
        int count = 0;

        int ns2Idx = 0;
        while (0 == 0) {

            int findIdx = s1.indexOf(s2.charAt(ns2Idx), nd1idx);
            if (findIdx == -1) {
                if (++s1IthmCount >= n1) {
                    break;
                }
                nd1idx = 0;
                continue;
            }

            // 从匹配点再往后找一个匹配的点
            nd1idx = findIdx + 1;

            if (++ns2Idx == s2.length()) {
                // 从 新开始找下一个
                ns2Idx = 0;
                if (++s2IthmCount == n2) {
                    s2IthmCount = 0;
                    count++;
                }
            }
        }

        return count;
    }


}