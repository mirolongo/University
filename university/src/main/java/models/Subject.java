package models;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.time.LocalDate;

public class Subject {
    public int subjectId;
    public String subjectName;
    public String description;
    public int courseId;

    public Subject(int subjectId, String subjectName, String description, int courseId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.description = description;
        this.courseId = courseId;
    }

    public void saveToMongoDB() {
        MongoCollection<Document> subjectCollection = MongoDBConnection.connect().getCollection("subject");

        Document subjectDocument = new Document("subjectId", subjectId)
                .append("subjectName", subjectName)
                .append("description", description)
                .append("courseId", courseId);

        subjectCollection.insertOne(subjectDocument);
    }

    // Getter and Setter methods...

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
