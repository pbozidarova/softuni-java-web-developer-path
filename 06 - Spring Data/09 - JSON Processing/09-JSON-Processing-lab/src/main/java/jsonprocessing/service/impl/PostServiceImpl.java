package jsonprocessing.service.impl;

import jsonprocessing.dao.PostRepository;
import jsonprocessing.dao.UserRepository;
import jsonprocessing.entity.Post;
import jsonprocessing.exception.InvalidEntityDataException;
import jsonprocessing.exception.NonExistingEntityException;
import jsonprocessing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new NonExistingEntityException( String.format("Post with Id=%s does not exist!", id)));

    }

    @Transactional
    @Override
    public Post addPost(Post post) {
        post.setId(null);
        if(post.getAuthor() == null){
            if(post.getAuthorId() == null) {
                throw new InvalidEntityDataException("Post author is required but missing!");
            }
            post.setAuthor(
                    userRepository
                            .findById(post.getAuthorId())
                            .orElseThrow(() ->
                                    new InvalidEntityDataException(
                                            String.format("Post author with ID:%s does not exist!", post.getAuthorId() )
                                    )
                            )
            );
        }
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post updatePost(Post post) {
        getPostById(post.getId());
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public Post deletePost(Long id) {
        Post removed = getPostById(id);
        postRepository.deleteById(id);
        return removed;
    }

    @Override
    public long getPostsCount() {
        return postRepository.count();
    }
}
