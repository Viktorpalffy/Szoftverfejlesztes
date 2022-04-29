package numberguessinggame.results;

public class GameResultExample {

    public static void main(String[] args) {
        GameResultDao gameResultDao = GameResultDao.getInstance();
        GameResult gameResult = GameResult.builder()
                .player("Viktor")
                .guessCount(9)
                .build();
        gameResultDao.persist(gameResult);
        System.out.println(gameResult);
        System.out.println(gameResultDao.findBest(10));
    }

}
