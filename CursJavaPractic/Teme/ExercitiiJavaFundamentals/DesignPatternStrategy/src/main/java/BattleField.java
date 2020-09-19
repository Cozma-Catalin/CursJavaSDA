public class BattleField {
    private Strategy battleStrategy;

    public BattleField(Strategy battleStrategy){
        this.battleStrategy = battleStrategy;
    }

    public void executeStrategy(){
        battleStrategy.chooseStrategy();

    }


}
