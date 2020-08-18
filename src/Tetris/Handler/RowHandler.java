package Tetris.Handler;

import Tetris.Model.Map.GameMap;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2020-August-15
 */

public class RowHandler {
    private GameMap gameMap;
    private GameHandler gameHandler;
    
    public RowHandler(GameMap gameMap, GameHandler gameHandler){
        this.gameMap = gameMap;
        this.gameHandler = gameHandler;
    }
    
    public void checkFullRow(){
        boolean[] rows = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (gameMap.getSetMap()[y][x].equals(" ")) rows[y] = false;
            }
        }

        int cnt = 0;
        int trueCnt = 0;
        int[] trueRows = new int[4];
        for (int i = 0; i < 20; i++) {
            if (rows[i]) {
                cnt++;
                trueRows[trueCnt] = i;
                trueCnt++;
            };
        }

        if (cnt > 0){
            switch (cnt){
                case 1:
                    gameHandler.addPoints(40);
                    break;
                case 2:
                    gameHandler.addPoints(100);
                    break;
                case 3:
                    gameHandler.addPoints(300);
                    break;
                case 4:
                    gameHandler.addPoints(1200);
                    break;
            }

            for (int i = 0; i < cnt; i++) {
                for (int x = 0; x < 10; x++) {
                    gameMap.setFieldSet(trueRows[i], x, " ");
                }
            }

            //TODO move shit down
        }
    }
}
