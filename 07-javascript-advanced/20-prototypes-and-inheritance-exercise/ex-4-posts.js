// Your need to create several classes for Posts.
// Implement the following classes:
// •	Post, which is initialized with title (String) and content (String)
//     o	The 2 arguments should be public members
//     o	The Post class should also have toString() function which returns the following result:
// "Post: {postTitle}"
// "Content: {postContent}"
// •	SocialMediaPost, which inherits the Post class and should be initialized with 2 additional arguments - likes (Number) and dislikes (Number). The class should hold:
//     o	comments(Strings) -  an array of strings
//     o	addComment(comment)- a function, which adds comments to that array
//     o	The class should extend the toString() function of the Post class, and should return the following result:
//         "Post: {postTitle}"
//         "Content: {postContent}"
//         "Rating: {postLikes - postDislikes}"
//         "Comments:"
//         " * {comment1}"
//         " * {comment2}"
// . . .
// In case there are no comments, return information only about the title, content and rating of the post.
// •	BlogPost, which inherits the Post class:
//     o	The BlogPost class should be initialized with 1 additional argument - views(Number).
//     o	The BlogPost class should hold 
//     - view() - which increments the views of the object with 1, every time it is called. The function should return the object, so that chaining is supported.
//     o	The BlogPost class should extend the toString() function of the Post class, and should return the following result:
//     "Post: {postTitle}"
//     "Content: {postContent}"
//     "Views: {postViews}"

function generatePostClasses() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            let output = `${super.toString()}\nRating: ${this.likes - this.dislikes}`;

            if (this.comments.length > 0) {
                output += '\nComments:\n';
                for (let comment of this.comments) {
                    output += ` * ${comment}\n`;
                }
            }

            return output.trim();
        }
    }

    class BlogPost extends Post {
        constructor(name, content, views) {
            super(name, content);
            this.views = views;
        }

        view() {
            this.views++;
            return this;
        }

        toString() {
            return super.toString() + `\nViews: ${this.views}`;
        }
    }

    return {Post, SocialMediaPost, BlogPost};
}