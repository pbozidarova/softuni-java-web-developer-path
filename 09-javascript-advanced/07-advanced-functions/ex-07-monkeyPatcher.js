// Your employer placed you in charge of an old forum management project. The client requests new functionality, but the legacy code has high 
// coupling, so you don’t want to change anything, for fear of breaking everything else. You know which values need to be accessed and modified,
//  so it’s time to monkey patch!
// Write a program to extend a forum post record with voting functionality. It needs to have the options to upvote, downvote and tally 
// the total score (positive minus negative votes). Furthermore, to prevent abuse, if a post has more than 50 total votes, the numbers 
// must be obfuscated – the stored values remains the same, but the reported amounts of upvotes and downvotes have a number added to them. 
// This number is 25% of the greater number of votes (positive or negative), rounded up. The actual numbers should not be modified, just the 
// reported amounts.
// Every post also has a rating, depending on its score. If positive votes are the overwhelming majority (>66%), the rating is hot. If there 
// is no majority, but the balance is non-negative and either votes are more than 100, its rating is controversial. If the balance is negative, 
// the rating becomes unpopular. If the post has less than 10 total votes, or no other rating is met, it’s rating is new regardless of balance. 
// These calculations are performed on the actual numbers.
// Your function will be invoked with call(object, arguments), so treat it as though it is internal for the object. A forum post, to which the 
// function will be attached, has the following structure:
// The arguments will be one of the following strings:
// •	upvote – increase the positive votes by one
// •	downvote – increase the negative votes by one
// •	score – report positive and negative votes, balance and rating, in an array; obfuscation rules apply

solve = (() => {
    const commands = {
        upvote: (post) => post.upvotes++,
        downvote: (post) => post.downvotes++,
        score: (post) => {
            let {upvotes, downvotes} = post;
            let total = upvotes + downvotes;
            let balance = upvotes - downvotes;

            let obfuscated = 0;
            if(total > 50){
                obfuscated = Math.ceil(0.25 * Math.max(upvotes, downvotes));
                upvotes += obfuscated;
                downvotes += obfuscated;
            }
            let rating = '';
            if (total < 10) rating = 'new';
            
            if(upvotes > total * 0.66){
                rating = 'hot';
            } else if (balance >= 0 && (upvotes > 100 || downvotes > 100)){
                rating = 'controversial';
            }else if (balance < 0) {
                rating = 'unpopular';
            } 
            return [upvotes, downvotes, balance, rating];
        }
    }
    return {call: (post, command) => commands[command](post)};
})();

let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};

solve.call(post, 'upvote');
solve.call(post, 'downvote');
let score = solve.call(post, 'score'); // [127, 127, 0, 'controversial']
solve.call(post, 'downvote');       // (executed 50 times)
score = solve.call(post, 'score');     // [139, 189, -50, 'unpopular']