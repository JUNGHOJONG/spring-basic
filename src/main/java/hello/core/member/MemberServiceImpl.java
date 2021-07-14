package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 왜 final를 쓰고 static은 안쓰는가??
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
