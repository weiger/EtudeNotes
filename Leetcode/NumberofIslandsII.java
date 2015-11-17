public class Solution{
	public int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind2D uf = new UnionFind2D(m, n);
		List<Integer> res = new ArrayList<>();
		for (int[] pos: positions) {
			int x = pos[0]; int y = pos[1];
			int p = uf.add(x, y);
			for (int[] d: direct) {
				int q = uf.getID(x + d[0], y + d[1]);
				if (q > 0 && !uf.find(p, q)) {
					uf.union(p, q);
				}
			}
			res.add(uf.size());
		}
		return res;
	}
}

class UnionFind2D {
	private int[] id;
	private int[] size;
	private int m, n, count;

	public UnionFind2D(int m, int n) {
		this.count = 0;
		this.m = m;
		this.n = n;
		this.id = new int[m * n + 1];
		this.size = new int[m * n + 1];
	}

	public int index(int x, int y) { return x * n + y + 1; }

	public int size() { return this.count; }

	public int getID(int x, int y) {
		if (x >= 0 && x < m && y >= 0 && y < n) {
			return id[index(x, y)];
		}
		return 0;
	}

	public int add(int x, int y) {
		int idx = index(x, y);
		id[idx] = idx; size[idx] = 1;
		count++;
		return idx; 
	}

	public boolean find(int p, int q){
		return root(p) == root(q);
	}

	public void union(int p, int q){
		int i = root(p); int j = root(q);
		if (size[i] < size[j]) {
			id[i] = j; size[j] += size[i];
		} else {
			id[j] = i; size[i] += size[j];
		}
		count--;
	}

	public int root(int i) {
		for (; i != id[i]; i = id[i]) {
			id[i] = id[id[i]];
		}
		return i;
	}
}
