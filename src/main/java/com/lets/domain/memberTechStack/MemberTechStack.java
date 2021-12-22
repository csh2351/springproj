package com.lets.domain.memberTechStack;

import com.lets.domain.BaseTimeEntity;
import com.lets.domain.member.Member;
import com.lets.domain.tag.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MemberTechStack extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "MEMBER_TECH_STACK_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Tag tag;


    private MemberTechStack(Tag tag){
        this.tag = tag;
    }

    public static MemberTechStack createMemberTechStack(Tag tag){
        MemberTechStack memberTechStack = new MemberTechStack(tag);

        return memberTechStack;
    }
    public void setMember(Member member) {
        this.member = member;
    }
}
