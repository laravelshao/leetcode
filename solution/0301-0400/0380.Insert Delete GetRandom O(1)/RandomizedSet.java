class RandomizedSet {

    private List<Integer> nums;
    // 存放元素对应在数组中下标
    private Map<Integer, Integer> idxMap;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }

        int n = nums.size();
        nums.add(val);
        idxMap.put(val, n);
        return true;
    }

    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }

        // 将最后一个元素替换删除位置
        int idx = idxMap.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(idx, last);
        idxMap.put(last, idx);
        // 删除最后一个元素
        nums.remove(nums.size() - 1);
        idxMap.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */