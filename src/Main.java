import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class Main {
    public static List<Player> getPlayers1(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new FileInputStream(new File(fileName));
        TypeReference<List<Player>> typeReference = new TypeReference<List<Player>>() {};

        List<Player> playerList = new ObjectMapper().readValue(new FileInputStream(new File(fileName)),new TypeReference<List<Player>>() {});

        return playerList;

    }

    public static void delete_all_table(Data d) {
        TestConnection.deleteTable(Requests.drop("player_db.player"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("player_db.items"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("player_db.currencies"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("player_db.progresses"), d.getConnection());
    }

    public static void create_all_table(Data d) throws SQLException {
        TestConnection.createTable(Requests.create_player(), d.getConnection());
        TestConnection.createTable(Requests.create_items(), d.getConnection());
        TestConnection.createTable(Requests.create_currencies(), d.getConnection());
        TestConnection.createTable(Requests.create_progresses(), d.getConnection());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Data d = new Data();
        delete_all_table(d);
        create_all_table(d);
        List<Player> lst = getPlayers1("C:\\Users\\axlox\\IdeaProjects\\JavaJSON\\src\\players.json");
        InsertDataToDB.enter(lst, d.getConnection());
        FromDBToList.fromDbToMaps(d);
    }
}