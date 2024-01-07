package org.example;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


public class App {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://neubportaladmin:zFhrWIVpxaFEeDF3@cluster0.lrgci3m.mongodb.net/?retryWrites=true&w=majority";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("NEUB_Sinfo");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                MongoCollection<Document> collection = database.getCollection("students");

                Document doc = collection.find(Filters.eq("id", "0562220005101030")).first();
                if (doc != null) {
//                    System.out.println(doc.toJson());
                    System.out.println(doc.getString("name"));
                    new displayUserInfo(doc);
                } else {
                    System.out.println("No matching documents found.");
                }


            } catch (MongoException e) {
                System.out.println("Something error"+ e.getMessage());
            }finally {
                mongoClient.close();
            }
        }
    }
}
