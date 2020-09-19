public class FootballField {
    private Strategy gameStrategy;

    public FootballField(Strategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public void applyStrategy() {
        gameStrategy.chooseStrategy();
    }
}
