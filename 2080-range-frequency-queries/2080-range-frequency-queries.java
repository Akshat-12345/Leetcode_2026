import java.util.*;

class RangeFreqQuery {

    Map<Integer, Integer>[] st;
    int n;

    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        st = new HashMap[4 * n];
        build(0, 0, n - 1, arr);
    }

    private void build(int node, int l, int r, int[] arr) {
        st[node] = new HashMap<>();

        if (l == r) {
            st[node].put(arr[l], 1);
            return;
        }

        int mid = (l + r) / 2;

        build(2 * node + 1, l, mid, arr);
        build(2 * node + 2, mid + 1, r, arr);

        // merge left + right
        Map<Integer, Integer> left = st[2 * node + 1];
        Map<Integer, Integer> right = st[2 * node + 2];

        for (int key : left.keySet()) {
            st[node].put(key, left.get(key));
        }

        for (int key : right.keySet()) {
            st[node].put(key, st[node].getOrDefault(key, 0) + right.get(key));
        }
    }

    public int query(int left, int right, int value) {
        return query(0, 0, n - 1, left, right, value);
    }

    private int query(int node, int l, int r, int ql, int qr, int value) {
        if (r < ql || l > qr) return 0;

        if (ql <= l && r <= qr) {
            return st[node].getOrDefault(value, 0);
        }

        int mid = (l + r) / 2;

        return query(2 * node + 1, l, mid, ql, qr, value)
             + query(2 * node + 2, mid + 1, r, ql, qr, value);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */