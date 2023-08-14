class MyHashMap {

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    public static int hash(int key) {
        return key % BASE;
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        // 不存在则放在最后
        data[h].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> it = data[h].iterator();
        while (it.hasNext()) {
            Pair pair = it.next();
            if (pair.getKey() == key) {
                data[h].remove(pair);
                return;
            }
        }
    }

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
