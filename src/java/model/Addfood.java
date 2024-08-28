package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Addfood {
    private String foodname;
    private String type;
    private String crispness;
    private String hotlevel;
    private String sauce;
    private double foodPrice;

    // Getter and Setter methods
    public String getFoodname() { return foodname; }
    public void setFoodname(String foodname) { this.foodname = foodname; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getCrispness() { return crispness; }
    public void setCrispness(String crispness) { this.crispness = crispness; }
    public String getHotlevel() { return hotlevel; }
    public void setHotlevel(String hotlevel) { this.hotlevel = hotlevel; }
    public String getSauce() { return sauce; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public double getFoodPrice() { return foodPrice; }
    public void setFoodPrice(double foodPrice) { this.foodPrice = foodPrice; }
}
