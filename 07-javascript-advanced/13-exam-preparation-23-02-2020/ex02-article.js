class Article {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;

        this._comments = [];
        this._likes = [];
    }

    get likes(){
        let output = '';

        if(this._likes.length == 0){
            output = `${this.title} has 0 likes`;
        }else if(this._likes.length == 1) {
            output = `${this._likes[0]} likes this article!`;
        }else{
            output = `${this._likes[0]} and ${this._likes.length -1} others like this article!`;
        }

        return output;

    }

    like (username) {
        if(this._likes.find(like => like == username)){
            throw new Error("You can't like the same article twice!");
        }
        
        if(this.creator == username){
            throw new Error("You can't like your own articles!")
        }

        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }

    dislike (username){
        let user = this._likes.find(like => like == username);

        if(!user){
            throw new Error("You can't dislike this article!");
        }

        this._likes.splice(this._likes.indexOf(user), 1);
        return `${username} disliked ${this.title}`;
    }

    comment (username, content, id){
        let currentComment = this._comments.find(cmnt => cmnt.id == id);

        if(!currentComment){
            let replies = [];
            let commentId = this._comments.length +1;
            this._comments.push({id: commentId, username, content, replies});
            return `${username} commented on ${this.title}`;
        }else{
            let replyId = currentComment.id + '.' + (currentComment.replies.length + 1);
            
            currentComment.replies.push({id: replyId, username, content});
            return `You replied successfully`;
        }
    }

    toString(sortingType){
        let output = '';
        output += `Title: ${this.title}\n`;
        output += `Creator: ${this.creator}\n`;
        output += `Likes: ${this._likes.length}\n`;
        output += `Comments:\n`;
        
        this._comments.sort(this.sortBy(sortingType)).forEach(comment => {
            output += `-- ${comment.id}. ${comment.username}: ${comment.content}\n`
            if(comment.replies.length > 0){
                comment.replies.sort(this.sortBy(sortingType))
                    .forEach(reply => {output += `--- ${reply.id}. ${reply.username}: ${reply.content}\n`});
            }
        });

        return output.trim();
    }

    sortBy(type) {
        if (type === 'asc') {
            return (a, b) => a.id - b.id;
        } else if (type === 'desc') {
            return (a, b) => b.id - a.id;
        }
        return (a, b) => a.username.localeCompare(b.username);
    }
}


let art = new Article("My Article", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
// console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));
