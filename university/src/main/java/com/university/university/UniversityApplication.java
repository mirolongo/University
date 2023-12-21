package com.university.university;

import com.mongodb.client.MongoCollection;
import models.*;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDate;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);

		Course course = new Course(1, "IT management", "To understand systems");
		Subject subject = new Subject(1, "Operating System", "About operation", 1);
		Administrator administrator = new Administrator(1, "Joseph", "2001-01-01", "Finances");
		Teacher teacher = new Teacher(1, "Amanda", "1990-01-01", 10);
		Student student = new Student(1, "Jose", "2000-01-01", 1, 1);

		student.saveToMongoDB();
		administrator.saveToMongoDB();
		teacher.saveToMongoDB();
		subject.saveToMongoDB();

		System.out.println(student);
		System.out.println(course);
		System.out.println(subject);
		System.out.println(administrator);
		System.out.println(teacher);

		MongoDatabase mongoDatabase = MongoDBConnection.connect();

		student = new Student(1, "João", "1990-01-01", 1, 1);
		subject = new Subject(2, "Database Management", "Learn about databases", 1);
		administrator = new Administrator(2, "Maria", "1985-05-05", "Human Resources");

		MongoCollection<Document> userCollection = mongoDatabase.getCollection("users");
		MongoCollection<Document> teacherCollection = mongoDatabase.getCollection("teacher");
		MongoCollection<Document> administratorCollection = mongoDatabase.getCollection("administrator");
		MongoCollection<Document> subjectCollection = mongoDatabase.getCollection("subject");

		// Inserir Student
		Document studentDocument = new Document("userId", student.userId)
				.append("name", student.name)
				.append("dateOfBirth", student.dateOfBirth)
				.append("userType", "Student");
		userCollection.insertOne(studentDocument);

		// Exibir informações de Student
		for (Document doc : userCollection.find()) {
			Integer userId = doc.getInteger("userId");
			String name = doc.getString("name");
			String dateOfBirth = doc.getString("dateOfBirth");

			if (userId != null && name != null && dateOfBirth != null) {
				System.out.println("User ID: " + userId + ", Name: " + name + ", Date of Birth: " + dateOfBirth);
			}
		}

		// Inserir Subject
		Document subjectDocument = new Document("subjectId", subject.subjectId)
				.append("subjectName", subject.subjectName)
				.append("description", subject.description)
				.append("courseId", subject.courseId);
		subjectCollection.insertOne(subjectDocument);

		// Exibir informações de Subject
		for (Document doc : subjectCollection.find()) {
			Integer subjectId = doc.getInteger("subjectId");
			String subjectName = doc.getString("subjectName");
			String description = doc.getString("description");
			Integer courseId = doc.getInteger("courseId");

			if (subjectId != null && subjectName != null && description != null && courseId != null) {
				System.out.println("Subject ID: " + subjectId + ", Name: " + subjectName +
						", Description: " + description + ", Course ID: " + courseId);
			}
		}

		// Inserir Administrator
		Document administratorDocument = new Document("userId", administrator.userId)
				.append("name", administrator.name)
				.append("dateOfBirth", administrator.dateOfBirth)
				.append("userType", "Administrator")
				.append("department", administrator.department);
		administratorCollection.insertOne(administratorDocument);

		// Exibir informações de Administrator
		for (Document doc : administratorCollection.find()) {
			Integer userId = doc.getInteger("userId");
			String name = doc.getString("name");
			String dateOfBirth = doc.getString("dateOfBirth");
			String department = doc.getString("department");

			if (userId != null && name != null && dateOfBirth != null && department != null) {
				System.out.println("Admin ID: " + userId + ", Name: " + name +
						", Date of Birth: " + dateOfBirth + ", Department: " + department);
			}
		}
	}
}
