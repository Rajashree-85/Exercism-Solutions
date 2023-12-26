import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class PythagoreanTriplet {
    private final int a;
    private final int b;
    private final int c;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(a);
        sb.append(", ");
        sb.append(b);
        sb.append(", ");
        sb.append(c);
        sb.append(")");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PythagoreanTriplet) {
            PythagoreanTriplet p = (PythagoreanTriplet) obj;
            return a == p.a && b == p.b && c == p.c;
        }
        return false;
    }
    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }
    public static class PythagoreanTripletBuilder {
        private int s;
        private Integer limit;
        public PythagoreanTripletBuilder thatSumTo(int sum) {
            s = sum;
            return this;
        }
        public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int limit) {
            this.limit = limit;
            return this;
        }
        public List<PythagoreanTriplet> build() {
            int a = 1;
            int b = 0;
            boolean next = true;
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            while(next && a < s) {
                int r1 = s * s - 2 * s * a;
                int r2 = 2 * s - 2 * a;
                if(r1 % r2 == 0) {
                    b = r1 / r2;
                    int c = s - a - b;
                    if((a < b && b < c)) {
                        if(Objects.isNull(limit) || (a <= limit && b <= limit && c <= limit)) {
                            triplets.add(new PythagoreanTriplet(a, b, c));
                        }
                    }else {
                        next = false;
                    }
                }
                a++;
            }
            return triplets.size() == 1 ? Collections.singletonList(triplets.get(0)) : triplets;
        }
    }
}
