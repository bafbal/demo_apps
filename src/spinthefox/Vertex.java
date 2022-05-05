package spinthefox;

public class Vertex{

    private double[] xyz = new double[3];
    private int[] shadow = new int[2];
    private double radius;
    private double[] angles = new double[3];

    public Vertex(double x, double y, double z) {
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
        radius = Math.sqrt(Math.pow(xyz[0], 2) + Math.pow(xyz[1], 2) + Math.pow(xyz[2], 2));
        calculateangles();
        calculateShadow();
    }

    private void calculateangles() {
        angles[0] = Math.atan2(xyz[2], xyz[1]);
        angles[1] = Math.atan2(xyz[0], xyz[2]);
        angles[2] = Math.atan2(xyz[0], xyz[1]);
    }

    private void calculateShadow() {
        shadow[0] = (int) (xyz[0] * 1000 / (xyz[2] + 500) + 400);
        shadow[1] = (int) (400 - xyz[1] * 1000 / (xyz[2] + 500));
    }

    public void rotateAroundX(double radian) {
        angles[0] += radian;
        if (angles[0] > Math.PI) {
            angles[0] -= 2 * Math.PI;
        }
        if (angles[0] < -1 * Math.PI) {
            angles[0] += 2 * Math.PI;
        }
        if (angles[0] < Math.PI / 2 && angles[0] > -1 * Math.PI / 2) {
            xyz[1] = Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[0], 2)) / (1 + Math.pow(Math.tan(angles[0]), 2)));
        } else {
            xyz[1] = -1 * Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[0], 2)) / (1 + Math.pow(Math.tan(angles[0]), 2)));
        }
        if (angles[0] > 0) {
            xyz[2] = Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[0], 2) - Math.pow(xyz[1], 2));
        } else {
            xyz[2] = -1 * Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[0], 2) - Math.pow(xyz[1], 2));
        }

        calculateangles();
        calculateShadow();
    }

    public void rotateAroundY(double radian) {
        angles[1] += radian;
        if (angles[1] > Math.PI) {
            angles[1] -= 2 * Math.PI;
        }
        if (angles[1] < -1 * Math.PI) {
            angles[1] += 2 * Math.PI;
        }
        if (angles[1] < Math.PI / 2 && angles[1] > -1 * Math.PI / 2) {
            xyz[2] = Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[1], 2)) / (1 + Math.pow(Math.tan(angles[1]), 2)));
        } else {
            xyz[2] = -1 * Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[1], 2)) / (1 + Math.pow(Math.tan(angles[1]), 2)));
        }
        if (angles[1] > 0) {
            xyz[0] = Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[1], 2) - Math.pow(xyz[2], 2));
        } else {
            xyz[0] = -1 * Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[1], 2) - Math.pow(xyz[2], 2));
        }
        calculateangles();
        calculateShadow();
    }

    public void rotateAroundZ(double radian) {
        angles[2] += radian;
        if (angles[2] > Math.PI) {
            angles[2] -= 2 * Math.PI;
        }
        if (angles[2] < -1 * Math.PI) {
            angles[2] += 2 * Math.PI;
        }
        if (angles[2] < Math.PI / 2 && angles[2] > -1 * Math.PI / 2) {
            xyz[1] = Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[2], 2)) / (1 + Math.pow(Math.tan(angles[2]), 2)));
        } else {
            xyz[1] = -1 * Math.sqrt((Math.pow(radius, 2) - Math.pow(xyz[2], 2)) / (1 + Math.pow(Math.tan(angles[2]), 2)));
        }
        if (angles[2] > 0) {
            xyz[0] = Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[1], 2) - Math.pow(xyz[2], 2));
        } else {
            xyz[0] = -1 * Math.sqrt(Math.pow(radius, 2) - Math.pow(xyz[1], 2) - Math.pow(xyz[2], 2));
        }
        calculateangles();
        calculateShadow();
    }

    public int[] getShadow() {
        return shadow;
    }

    public double[] getXyz() {
        return xyz;
    }

    public double getRadius() {
        return radius;
    }

    public double[] getAngles() {
        return angles;
    }
}
