package strukdat;
import java.util.*;

public class UnionFind<T> {
    private Map<T, T> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public void makeSet(T x) {
        parent.put(x, x);
    }

    public T find(T x) {
        if (!parent.containsKey(x)) {
            return null;
        }
        T root = x;
        while (parent.get(root) != root) {
            root = parent.get(root);
        }
        // Path compression
        while (x != root) {
            T next = parent.get(x);
            parent.put(x, root);
            x = next;
        }
        return root;
    }

    public void union(T x, T y) {
        T rootX = find(x);
        T rootY = find(y);
        if (rootX != null && rootY != null && rootX != rootY) {
            parent.put(rootX, rootY);
        }
    }

    public boolean connected(T x, T y) {
        T rootX = find(x);
        T rootY = find(y);
        return rootX != null && rootY != null && rootX == rootY;
    }
}
