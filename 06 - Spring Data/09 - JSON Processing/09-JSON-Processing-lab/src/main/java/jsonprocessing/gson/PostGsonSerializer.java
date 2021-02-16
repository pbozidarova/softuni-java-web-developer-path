package jsonprocessing.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import jsonprocessing.entity.Post;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;

public class PostGsonSerializer implements JsonSerializer<Post> {
    private static final DateTimeFormatter format =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public JsonElement serialize(Post post, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject postJsonObject = new JsonObject();
        postJsonObject.addProperty("id", post.getId());
        postJsonObject.addProperty("title", post.getTitle());
        postJsonObject.addProperty("content", post.getContent());
        postJsonObject.addProperty("author", post.getAuthor().getFirstName()+ " " + post.getAuthor().getLastName());
        postJsonObject.addProperty("imageUrl", post.getImageUrl());
        postJsonObject.addProperty("created", post.getCreated().format(format));
        postJsonObject.addProperty("modified", post.getModified().format(format));

        return postJsonObject;
    }
}
