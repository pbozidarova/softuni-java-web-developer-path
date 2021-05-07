package t06_objectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02Articles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String[] data = reader.readLine().split(", ");
        String title = data[0];
        String content = data[1];
        String author = data[2];
        Article article = new Article(title, content, author);

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(": ");
            String command = input[0];

            switch (command){
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}

class  Article{
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void edit(String content){
        this.content = content;
    }

    public void changeAuthor(String author){
        this.author = author;
    }

    public void rename(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",
                this.getTitle(),
                this.getContent(),
                this.getAuthor());
    }
}
