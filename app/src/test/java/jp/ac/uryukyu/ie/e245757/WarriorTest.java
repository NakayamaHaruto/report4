package jp.ac.uryukyu.ie.e245757;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WarriorTest {
    /**
     * Warriorクラスからオブジェクトを生成し、attackWithWeponSkillを3回実行し、
     * 3回ともattackの150%ダメージになっていることを確認する
     * 検証手順
     * (1) 戦士と敵を準備。戦士の攻撃力は偶数にして1.5倍した時に整数になるようにする
     * (2) 戦士が3回殴り、戦士の攻撃力の4.5倍のダメージが敵に与えられてることを期待
     * (3)　assertEqualsでdefaultWarriorAt * 4.5　が敵の最初のHPから3回攻撃
     *     された後のHPの差が等しくなることを検証する
     */
    @Test
    void attackWithWeponSkillTest(){
        int numberAttempts = 3;//試行回数
        int defaultWarriorAt = 10;//デフォルトの攻撃力
        int defaultSlimeHp = 100;//デフォルトの体力
        Warrior demoWarrior = new Warrior("デモ戦士", 100, defaultWarriorAt);
        Enemy slime = new Enemy("スライムもどき", defaultSlimeHp, 100);
        for (int i = 0; i < numberAttempts; i++){
            demoWarrior.attackWithWeponSkill(slime);
        }
        assertEquals(defaultWarriorAt * 1.5 * numberAttempts, defaultSlimeHp - slime.getHitPoint());
    }

}
