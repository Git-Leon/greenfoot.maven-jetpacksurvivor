
package com.github.git_leon.jetpack_survivor_maven.actors;


public class CoolDown {
    private String methodname;
    private double maxlife;
    private double birthTime;

    public CoolDown(String methodname, double maxlife) {
        this.birthTime = System.currentTimeMillis();
        this.methodname = methodname;
        this.maxlife = maxlife;
    }

    public boolean isAvailable() {
        boolean available = elapsed() >= maxlife;
        if (available)
            setBirth(System.currentTimeMillis());
        return available;
    }

    public String getMethodName() {
        return methodname;
    }

    public void setBirth(double birthTime) {
        this.birthTime = birthTime;
    }

    private double elapsed() {
        return System.currentTimeMillis() - birthTime;
    }

    public void setMaxLife(double val) {
        this.maxlife = val;
    }
}