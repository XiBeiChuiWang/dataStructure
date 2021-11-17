public class 布隆过滤器 <T>{
    private int bitsize;
    private long[] bit;
    private int hashsize;

    public 布隆过滤器(int countsize,double p) {
        if (countsize <= 0 || p <= 0 || p >= 1){
            throw new RuntimeException("输入有误");
        }

        bitsize = (int)(-(countsize * Math.log(p)) / (Math.log(2) * Math.log(2)));
        hashsize = (int)((bitsize * Math.log(2)) / countsize);
        bit = new long[(bitsize + Long.SIZE - 1) / Long.SIZE];
        System.out.println(bitsize+"  "+"   "+hashsize+"   "+bit.length);
    }
    public boolean put(T value){
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        boolean result = false;
        for (int i = 1;i <= hashsize;i++){
            int combinedHash = hash1 + (i * hash2);
            if(combinedHash < 0){
                combinedHash = ~combinedHash;
            }
            int index = combinedHash % bitsize;
            System.out.println(index);
            int i1 = 1 << index;
            if (set(index)) result = true;
        }
        return result;
    }

    public boolean contains(T value) {
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;

        for (int i = 1; i <= hashsize; i++) {
            int combinedHash = hash1 + (i * hash2);
            if (combinedHash < 0) {
                combinedHash = ~combinedHash;
            }
            // 生成一个二进位的索引
            int index = combinedHash % bitsize;
            // 查询index位置的二进位是否为0
            if (!get(index)) return false;
        }
        return true;
    }

    private boolean set(int index) {
        long value = bit[index / Long.SIZE];
        int bitValue = 1 << (index % Long.SIZE);
        bit[index / Long.SIZE] = value | bitValue;
        return (value & bitValue) == 0;
    }

    private boolean get(int index) {
        long value = bit[index / Long.SIZE];
        return (value & (1 << (index % Long.SIZE))) != 0;
    }
}
