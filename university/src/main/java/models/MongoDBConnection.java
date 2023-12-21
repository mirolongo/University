package models;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://university:university@cluster0.cuepd1o.mongodb.net/?retryWrites=true&w=majority";
    private static final String DATABASE_NAME = "university";

    public static MongoDatabase connect() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClient mongoClient = MongoClients.create(connectionString);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
