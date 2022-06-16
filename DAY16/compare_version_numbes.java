package DAY16;

public class compare_version_numbes {

    // Approach #1 Implementation
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        if (a.length > b.length)
            return -1 * compareVersion(version2, version1);

        int i;
        for (i = 0; i < a.length; i++) {
            int first = Integer.parseInt(a[i]);
            int second = Integer.parseInt(b[i]);
            int cmp = Integer.compare(first, second);
            if (cmp != 0)
                return cmp;
        }
        while (i < b.length) {
            if (Integer.parseInt(b[i]) > 0)
                return -1;
            i++;
        }
        return 0;

    }

    // Approach #2 concise implmentation
    public int compareVersion1(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
