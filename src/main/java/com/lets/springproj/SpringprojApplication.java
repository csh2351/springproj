package com.lets.springproj;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class SpringprojApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();


		EntityTransaction tx = em.getTransaction();

		tx.begin();

//		//==member 저장 테스트==//
//		Tag tag = Tag.createTag("spring");
//		em.persist(tag);
//
//
//		List<MemberTechStack> memberTechStackList = new ArrayList<>();
//		MemberTechStack memberTechStack = MemberTechStack.createMemberTechStack(tag);
//		memberTechStackList.add(memberTechStack);
//
//		Member member = Member.createMember("member1", memberTechStackList);
//
//
//		em.persist(member);
//


//		//==post 저장 테스트==//
//		Tag tag = Tag.createTag("spring");
//		em.persist(tag);
//
//		List<MemberTechStack> memberTechStackList = new ArrayList<>();
//		MemberTechStack memberTechStack = MemberTechStack.createMemberTechStack(tag);
//		memberTechStackList.add(memberTechStack);
//
//		Member member = Member.createMember("member1", memberTechStackList);
//
//		em.persist(member);
//
//		List<PostTechStack> postTechStacks = new ArrayList<>();
//		PostTechStack postTechStack = PostTechStack.createPostTechStack(tag);
//
//		postTechStacks.add(postTechStack);
//		Post post = Post.createPost(member, "title1", "content1", postTechStacks);
//
//		em.persist(post);
//
//
//		em.flush();
//		em.clear();
//
//		Tag findTag = em.find(Tag.class, tag.getId());
//		Post findPost = em.find(Post.class, post.getId());
//		System.out.println("tag.getPostTechStacks().size() = " + findTag.getPostTechStacks().size());
//		System.out.println("post.getPostTechStacks() = " + findPost.getPostTechStacks().size());




		//==comment 저장 테스트==//
//		Tag tag = Tag.createTag("spring");
//		em.persist(tag);
//
//		List<MemberTechStack> memberTechStackList = new ArrayList<>();
//		MemberTechStack memberTechStack = MemberTechStack.createMemberTechStack(tag);
//		memberTechStackList.add(memberTechStack);
//
//		Member member = Member.createMember("member1", memberTechStackList);
//
//		em.persist(member);
//
//		List<PostTechStack> postTechStacks = new ArrayList<>();
//		PostTechStack postTechStack = PostTechStack.createPostTechStack(tag);
//
//		postTechStacks.add(postTechStack);
//		Post post = Post.createPost(member, "title1", "content1", postTechStacks);
//
//		em.persist(post);
//
//		Comment comment = Comment.createComment(member, post, "comment1");
//
//		em.persist(comment);
//
//
//		em.flush();
//		em.clear();
//
//		Post findPost = em.find(Post.class, post.getId());
//		System.out.println("findPost.getComments().size() = " + findPost.getComments().size());


		//==LikePost 테스트==//
//		Tag tag = Tag.createTag("spring");
//		em.persist(tag);
//
//		List<MemberTechStack> memberTechStackList = new ArrayList<>();
//		MemberTechStack memberTechStack = MemberTechStack.createMemberTechStack(tag);
//		memberTechStackList.add(memberTechStack);
//
//		Member member = Member.createMember("member1", memberTechStackList);
//
//		em.persist(member);
//
//		List<PostTechStack> postTechStacks = new ArrayList<>();
//		PostTechStack postTechStack = PostTechStack.createPostTechStack(tag);
//
//		postTechStacks.add(postTechStack);
//		Post post = Post.createPost(member, "title1", "content1", postTechStacks);
//
//		em.persist(post);
//
//		LikePost likePost = LikePost.createLikePost(member, post);
//
//		em.persist(likePost);
//
//		System.out.println("member.getLikePosts().size() = " + member.getLikePosts().size());


		//==좋아요 클릭 테스트==//
//		Tag tag = Tag.createTag("spring");
//		em.persist(tag);
//
//		List<MemberTechStack> memberTechStackList = new ArrayList<>();
//		MemberTechStack memberTechStack = MemberTechStack.createMemberTechStack(tag);
//		memberTechStackList.add(memberTechStack);
//
//		Member member = Member.createMember("member1", memberTechStackList);
//
//		em.persist(member);
//
//		List<PostTechStack> postTechStacks = new ArrayList<>();
//		PostTechStack postTechStack = PostTechStack.createPostTechStack(tag);
//
//		postTechStacks.add(postTechStack);
//		Post post = Post.createPost(member, "title1", "content1", postTechStacks);
//
//		em.persist(post);
//
//		LikePost likePost = LikePost.createLikePost(member, post);
//
//		em.persist(likePost);
//
//
//
//
//
//		likePost.activateLike();
//
//		em.flush();
//		em.clear();
//
//		LikePost findLikePost = em.find(LikePost.class, likePost.getId());
//		Post findPost = em.find(Post.class, post.getId());
//
//		System.out.println("findLikePost.getStatus() = " + findLikePost.getStatus());
//		System.out.println("findPost.getLikeCount() = " + findPost.getLikeCount());
//		System.out.println("findPost.getViewCount() = " + findPost.getViewCount());
//
//
//		System.out.println("======취소 테스트======");
//
//		findLikePost.deactivateLike();
//
//		em.flush();
//		em.clear();
//
//		findLikePost = em.find(LikePost.class, likePost.getId());
//		findPost = em.find(Post.class, post.getId());
//
//		System.out.println("findLikePost.getStatus() = " + findLikePost.getStatus());
//		System.out.println("findPost.getLikeCount() = " + findPost.getLikeCount());
//		System.out.println("findPost.getViewCount() = " + findPost.getViewCount());

		tx.commit();
		em.close();
		emf.close();





	}
}
