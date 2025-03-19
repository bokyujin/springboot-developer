package me.bokyujin.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity //엔티티로 지정    -> @ENtity(name="member_list") 작성시 member_list라는 테이블과 매핑
@NoArgsConstructor(access= AccessLevel.PROTECTED) //기본 생성자
@AllArgsConstructor
public class Member {
    @Id //id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키를 자동으로 1씩 증가
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", updatable = false) //name이라는 not null 컬럼과 매핑
    private String name;

    public void changeName(String name){
        this.name = name;
    }


}
