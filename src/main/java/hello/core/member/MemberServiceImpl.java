package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 왜 final를 쓰고 static은 안쓰는가?? -> 메모리 관리(객체의 라이플 사이클)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
