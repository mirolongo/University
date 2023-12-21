package models;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDate;

public abstract class User {
    public int userId;
    public String name;
    public String dateOfBirth;

    public User(int userId, String name, String dateOfBirth) {
        this.userId = userId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public void saveToMongoDB() {
        MongoDatabase mongoDatabase = MongoDBConnection.connect();
        MongoCollection<Document> userCollection = mongoDatabase.getCollection("users");

        Document userDocument = new Document("userId", userId)
                .append("name", name)
                .append("dateOfBirth", dateOfBirth)
                .append("userType", getUserType());

        userCollection.insertOne(userDocument);
    }

    public static User loadFromMongoDB(int userId, Document userDocument) throws Exception {
        MongoDatabase mongoDatabase = MongoDBConnection.connect();
        MongoCollection<Document> userCollection = mongoDatabase.getCollection("users");

        userDocument = userCollection.find(new Document("userId", userId)).first();

        if (userDocument != null) {
            String userType = userDocument.getString("userType");
            switch (userType) {
                case "Student", "Teacher", "Administrator":
                    return Student.loadFromMongoDB(userId, userDocument);
                default:
                    return null;
            }
        }

        return null;
    }

    public abstract void setSubjectId(int subjectId);

    public abstract String getUserType();

    public abstract int getSubjectId();
}
