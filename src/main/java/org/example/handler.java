package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.swing.*;


public class handler {


    public static Document connectDB(CED obj, String id, int order) {

        String username = System.getenv("MONGO_DB_USERNAME");
        String password = System.getenv("MONGO_DB_PASSWORD");
        String connectionString = "mongodb+srv://"+username+":"+password+"@cluster0.lrgci3m.mongodb.net/?retryWrites=true&w=majority";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        MongoClient mongoClient = MongoClients.create(settings);
        // Send a ping to confirm a successful connection
        MongoDatabase database = mongoClient.getDatabase("NEUB_Sinfo");
        database.runCommand(new Document("ping", 1));
        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");

        if (order == 1) {
            MongoCollection<Document> collection = database.getCollection("students");
            Document doc = collection.find(Filters.eq("id", id)).first();
            return doc;
        } else if (order == 2) {
            MongoCollection<Document> collection = database.getCollection("students");
            long count = collection.deleteOne(Filters.eq("id", id)).getDeletedCount();
            if (count > 0) {
                System.out.println("Document deleted successfully.");
            } else {
                System.out.println("Document not found.");
            }
        } else if (order == 3) {
            MongoCollection<Document> collection = database.getCollection("students");
                    Document document = new Document("name", obj.sName.getText())
                    .append("id", obj.sID.getText())
                    .append("bloodGroup", obj.sBg.getText())
                    .append("email", obj.sEmail.getText())
                    .append("result", obj.sCGPA.getText())
                    .append("status", Boolean.parseBoolean(obj.sStatus.getText()));

            // Insert the document into the collection
            collection.insertOne(document);
        }

        else if (order == 4) {
            MongoCollection<Document> collection = database.getCollection("students");
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc == null) {
                JOptionPane.showMessageDialog(null, "Data Not Found, nothing to update!");
            return null;
            }
            else
                System.out.println("Updating!!");

            Document document = new Document();
            document.append("id", id);

            if (obj.sName.getText().isEmpty()) {
               document.append("name",doc.getString("name"));
            } else {
                document.append("name",obj.sName.getText());
            }

            if (obj.sBg.getText().isEmpty()) {
                document.append("bloodGroup",doc.getString("bloodGroup"));
            } else {
                document.append("bloodGroup",obj.sBg.getText());
            }

            if (obj.sEmail.getText().isEmpty()) {
                document.append("email",doc.get("email"));
            } else {
                document.append("email",obj.sEmail.getText());
            }

            if (obj.sCGPA.getText().isEmpty()) {
                document.append("result",doc.getString("result"));
            } else {
                document.append("result", obj.sCGPA.getText());
            }

            if (obj.sStatus.getText().isEmpty()) {
                document.append("status",doc.getBoolean("status"));

            } else {
                document.append("status",Boolean.parseBoolean(obj.sStatus.getText()));
            }

            collection.replaceOne(doc, document);
            System.out.println(document);

        }

        else if(order==5){
            MongoCollection<Document> collection = database.getCollection("results");
            Document doc = collection.find(Filters.eq("id", id)).first();
            return doc;
        }

            mongoClient.close();
            return null;

        }


        public static void getUserDataByID (String id){

            Document doc = connectDB(null, id, 1);

            if (doc != null) {
                new displayUserInfo(doc);
            } else {
                JOptionPane.showMessageDialog(null, "No data found! Submit the correct ID");
                new neubInfoPortal();
            }
            System.out.println("Executed getUserDataByID()");

        }

    public static void delUserData (String id){

        System.out.println(id);
        connectDB(null, id, 2);
        System.out.println("Executed delUserData()");


    }

        public static void addUserData (CED obj){

            connectDB(obj, obj.sID.getText(), 3);

            System.out.println("Executed addUserData()");

        }

    public static void updateUserData (CED obj){

        connectDB(obj, obj.sID.getText(), 4);
        System.out.println(obj.sID.getText());

        System.out.println("Executed updateUserData()");
        JOptionPane.showMessageDialog(null, "Data is updated successfully!");


    }

    public static void getResult (String id){

        System.out.println(id);
        Document doc = connectDB(null, id, 5);
        if (doc == null) {
            JOptionPane.showMessageDialog(null, "No data found! Submit the correct ID");

        }
        new  studentResult(doc);
        System.out.println("Executed getResult()");

    }


}


