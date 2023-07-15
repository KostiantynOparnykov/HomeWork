package homework.Module_13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;


public class Main {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, InterruptedException {

        //1-1 POST new user
        Gson gson = new Gson();
        User newUser = new User().getDefaultUser();
        HttpUtils.sendPost(URI.create(USERS_URL), newUser);
        System.out.println("====================");

        //1-5 GET user info by id
        int id = 1;
        String uriID = USERS_URL + "/" + id;
        User userGetById = HttpUtils.sendGet(URI.create(uriID));
        System.out.println("Get User by id " + id + " = " + gson.toJson(userGetById));
        System.out.println("====================");

        //1-6 GET user info by username
        String userName = "Antonette";
        String uriUserName = USERS_URL + "?username=" + userName;
        String userGetByUsername = HttpUtils.getData(uriUserName);
        System.out.println("Get User by username " + userName + " = " + userGetByUsername);
        System.out.println("====================");

        //1-2 PUT user after GET by id
        userGetById.setName("Vasily");
        User userPut = HttpUtils.sendPut(URI.create(uriID), userGetById);
        System.out.println("PUT User id " + id + " name " + gson.toJson(userPut));
        System.out.println("====================");

        //1-4 GET all users info
        System.out.println("All users info " + HttpUtils.getData(USERS_URL));
        System.out.println("====================");


        //1-3 DELETE user after GET by id
        HttpUtils.sendDelete(URI.create(uriID));
        System.out.println("====================\n");

        //2 Output and writing to file all comments for the last user post

        int userId = 1;
        int lastPostId = HttpUtils.getUserLastPostId(userId);
        String comments = HttpUtils.getCommentsToPost(lastPostId);
        System.out.println("User LAST POST {" + lastPostId + "} all COMMENTS: \n\n" + comments);
        File file = new File("user-"+userId+"-post-"+lastPostId+"-comments.json");
        gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(comments, fileWriter);
//        fileWriter.write(comments);
//        fileWriter.flush();
        fileWriter.close();
        System.out.println("====================\n");

        //3 All user undone tasks output

        System.out.println("User " + userId + " UNDONE jobs = " + HttpUtils.userToDosAmount(userId, false));
    }
}



