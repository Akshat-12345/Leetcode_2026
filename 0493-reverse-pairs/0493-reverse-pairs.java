import java.util.*;

class Solution {

    class SegmentTree {
        int[] st;

        SegmentTree(int n) {
            st = new int[4 * n];
        }

        void update(int idx, int i, int l, int r) {
            if (l == r) {
                st[i]++;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) update(idx, 2*i+1, l, mid);
            else update(idx, 2*i+2, mid+1, r);

            st[i] = st[2*i+1] + st[2*i+2];
        }

        int query(int ql, int qr, int i, int l, int r) {
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return st[i];

            int mid = (l + r) / 2;
            return query(ql, qr, 2*i+1, l, mid)
                 + query(ql, qr, 2*i+2, mid+1, r);
        }
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;

        // 🔥 Compression values
        TreeSet<Long> set = new TreeSet<>();
        for (int x : nums) {
            set.add((long)x);
            set.add(2L * x);
        }

        List<Long> list = new ArrayList<>(set);
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        SegmentTree st = new SegmentTree(list.size());

        int ans = 0;

        // 🔁 LEFT → RIGHT
        for (int x : nums) {

            // 🔍 Query: count > 2*x
            long target = 2L * x;

            int idx = map.get(target);

            ans += st.query(idx + 1, list.size() - 1, 0, 0, list.size() - 1);

            // ➕ Insert current number
            int insertIdx = map.get((long)x);
            st.update(insertIdx, 0, 0, list.size() - 1);
        }

        return ans;
    }
}