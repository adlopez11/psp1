package edu.uniandes.ecos.vo;

/**
 *
 * @author Alvaro
 */
public class ParVO {
    private Double x;
    private Double y;

    public ParVO(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public Double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Double y) {
        this.y = y;
    }
}
