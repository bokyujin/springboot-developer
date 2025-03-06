package me.bokyujin.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepsitory;

    public List<Member> getAllMembers(){
        return memberRepsitory.findAll();
    }
}
