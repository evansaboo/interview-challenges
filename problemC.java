package se.demo.applianceservice.error;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problemC {

    static class V2 { double x, y; V2(double X, double Y) { x = X; y = Y; } }
    static class Vec { V2 from, to; double length; Vec(V2 f, V2 t, double l) {from = f; to = t; length = l; } }
    static V2 sub(V2 a, V2 b) { return new V2(a.x - b.x, a.y - b.y); }
    static V2 sum(V2 a, V2 b) { return new V2(a.x + b.x, a.y + b.y); }
    static V2 mul(V2 a, double k) { return new V2(a.x * k, a.y * k); }
    static class Step { Vec e1, e2; V2 vertex; Step(Vec E1, Vec E2, V2 vx) { e1 = E1; e2 = E2; vertex = vx; }}

    static Step next(Vec A, double B, double C) {
        V2 delta = sub(A.to, A.from);
        V2 vec = mul(delta, 1.0 / A.length);
        V2 tan = new V2(vec.y, -vec.x);
        double v = (A.length * A.length - B * B + C * C) / (2 * A.length); // could be optimized memoizing
        double h2 = C * C - v * v;
        if(h2 < 0.0)
            return null;
        double h = Math.sqrt(h2);
        V2 vertex = sum(sum(A.from, mul(vec, v)), mul(tan, h));
        return new Step(new Vec(vertex, A.to, B), new Vec(A.from, vertex, C), vertex);
    }

    static double bruteForce(double [] edges, Set<Integer> used, Vec base) {
        if(edges.length - used.size() < 2)
            return 0.0;
        double max = 0.0;
        // for every two (not used) edges we can construct a new triangle
        for(int i = 0; i < edges.length; i++)
            if(!used.contains(i)) {
                used.add(i);
                for (int j = 0; j < edges.length; j++)
                    if(!used.contains(j)) {
                        used.add(j);
                        Step s = next(base, edges[i], edges[j]);
                        if(s != null) {
                            max = Math.max(max, s.vertex.x);
                            max = Math.max(max, bruteForce(edges, used, s.e1));
                            max = Math.max(max, bruteForce(edges, used, s.e2));
                            max = Math.max(max, bruteForce(edges, used, new Vec(s.e1.to, s.e1.from, s.e1.length)));
                            max = Math.max(max, bruteForce(edges, used, new Vec(s.e2.to, s.e2.from, s.e2.length)));
                        }
                        used.remove(j);
                    }
                used.remove(i);
            }
        return max;
    }

    static double bruteForce(double [] edges) {
        Set<Integer> used = new HashSet<>();
        double max = 0.0;
        for(int i = 0; i < edges.length; i++) {
            used.add(i);
            max = Math.max(max, bruteForce(edges, used, new Vec(new V2(0.0, 0.0), new V2(0.0, edges[i]), edges[i])));
            used.remove(i);
        }
        return max;
    }

    private static double[] convertStringToInteger(String [] values, int countSegments) {
        double[] segments = new double[countSegments];
        for(int i = 1; i < values.length; i++){
            segments[i-1] = Integer.parseInt(values[i]);
        }

        return segments;
    }
    private static String[] getInputs() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input.split(" ");
    }

    public static void main(String... args) {
        String[] values = getInputs();
        int countSegments = Integer.parseInt(values[0]);
        double[] segments = convertStringToInteger(values, countSegments);

        double r = bruteForce(segments);
        System.out.printf(java.util.Locale.US, "%.2f%n", r);
    }
}




