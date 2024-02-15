package repository;
import java.util.ArrayList;
import java.util.List;

import perent.Member;

public class RepositoryMember {

    private List<Member> memberList;

    public RepositoryMember() {
        this.memberList = new ArrayList<>();
    }


    public void initializeDummyData() {

        // Tambahkan data member
        memberList.add(new Member("M-001", "Risman", "Bandung"));
        memberList.add(new Member("M-002", "Budi", "Bandung"));
        memberList.add(new Member("M-003", "Resti", "Kab. Bandung"));

    }


    public List<Member> getAllMember() {
        return this.memberList;
    }
}
