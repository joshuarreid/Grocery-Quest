package controller;

/**The AntiMasker Class
 *
 * The AntiMasker class is responsible for creating AntiMasker mob objects
 * and holding their attributes
 *
 * Health - the amount of health the mob has
 * Speed - how fast the mob can move
 * Damage - how much damage the mob deals
 */
public class AntiMasker {
    private double health;
    private double speed;
    private double damage;

    //TODO discuss and implement default values of health, speed, and damage
    public AntiMasker() {
        this.health = 10;
        this.speed = 1;
        this.damage = 1;
    }
}
