package homework.Module_13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

class HttpUtils{
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static void sendPost(URI uri, User user) throws IOException, InterruptedException {

        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP POST Status Code is " + response.statusCode());
        System.out.println("Server response = \n" + response.body());
    }
    public static User sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP GET Status Code is " + response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }
    public static User sendPut(URI uri, User user) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP PUT Status Code is " + response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }
    public static void sendDelete(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("HTTP DELETE Status Code is " + response.statusCode());

    }
    public static String getData(String url) throws IOException {
        return Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
    }


    public static int getUserLastPostId (int userId) throws IOException {
        String allUserPosts = HttpUtils.getData(USERS_URL + "/" + userId + "/posts");
        List<UserPosts> userPosts = new Gson().fromJson(allUserPosts, new TypeToken<List<UserPosts>>() {
        }.getType());
        int maxId = 0;
        for (UserPosts userPost : userPosts) {
            if (maxId < userPost.getId()) {
                maxId = userPost.getId();
            }
        }
        return maxId;
    }
    public static String getCommentsToPost(int postId) throws IOException {
        String allComments = HttpUtils.getData(POSTS + "/" + postId + "/comments");
        List<PostComment> allPostComments = new Gson().fromJson(allComments
                , new TypeToken<List<PostComment>>(){}.getType());

        StringBuilder result = new StringBuilder();
        for (PostComment comment : allPostComments) {
            result.append(comment.getBody());
        }
        return result.toString();
    }
    public static int userToDosAmount(int userId, boolean completed) throws IOException {
        String allToDos = HttpUtils.getData(USERS_URL+"/"+userId+"/todos");
        List<ToDos> allUserToDos = new Gson().fromJson(allToDos, new TypeToken<List<ToDos>>(){}.getType());
        int undoneToDos = 0;
        for (ToDos todo : allUserToDos) {
            if(todo.isCompleted() == completed){
                undoneToDos++;
            }
        }
        return undoneToDos;
    }


}
