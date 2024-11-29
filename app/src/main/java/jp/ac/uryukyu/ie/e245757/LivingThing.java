package jp.ac.uryukyu.ie.e245757;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return dead;
    }
    public void setDead(boolean isDead){
        dead = isDead;
    }
    public String getName(){
        return name;
    }
    public int getHitPoint(){
        return hitPoint;
    }
    protected void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
    protected int getAttack(){
        return attack;
    }

    public void attack(LivingThing opponent){
        if (hitPoint > 0){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }  
    }
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
