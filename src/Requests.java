public class Requests {
    public static String getQueryAllDataRequest(String tableName){
        return "SELECT * FROM "+tableName;
    }

    public static String drop(String tableName) {
        return "DROP TABLE "+tableName;
    }
    public static String insert_player(int playerId, String name) {
        return "INSERT player_db.player(playerId,nickname) VALUES(" + playerId + ",'" + name + "'" + ")";
    }
    public static String insert_currencies(Currencies c) {
        return "INSERT player_db.currencies(id,playerId,resourceId,name,count) VALUES(" + c.getId() + ", " + c.getPlayerId() + ", " + c.getResourceId() + ", '" + c.getName() + "', " + c.getCount() + ")";
    }
    public static String insert_progresses(Progresses p) {
        return "INSERT player_db.progresses(id,playerId,resourceId,score,maxScore) VALUES(" + p.getId() + ", " + p.getPlayerId() + ", " + p.getResourceId() + ", " + p.getScore() + ", " + p.getMaxScore() + ")";
    }
    public static String insert_items(Items i) {
        return "INSERT player_db.items(id,playerId,resourceId,count,level) VALUES(" + i.getId() + ", " + i.getPlayerId() + ", " + i.getResourceId() + ", " + i.getCount() + ", " + i.getLevel() + ")";
    }
    public static String create_currencies() {
        return "CREATE TABLE player_db.currencies (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  name varchar(45) NOT NULL," +
                "  count int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ") ";
    }
    public static String create_items() {
        return "CREATE TABLE player_db.items (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  count int NOT NULL," +
                "  level int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ")";
    }
    public static String create_progresses() {
        return "CREATE TABLE player_db.progresses (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  score int NOT NULL," +
                "  maxScore int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ")";
    }
    public static String create_player() {
        return "CREATE TABLE player_db.player (" +
                "  playerId int NOT NULL," +
                "  nickname varchar(45) NOT NULL," +
                "  PRIMARY KEY (playerId)" +
                ")";
    }
    public static String query_progresses(String val) {
        return "SELECT * FROM player_db.progresses WHERE playerId=" + val;
    }
    public static String query_items(String val) {
        return "SELECT * FROM player_db.items WHERE playerId=" + val;
    }
    public static String query_currencies(String val) {
        return "SELECT * FROM player_db.currencies WHERE playerId=" + val;
    }
    public static String query_player() {
        return "SELECT * FROM player_db.player";
    }
}
