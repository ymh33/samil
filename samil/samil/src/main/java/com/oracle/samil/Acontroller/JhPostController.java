package com.oracle.samil.Acontroller;





import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.oracle.samil.Amodel.Posts;
import com.oracle.samil.JhService.Paging;
import com.oracle.samil.JhService.PostsService;


import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/jh")
@RequiredArgsConstructor
public class JhPostController {
	
	private final PostsService ps;
	
	//(공지)토탈로 게시글 수 가져와서 페이징작업
	@GetMapping(value = "/postNotice")
	public String postNotice(Posts posts, Model model) {
	    System.out.println("jh postNotice play~");
	    
	    int totalPosts = ps.totalPosts();
	    
	    if ( posts.getCurrentPage() == null) posts.setCurrentPage("1");
		// Paging 작업
		Paging   page = new Paging(totalPosts, posts.getCurrentPage());
	   
	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());

	    List<Posts> myposts = ps.listPosts(posts); 
	    
	    model.addAttribute("totalPosts", totalPosts);
	    model.addAttribute("listPosts", myposts);
	    model.addAttribute("page", page);

	    return "jh/postNotice";
	}
	
	//(공지)검색기능 검색된 게시글수 가져와서 페이징작업
	@RequestMapping(value = "listSearch3")
	public String listSearch3(Posts posts, Model model) {

		
		int totalSearchPosts = ps.totalSearchPosts(posts);
		System.out.println("controller start listSearch3...");
		System.out.println("controller listSearch3 posts->"+posts);
		System.out.println("controller listSearch3 totalSearchPosts->"+totalSearchPosts);
		// Paging 작업
		Paging   page = new Paging(totalSearchPosts, posts.getCurrentPage());

	   
	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());
	    
		List<Posts> listSearchPosts = ps.listSearchPosts(posts);
		model.addAttribute("totalPosts", totalSearchPosts);
		model.addAttribute("listPosts",listSearchPosts);
		model.addAttribute("page",page);
		System.out.println("controller listSearch3 page->"+page);

		return "jh/postNotice";
	}
	
	 //  공지 자유 자주 상세 게시물 조회
	@GetMapping("detailPosts/{postId}")
	public String detailPosts(@PathVariable("postId") int postId, Model model) {
	    // 상세 게시물 조회
		ps.increaseViewCount(postId);
	    Posts posts = (Posts) ps.detailPosts(postId);
	    model.addAttribute("posts", posts);
	    return "jh/detailPosts";
	}

	@GetMapping("writeNotice")
    public String writeNotice(Model model) {
		
        return "jh/writeNotice"; // 게시물 작성 페이지 반환
    }	
	
	//글작성 기능 + 첨부파일
	@PostMapping(value = "writePost")
	public String writePost(Posts posts, Model model) {
	    if (!posts.getFileName().isEmpty()) {
	        // UUID 생성
	        String uuid = UUID.randomUUID().toString();
	        // 파일 이름 설정
	        posts.setFileName(null);
	        // 파일 저장 코드 (여기에 저장 로직 추가)
	    }

	    int insertResult = ps.writePost(posts);

	    if (insertResult > 0) {
	        model.addAttribute("message", "게시물이 성공적으로 작성되었습니다.");
	        return "redirect:/jh/postNotice"; // 성공 시 리다이렉트
	    } else {
	        model.addAttribute("message", "게시물 작성에 실패했습니다.");
	        return "jh/writeNotice"; // 실패 시 게시물 작성 페이지 반환
	    }
	}
	//삭제
	@RequestMapping(value = "/deletePosts", method = RequestMethod.GET)
	public String deletePosts(@RequestParam("postsId") int postsId, Model model) {
	    System.out.println("Controller start delete...");
	    int result = ps.deletePosts(postsId);
	    if (result > 0) {
	        System.out.println("Post deleted successfully");
	    }
	    return "redirect:/jh/postNotice";  // 삭제 후 목록으로 이동
	}
	
	
	
		@GetMapping("updatePosts")
		public String updatePosts(@RequestParam("postId") int postId 
				                   , Model model) {
	    	System.out.println("Controller updatePosts postId-->"+postId);
		    Posts posts = (Posts) ps.detailPosts(postId);
		    model.addAttribute("posts", posts);
		    return "jh/updatePosts";
	}
		
		
	   @PostMapping(value = "updatePosts1")
	    public String updatePosts1(Posts posts, Model model,
	    		@RequestParam(value = "isPinned", required = false, defaultValue = "0") int isPinned) {
		    posts.setIsPinned(isPinned);
	    	System.out.println("Controller ps.updatePosts1 posts-->"+posts);
	    	int updateCount = ps.updatePosts(posts);
	    	System.out.println("Controller ps.updatePosts updateCount-->"+updateCount);
	    	model.addAttribute("uptCnt",updateCount);
	    	model.addAttribute("kk3","Message Test");
	    
	    	return "redirect:/jh/postNotice";
	    
	    }



    /////////////////////자주묻는질문게시글////////////////////////
	@GetMapping(value = "/postFaq")
	public String postFaq (Posts posts,Model model){
		
		int totalPosts1 = ps.totalPosts1();
		
		if ( posts.getCurrentPage() == null) posts.setCurrentPage("1");
		// Paging 작업
		Paging   page = new Paging(totalPosts1, posts.getCurrentPage());
	   
	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());
		
		System.out.println("jh postFaq play~");
		List<Posts> mypost1 = ps.listPosts1(posts);
		model.addAttribute("totalPosts1", totalPosts1);
		model.addAttribute("listPosts1",mypost1);
		model.addAttribute("page", page);
		return "jh/postFaq";
	}
	

	
	//검색기능 검색된 게시글수 가져와서 페이징작업
	@RequestMapping(value = "listSearch4")
	public String listSearch4(Posts posts, Model model) {

		
		int totalSearchPosts1 = ps.totalSearchPosts1(posts);
		System.out.println("controller start listSearch3...");
		System.out.println("controller listSearch3 posts->"+posts);
		System.out.println("controller listSearch3 totalSearchPosts->"+totalSearchPosts1);
		// Paging 작업
		Paging   page = new Paging(totalSearchPosts1, posts.getCurrentPage());

	   
	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());
	    
		List<Posts> listSearchPosts1 = ps.listSearchPosts1(posts);
		
		model.addAttribute("totalPosts1", totalSearchPosts1);
		model.addAttribute("listPosts1",listSearchPosts1);
		model.addAttribute("page",page);
		System.out.println("controller listSearch3 page->"+page);

		return "jh/postFaq";
	}
	
	   @GetMapping("writeFaq")
	   public String writeFaq(Model model) {
			
	       return "jh/writeFaq"; // 게시물 작성 페이지 반환
	   }	
		
		//글작성 기능 + 첨부파일
		@PostMapping(value = "writeFaq")
		public String writeFaq(Posts posts, Model model) {
		    if (!posts.getFileName().isEmpty()) {
		        // UUID 생성
		        String uuid = UUID.randomUUID().toString();
		        // 파일 이름 설정
		        posts.setFileName(null);
		        // 파일 저장 코드 (여기에 저장 로직 추가)
		    }

		    int insertResult = ps.writeFaq(posts);

		    if (insertResult > 0) {
		        model.addAttribute("message", "게시물이 성공적으로 작성되었습니다.");
		        return "redirect:/jh/postFaq"; // 성공 시 리다이렉트
		    } else {
		        model.addAttribute("message", "게시물 작성에 실패했습니다.");
		        return "jh/writeFaq"; // 실패 시 게시물 작성 페이지 반환
		    }
		}
	
		@RequestMapping(value = "/deletePostsFaq", method = RequestMethod.GET)
		public String deletePostsFaq(@RequestParam("postsId") int postsId, Model model) {
		    System.out.println("Controller start delete...");
		    int result = ps.deletePosts(postsId);
		    if (result > 0) {
		        System.out.println("Post deleted successfully");
		    }
		    return "redirect:/jh/postFaq";  // 삭제 후 목록으로 이동
		}
		
		@GetMapping("detailPostsFaq/{postId}")
		public String detailPostsFaq(@PathVariable("postId") int postId, Model model) {
		    // 상세 게시물 조회
			ps.increaseViewCount(postId);
		    Posts posts = (Posts) ps.detailPosts(postId);
		    model.addAttribute("posts", posts);
		    return "jh/detailPostsFaq";
		}
		
		@GetMapping("updatePostsFaq")
		public String updatePostsFaq(  @RequestParam("postId") int postId 
				                   , Model model) {
	    	System.out.println("Controller updatePosts postId-->"+postId);
		    Posts posts = (Posts) ps.detailPosts(postId);
		    model.addAttribute("posts", posts);
		    return "jh/updatePostsFaq";
	}
		
		
	   @PostMapping(value = "updatePostsFaq")
	    public String updatePostsFaq(Posts posts, Model model) {
	    
	    	System.out.println("Controller ps.updatePosts1 posts-->"+posts);
	    	int updateCount = ps.updatePosts(posts);
	    	System.out.println("Controller ps.updatePosts updateCount-->"+updateCount);
	    	model.addAttribute("uptCnt",updateCount);
	    	model.addAttribute("kk3","Message Test");
	    
	    	return "redirect:/jh/postFaq";
	    
	    }
		
		

	

	/////////////자유게시판//////////////////////////////////////////////
	@GetMapping(value = "/postFree")
	public String postFree (Posts posts,Model model){
		int totalPosts2 = ps.totalPosts2();
		
		if ( posts.getCurrentPage() == null) posts.setCurrentPage("1");
		// Paging 작업
		Paging   page = new Paging(totalPosts2, posts.getCurrentPage());
	   
	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());

		System.out.println("jh postFree play~");
		List<Posts> mypost2 = ps.listPosts2(posts);
		model.addAttribute("totalPosts2", totalPosts2);
		model.addAttribute("listPosts2",mypost2);
		model.addAttribute("page", page);
		return "jh/postFree";
	}
	@RequestMapping(value = "listSearch5")
	public String listSearch5(Posts posts, Model model) {

		int totalSearchPosts2 = ps.totalSearchPosts2(posts);
		System.out.println("controller start listSearch5...");
		System.out.println("controller listSearch5 posts->"+posts);
		System.out.println("controller listSearch5 totalSearchPosts->"+totalSearchPosts2);
		// Paging 작업
		Paging   page = new Paging(totalSearchPosts2, posts.getCurrentPage());

	    posts.setStart(page.getStart());
	    posts.setEnd(page.getEnd());
	    
		List<Posts> listSearchPosts2 = ps.listSearchPosts2(posts);
		
		model.addAttribute("totalPosts2", totalSearchPosts2);
		model.addAttribute("listPosts2",listSearchPosts2);
		model.addAttribute("page",page);
		System.out.println("controller listSearch3 page->"+page);

		return "jh/postFree";
	}
	@GetMapping("detailPostsfree/{postId}")
	public String detailPosts2(@PathVariable("postId") int postId, Model model) {
	    // 상세 게시물 조회
		ps.increaseViewCount(postId);
	    Posts posts = (Posts) ps.detailPosts(postId);
	    model.addAttribute("posts", posts);
	    return "jh/detailPostsfree";
	}
	
	@GetMapping("updatePostsFree")
	public String updatePostsFree(  @RequestParam("postId") int postId 
			                   , Model model) {
    	System.out.println("Controller updatePosts postId-->"+postId);
	    Posts posts = (Posts) ps.detailPosts(postId);
	    model.addAttribute("posts", posts);
	    return "jh/updatePostsFree";
}
	
	
   @PostMapping(value = "updatePostsFree")
    public String updatePostsFree(Posts posts, Model model) {
    
    	System.out.println("Controller ps.updatePosts1 posts-->"+posts);
    	int updateCount = ps.updatePosts(posts);
    	System.out.println("Controller ps.updatePosts updateCount-->"+updateCount);
    	model.addAttribute("uptCnt",updateCount);
    	model.addAttribute("kk3","Message Test");
    
    	return "redirect:/jh/postFree";
    
   }
   
   @GetMapping("writeFree")
   public String writeFree(Model model) {
		
       return "jh/writeFree"; // 게시물 작성 페이지 반환
   }	
	
	//글작성 기능 + 첨부파일
	@PostMapping(value = "writeFree")
	public String writeFree(Posts posts, Model model) {
	    if (!posts.getFileName().isEmpty()) {
	        // UUID 생성
	        String uuid = UUID.randomUUID().toString();
	        // 파일 이름 설정
	        posts.setFileName(null);
	        // 파일 저장 코드 (여기에 저장 로직 추가)
	    }

	    int insertResult = ps.writeFree(posts);

	    if (insertResult > 0) {
	        model.addAttribute("message", "게시물이 성공적으로 작성되었습니다.");
	        return "redirect:/jh/postFree"; // 성공 시 리다이렉트
	    } else {
	        model.addAttribute("message", "게시물 작성에 실패했습니다.");
	        return "jh/writeFree"; // 실패 시 게시물 작성 페이지 반환
	    }
	}
	
	@RequestMapping(value = "/deletePostsFree", method = RequestMethod.GET)
	public String deletePostsFree(@RequestParam("postsId") int postsId, Model model) {
	    System.out.println("Controller start delete...");
	    int result = ps.deletePosts(postsId);
	    if (result > 0) {
	        System.out.println("Post deleted successfully");
	    }
	    return "redirect:/jh/postFree";  // 삭제 후 목록으로 이동
	}
	
	 @GetMapping("replyfree")
	   public String replyfree(Model model) {
			
	       return "jh/replyfree"; // 게시물 작성 페이지 반환
	   }	
		

	
}
