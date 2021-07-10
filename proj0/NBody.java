public class NBody {

    public static double readRadius(String fileName){
        In in = new In(fileName);
        int number = in.readInt();
        double scale = in.readDouble();

        in.close();
        return scale;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int number = in.readInt();
        Planet[] p = new Planet[number];
        double scale = in.readDouble();
        for(int i = 0; i < number; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String imgName = in.readString();

            p[i] = new Planet(xP, yP, xV,yV, m, imgName);
        }

        in.close();
        return p;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] p = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
//        StdDraw.clear();
//        StdDraw.enableDoubleBuffering();
//
//        String backgroundFile = "images/starfield.jpg";
//        StdDraw.picture(0,0,backgroundFile);
//        StdDraw.show();

        double time = 0.0;
        while(time < T){
            //Calculate the net x and y forces for each planet, storing these in the xForces and yForces
            // arrays respectively.
            double[] xForces = new double[p.length];
            double[] yForces = new double[p.length];
            for(int i = 0; i < p.length; i++){
                xForces[i] = p[i].calcNetForceExertedByX(p);
                yForces[i] = p[i].calcNetForceExertedByY(p);
            }

            //Call update on each of the planets. This will update each planet’s position, velocity,
            // and acceleration.
            for(int i = 0; i < p.length; i++){
                p[i].update(dt, xForces[i], yForces[i]);
            }

            //Draw the background image
            StdDraw.clear();
            StdDraw.enableDoubleBuffering();

            String backgroundFile = "images/starfield.jpg";
            StdDraw.picture(0,0,backgroundFile);

            //Draw all of the planets.
            for(Planet it:p){
                it.draw();
            }
            StdDraw.show();

            //pause the animation for 10 milliseconds
            //StdDraw.pause(10);

            time += dt;
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }

    }
}
