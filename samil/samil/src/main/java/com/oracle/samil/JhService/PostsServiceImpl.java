package com.oracle.samil.JhService;



import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.samil.Amodel.Posts;
import com.oracle.samil.JhDao.Postsdao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {
	private final Postsdao po;

	
	@Override
	public int totalPosts() {
		int totPostsCnt = po.totalPosts();
		return totPostsCnt;
	}
	
	@Override
	public List<Posts> listPosts(Posts posts) {
		List<Posts> postsLists = null;
		System.out.println("service listPosts");
		postsLists = po.listPosts(posts);
		System.out.println("service postsList "+postsLists);
		return postsLists;
	}
	
	@Override
	public List<Posts> listSearchPosts(Posts posts) {
		List<Posts> postsSearchList = po.postsSearchLists3(posts);
		System.out.println("postsSearchList"+postsSearchList.size());
		System.out.println("listSearchPosts service");
		return postsSearchList;
	}
	
	@Override
	public int totalPosts1() {
		int totPostsCnt1 = po.totalPosts1();
		return totPostsCnt1;
	}
	@Override
	public List<Posts> listPosts1(Posts posts) {
		List<Posts> listPosts1 = null;
		System.out.println("service listPosts1");
		List<Posts> postsList1 =po.listPosts1(posts);
		return postsList1;
	}
	
	@Override
	   public int totalSearchPosts(Posts posts) {
		int totPostssearchCnt = po.totalSearchPosts(posts);
        return totPostssearchCnt;
    }

	@Override
	public Posts detailPosts(int postId) {
		Posts detailPosts = po.detailPosts(postId);
		return detailPosts;
	}

	@Override
	public int totalSearchPosts1(Posts posts) {
		int totPostssearchCnt1 = po.totalSearchPosts1(posts);
        return totPostssearchCnt1;
    }

	@Override
	public List<Posts> listSearchPosts1(Posts posts) {
		List<Posts> postsSearchList1 = po.postsSearchLists31(posts);
		System.out.println("postsSearchList"+postsSearchList1.size());
		System.out.println("listSearchPosts service");
		return postsSearchList1;
	}

	@Override
	public int totalPosts2() {
		int totPostsCnt2 = po.totalPosts2();
		return totPostsCnt2;
	}

	@Override
	public List<Posts> listPosts2(Posts posts) {
		List<Posts> postsLists2 = null;
		System.out.println("service listPosts");
		postsLists2 = po.listPosts2(posts);
		System.out.println("service postsList "+postsLists2);
		return postsLists2;
	}

	@Override
	public int totalSearchPosts2(Posts posts) {
		int totPostssearchCnt2 = po.totalSearchPosts2(posts);
        return totPostssearchCnt2;
    }

	@Override
	public List<Posts> listSearchPosts2(Posts posts) {
		List<Posts> postsSearchList2 = po.postsSearchLists32(posts);
		System.out.println("postsSearchList"+postsSearchList2.size());
		System.out.println("listSearchPosts service");
		return postsSearchList2;
	}

	@Override
	public void increaseViewCount(int postId) {
		po.increaseViewCount(postId);
		
	}

	@Override
	public int writePost(Posts posts) {
		int insertResult = 0;
		insertResult = po.writePost(posts);
		return insertResult;
	}

	@Override
	public int deletePosts(int postId) {
		int result = 0;
		System.out.println("postsservice delete start");
		result = po.deletePosts(postId);
		return result;
	}

	@Override
	public int updatePosts(Posts posts) {
		int updateCount = 0;
		updateCount  = po.updatePosts(posts);
		return updateCount;
	}

	@Override
	public int writeFree(Posts posts) {
		int insertResult = 0;
		insertResult = po.writeFree(posts);
		return insertResult;
	}

	@Override
	public int writeFaq(Posts posts) {
		int insertResult = 0;
		insertResult = po.writeFaq(posts);
		return insertResult;
	}







	


	
}
