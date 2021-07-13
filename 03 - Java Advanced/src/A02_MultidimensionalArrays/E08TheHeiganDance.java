package A02_MultidimensionalArrays;

public class E08TheHeiganDance {
//    At last, level 80. And what do level eighties do? Go raiding. This is where you are now – trying not to be wiped by the famous dance boss, Heigan the Unclean. The fight is pretty straightforward - dance around the Plague Clouds and Eruptions, and you’ll be just fine.
//    Heigan’s chamber is a 15-by-15 two-dimensional array. The player always starts at the exact center. For each turn, Heigan uses a spell that hits a certain cell and the neighboring rows/columns. For example, if he hits (1,1), he also hits (0,0, 0,1, 0,2, 1,0 … 2,2). If the player’s current position is within the area of damage, the player tries to move. First, he tries to move up, if there’s damage/wall, he tries to move right, then down, then left. If he cannot move in any direction, because the cell is damaged or there is a wall, the player stays in place and takes the damage.
//    Plague cloud does 3500 damage when it hits, and 3500 damage the next turn. Then it expires. Eruption does 6000 damage when it hits. If a spell hits a player that also has an active Plague Cloud from the previous turn, the cloud damage is applied first. Both Heigan and the player may die in the same turn. If Heigan is dead, the spell he would have casted is ignored.
//    The player always starts at 18500 hit points; Heigan starts at 3,000,000 hit points. Each turn, the player does damage to Heigan. The fight is over either when the player is killed, or Heigan is defeated.

    public static void main(String[] args) {

    }
}
