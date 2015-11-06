class NestList{
    boolean isInteger();
    NestList[] getList();
    int getVal();
}

public class Solution {
    public int depthSum(List<NestedInteger> input) {
        return getSum(input, 1);
    }


    public int getSum(List<NestedInteger> input, int level) {
        int sum = 0;
        if (input.size() == 0)
            return 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).isInteger()) {
                sum += input.get(i).getInteger() * level;
            } else {
                sum += getSum(input.get(i).getList(), level + 1);
            }
        }
        return sum;
    }
}

public int getSum2(NestList curr) {
	if (curr == null) {
		return 0;
	}
	int level = getLevel(curr);
	level += 1;
	return getSum2Helper(curr, level);
}

public int getSum2Helper(NestList curr, int level) {
	if (curr == null) {
		return 0;
	} else if (curr.isInteger()) {
		return curr*level;
	} else {
		int sum = 0;
		NestList[] next = curr.getList();
		for (int i=0; i<next.length; i++) {
			sum += getSum2Helper(next[i], level-1);
		}
	}
	return sum;
}

public int getLevel(NestList curr) {
	if (curr == null) {
		return 0;
	}
	if (curr.isInteger()) {
		return 0;
	} else {
		int res = Integer.MIN_VALUE;
		NestList[] next = curr.getList();
		for (int i=0; i<next.length; i++) {
			res = Math.max(res, getLevel(next[i])+1);
		}
		return res;
	}
}
