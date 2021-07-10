public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet p){
        return Math.sqrt(Math.pow(p.xxPos - this.xxPos, 2) + Math.pow(p.yyPos - this.yyPos, 2));
    }

    public double calcForceExertedBy(Planet p){
//        double dxx = p.xxPos - this.xxPos;
//        double dyy = p.yyPos - this.yyPos;
        final double G = 6.67 * Math.pow(10, -11);
        double dis = calcDistance(p);
        double force = (G * this.mass * p.mass)/Math.pow(dis,2);
        return force;
    }

    public double calcForceExertedByX(Planet p){
        double dxx = p.xxPos - this.xxPos;

        double force = calcForceExertedBy(p);
        double dis = calcDistance(p);

        return (force * dxx) / dis;
    }

    public double calcForceExertedByY(Planet p){
        double dyy =  p.yyPos - this.yyPos;

        double force = calcForceExertedBy(p);
        double dis = calcDistance(p);

        return (force * dyy) / dis;
    }

    public double calcNetForceExertedByX(Planet[] p){
        double netF = 0.0;
        for(Planet pi : p){
            if(pi.equals(this)){
                continue;
            }
            netF += calcForceExertedByX(pi);
        }
        return netF;
    }

    public double calcNetForceExertedByY(Planet[] p){
        double netF = 0.0;
        for(Planet pi : p){
            if(pi.equals(this)){
                continue;
            }
            netF += calcForceExertedByY(pi);
        }
        return netF;
    }

    public void update(double dt, double fX, double fY){
        double accX = fX/mass;
        double accY = fY/mass;

        xxVel += dt * accX;
        yyVel += dt * accY;

        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
