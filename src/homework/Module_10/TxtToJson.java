package homework.Module_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class TxtToJson {
    public static void converter(){
        File file = new File("file1.txt");


        LinkedList<User> users = new LinkedList<>();

        try(Scanner scanner = new Scanner(file)){

            while(scanner.hasNextLine()){

                String line  = scanner.nextLine();
                if (line.contains("age")){
                    line = scanner.nextLine();
                }
                String[] lineArr = line.split(" ");
                String name = lineArr[0];
                int age = Integer.parseInt(lineArr[1]);
                users.add(new User(name, age));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fileWriter = new FileWriter("user.json");
            gson.toJson(users, fileWriter);
            fileWriter.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        TxtToJson.converter();
    }
}

class User{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

