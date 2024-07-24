package com.example.myboard.domain.member.entity;

import com.example.myboard.domain.board.entity.Board;
import com.example.myboard.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@Getter
@SQLDelete(sql = "UPDATE memeber SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false") //delete된 회원정보를 못들고옴
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String encryptedPassword;
    private String name;
    private String phoneNumber;
    private String address1;
    private String address2;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Board> board;
    private Boolean deleted = Boolean.FALSE;

}
