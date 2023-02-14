package com.example.blogsystem_hw27.service;

import com.example.blogsystem_hw27.apiException.ApiException;
import com.example.blogsystem_hw27.model.Blog;
import com.example.blogsystem_hw27.model.MyUser;
import com.example.blogsystem_hw27.repository.BlogRepository;
import com.example.blogsystem_hw27.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MyUserRepository myUserRepository;

    //////////////////////////////////////////////////////////
    //Get
    public List getAll() {
        return blogRepository.findAll();
    }

    public Blog getById(Integer id, Integer authId) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("Todo ID not found");
        }
        if (blog.getMyUser().getId() != authId) {
            throw new ApiException("You do not have the authority to get this Blog!");
        }
        return blog;
    }

    public List<Blog> getAllMyBlog(Integer authId) {
        MyUser myUser = myUserRepository.findMyUserById(authId);
        List<Blog> blog = blogRepository.findAllByMyUser(myUser);
        if (blog == null) {
            throw new ApiException("blog not found");
        }
        return blog;
    }

    ////////////////////////////////////////////////////////////
    public void add(Blog blog,Integer authId) {
        MyUser myUser = myUserRepository.findMyUserById(authId);
        if (myUser == null) {
            throw new ApiException("not Added");
        }
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }


    //note * *
    public void addTo(Integer userId, Integer blogId) {
        MyUser myUser = myUserRepository.findMyUserById(userId);
        Blog blog = blogRepository.findBlogById(blogId);
        if (blogId == null) {
            throw new ApiException("blog not found");
        } else if (myUser == null) {
            throw new ApiException("user not found");
        }
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }

    public void update(Blog blog, Integer blogId,Integer authId) {
        Blog blog2 = blogRepository.findBlogById(blogId);
        MyUser myUser = myUserRepository.findMyUserById(authId);
        if (blog2 == null) {
            throw new ApiException("blog not found");
        }else if(blog2.getMyUser().getId() != authId) {
           throw new ApiException("Sorry you do not have the authority to update this Blog!\"");
        }
        blog2.setMyUser(myUser);
        blog2.setId(blogId);
        blogRepository.save(blog2);
    }

    public void delete(Integer id, Integer authId) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ApiException("blog not found");
        }else if(blog.getMyUser().getId() != authId){
            throw new ApiException("SorryYou do not have the authority to delete this Blog!\"");
        }
        blogRepository.delete(blog);
    }
}
