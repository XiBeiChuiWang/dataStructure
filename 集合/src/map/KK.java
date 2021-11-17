package map;

import java.util.Objects;

public class KK {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public KK(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KK)) return false;
        KK kk = (KK) o;
        return a == kk.a;
    }

    @Override
    public int hashCode() {
        return a/20;
    }
}
